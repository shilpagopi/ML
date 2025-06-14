# LLM Training and Tuning
## Full Fine-Tuning
What: Tune the entire model's weights (Initialize a new training head (e.g., a classification layer for text classification, or a generation head for text generation) if the task is different from the pre-training objective.)  
Pros: Potentially highest performance, Maximum flexibility  
Cons: Computationally expensive, Time-consuming, Prone to catastrophic forgetting, Large storage requirements  

Practical Tips: 
* Choose small models (e.g., Llama 2, Mistral, GPT-2, T5).
* using the LLM's tokenizer tokenizer 
* Add a padding token if the tokenizer doesn't have one (common for GPT-style models). Usually, tokenizer.pad_token = tokenizer.eos_token
* Choose MLM or CLM mode: masked language modeling or causal language modeling
* Models like Llama 2 7B require at least 24GB of VRAM (e.g., an NVIDIA 3090, 4090, or A100). 
* Multi-GPU/Distributed Training: For larger models larger or faster training, use accelerate (Hugging Face's tool) or PyTorch's DistributedDataParallel (DDP) or libraries like DeepSpeed.  
  
## Parameter-Efficient Fine-Tuning (PEFT) Methods
### LORA
What: Training a small subset of the model's parameters or by adding a few new trainable parameters  
What it is: LoRA works by freezing the original pre-trained model weights and injecting small, trainable low-rank matrices into each transformer layer. Instead of directly optimizing the original weight matrix, it optimizes these much smaller "adapter" matrices.  
How it works: For a weight matrix W0, LoRA adds an update W0+ΔW, where ΔW=BA_transpose. B and A are low-rank matrices (e.g., A is d×r and B is r×k, where r≪min(d,k)). Only A and B are trained.  
<img width="739" alt="image" src="https://github.com/user-attachments/assets/00157dbc-11d0-4f1e-b2dc-47b03b99d1ab" />

Pros: Reduced trainable parameters, Faster training, Lower training compute, Reduced storage, Mitigates catastrophic forgetting  
Cons: May not reach the absolute peak performance of full fine-tuning  

### Quantization-aware Low-Rank Adaptation (QLoRA)
What it is: QLoRA builds upon LoRA by performing LoRA fine-tuning on a quantized version of the pre-trained LLM.   
How it works: Original model weights are stored in a lower precision format (e.g., 4-bit integers instead of 16-bit floating points) using "4-bit NormalFloat (NF4)" quantization, but performs computations in a higher precision. It then applies LoRA on top of these quantized weights.  

Pros: Drastically lower memory usage: (e.g., Llama-2 70B on a single 48GB GPU). Retains most of LoRA's performance benefits with practically negligible degradation.  
Cons: Slightly more complex to set up due to quantization, Slight potential performance degradation   

Practical Tips:  
* Optional Quantization: Load models in a quantized format (e.g., 4-bit or 8-bit using bitsandbytes library)
```
  model = AutoModelForCausalLM.from_pretrained(
    MODEL_NAME,
    load_in_4bit=True,          # Load in 4-bit (QLoRA)
    torch_dtype=torch.bfloat16, # Use bfloat16 for computation if supported
    device_map="auto"           # Automatically map model layers to available devices
)
```
* prepare_model_for_kbit_training(model):
  * This casts the lm_head and embed_tokens layers to full precision for stability (acoid significant info loss)
  * lm_head: This layer is typically the "language model head" or "output head" of the model. It's responsible for mapping the hidden states of the model to the vocabulary probabilities (i.e., predicting the next token).
  * embed_tokens: This layer is the "embedding layer." It converts input token IDs into dense vector representations (embeddings) that the rest of the model can process.
* trainer.model.save_pretrained(OUTPUT_DIR): only the small LoRA adapter weights are saved, not the entire base model.
* During inference, load base model and merge the peft model or adapter weights. peft_model = PeftModel.from_pretrained(base_model, OUTPUT_DIR); merged_model = peft_model.merge_and_unload()
* Parameters: 
  * r (LoRA rank): Higher values (e.g., 8, 16, 32, 64) generally lead to more expressiveness but also more trainable parameters and a slight increase in memory. Start with 8 or 16. A higher rank means more trainable parameters, potentially better performance but higher memory/compute. 
  * lora_alpha: A scaling factor for the LoRA weights. Often set to 2 * r.
  * target_modules: Which layers of the LLM to apply LoRA to (e.g., query, key, value, output projections in attention).
  * lora_dropout: Dropout applied to the LoRA weights.
 
### Adapter Methods (Eg.Adapter-H (Houlsby Adapters/Bottleneck Adapters)
Adapter methods insert small, new neural network modules (adapters). The most common adapter architecture involves a bottleneck structure: a down-projection, a non-linearity, and an up-projection. These are often inserted after attention layers and/or feed-forward layers.

The General Idea of Adapter Insertion
A standard Transformer block typically consists of a Multi-Head Self-Attention (MHSA) sub-layer and a Feed-Forward Network (FFN) sub-layer. Both of these are usually followed by a residual connection and layer normalization. The core idea of adapters is to insert a small, trainable module after one or both of these existing frozen layers.

If we denote the output of a Transformer sub-layer (e.g., MHSA or FFN) as h_in, the general formula for a layer with an inserted adapter becomes:
h_out =Adapter(h_in)+h_in

This indicates a residual connection around the adapter itself, meaning the adapter learns to apply a small "correction" or "adaptation" to the original hidden state.

Pros: Parameter efficient, Fast training, Modular: Adapters can be swapped out easily for different tasks.  
Cons: May not be as widely adopted or as performant as LoRA for all tasks.

<img width="718" alt="image" src="https://github.com/user-attachments/assets/6e2fc38e-52af-4826-abd2-b0e80090b9b6" />

Practical Tips:
* Hyper parameters for Adapters:
  * adapter_reduction_factor (bottleneck size). This is the crucial hyperparameter for adapters, often derived from a reduction_factor. If reduction_factor = k, then m=d/k. For example, if d=768 and reduction_factor=16, then m=768/16=48.
  * non_linearity (activation function)
  * where to insert them (target_modules or implicitly by task_type): In practice, for Causal Language Models, adapters are often inserted after both the attention and feed-forward parts of each transformer block.

```
adapter_config = AdapterConfig(
    adapter_reduction_factor=ADAPTER_REDUCTION_FACTOR,
    non_linearity=NON_LINEARITY,
    # These are the default insertion points for Houlsby adapters in Peft for Causal LM
    # You can customize `target_modules` if you want adapters in specific layers.
    # For Causal LM, TaskType.CAUSAL_LM automatically targets common layers.
    task_type=TaskType.CAUSAL_LM,

```
```
peft_model_loaded = PeftModel.from_pretrained(base_model, OUTPUT_DIR)

# Adapters are generally not merged into the base model in the same way LoRA is,
# they remain separate modules. So, you typically use `peft_model_loaded` directly.

```
<img width="721" alt="image" src="https://github.com/user-attachments/assets/217b824e-3395-4df6-92b0-4b0fc15a5642" />

### Prefix-Tuning
Prefix-Tuning adds trainable tokens to the input sequence.
Learns a small, continuous, task-specific "prefix" that is prepended to the input embeddings at **each layer** of the transformer.

Prefix projection:   
<img width="742" alt="image" src="https://github.com/user-attachments/assets/b326ae80-d011-4d7c-b845-51c4ebdf9d8b" />
<img width="725" alt="image" src="https://github.com/user-attachments/assets/a50ce9c8-27b4-4af7-a660-30d35adcf4ad" />

<img width="735" alt="image" src="https://github.com/user-attachments/assets/d2b1935c-d26c-4044-a8f4-76c9495e28d4" />

Practical Tips: 
```
prefix_config = PrefixTuningConfig(
    num_virtual_tokens=NUM_PREFIX_TOKENS,
    encoder_hidden_size=model.config.hidden_size, # Typically the model's hidden size
    prefix_projection=True, # Recommended for better performance
    encoding_type=ENCODING_TYPE,
    task_type=TaskType.CAUSAL_LM,
)
```
* TaskType: When initializing the PEFT configuration (AdapterConfig, PrefixTuningConfig), specifying task_type (e.g., TaskType.CAUSAL_LM, TaskType.SEQ_CLS, TaskType.SEQ_2_SEQ_LM) helps the peft library automatically select appropriate layers for adapter insertion or prefix application.
* Prefix-Tuning: num_virtual_tokens (number of prefix tokens), encoder_hidden_size (model's hidden dimension), and prefix_projection (whether to add a small MLP to project the prefix tokens, generally recommended).
* Learning Rate: These methods might benefit from higher learning rates than LoRA or full fine-tuning (e.g., 1e−3 for Prefix-Tuning is common).
* Quantization: These methods can also be combined with 4-bit or 8-bit quantization (bitsandbytes) for further memory savings, just like QLoRA. You would load the base model with load_in_4bit=True and then apply the PEFT method on top.

Pros: Extremely Parameter-Efficient, No Architectural Changes (Unlike adapters), Task-Specific Context/"soft prompt"  
Cons: Performance Variability (sensitive to the choice of num_virtual_tokens and learning rate), Training Stability: Can be less stable than LoRA, especially without prefix_projection=True.

## Pre-training 
<img width="731" alt="image" src="https://github.com/user-attachments/assets/b6bfee6a-0eb9-4d3b-8349-d5abdfd1d48e" />
Unidirectional encoding is implemented through "causal mask" in the self-attention mechanism.
Practical Tips: 
For causal language modeling, the labels are typically the input IDs shifted by one.
DataCollatorForLanguageModeling handles this automatically.
Code line: data_collator = DataCollatorForLanguageModeling(tokenizer=tokenizer, mlm=False)
mlm=True: The data collator will randomly mask a percentage of tokens in the input sequences and the model will be trained to predict the original masked tokens. This is common for training BERT-like models.
mlm=False: The data collator will prepare the data for causal language modeling, where the model predicts the next token in the sequence. This is common for training GPT-like models.






