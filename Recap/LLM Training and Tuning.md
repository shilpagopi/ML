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
Pros: Reduced trainable parameters, Faster training, Lower training compute, Reduced storage, Mitigates catastrophic forgetting  
Cons: May not reach the absolute peak performance of full fine-tuning  

### Quantization-aware Low-Rank Adaptation (QLoRA)
What it is: QLoRA builds upon LoRA by performing LoRA fine-tuning on a quantized version of the pre-trained LLM. 
How it works: Original model weights are stored in a lower precision format (e.g., 4-bit integers instead of 16-bit floating points) using "4-bit NormalFloat (NF4)" quantization, but performs computations in a higher precision. It then applies LoRA on top of these quantized weights.

Pros: Drastically lower memory usage: (e.g., Llama-2 70B on a single 48GB GPU). Retains most of LoRA's performance benefits with practically negligible degradation.
Cons: Slightly more complex to set up due to quantization, Slight potential performance degradation 

Practical Tips:
* Optional Quantization: Load models in a quantized format (e.g., 4-bit or 8-bit using bitsandbytes library)
  model = AutoModelForCausalLM.from_pretrained(
    MODEL_NAME,
    load_in_4bit=True,          # Load in 4-bit (QLoRA)
    torch_dtype=torch.bfloat16, # Use bfloat16 for computation if supported
    device_map="auto"           # Automatically map model layers to available devices
)
* prepare_model_for_kbit_training(model):
  * This casts the lm_head and embed_tokens layers to full precision for stability (acoid significant info loss)
  * lm_head: This layer is typically the "language model head" or "output head" of the model. It's responsible for mapping the hidden states of the model to the vocabulary probabilities (i.e., predicting the next token).
  * embed_tokens: This layer is the "embedding layer." It converts input token IDs into dense vector representations (embeddings) that the rest of the model can process.
  
* Parameters: 
  * r (LoRA rank): The rank of the low-rank matrices. A higher rank means more trainable parameters, potentially better performance but higher memory/compute.
  * lora_alpha: A scaling factor for the LoRA weights.
  * target_modules: Which layers of the LLM to apply LoRA to (e.g., query, key, value, output projections in attention).
  * lora_dropout: Dropout applied to the LoRA weights.

## Pre-training 
<img width="731" alt="image" src="https://github.com/user-attachments/assets/b6bfee6a-0eb9-4d3b-8349-d5abdfd1d48e" />
Unidirectional encoding is implemented through "causal mask" in the self-attention mechanism.
Practical Tips: 
For causal language modeling, the labels are typically the input IDs shifted by one.
DataCollatorForLanguageModeling handles this automatically.
Code line: data_collator = DataCollatorForLanguageModeling(tokenizer=tokenizer, mlm=False)
mlm=True: The data collator will randomly mask a percentage of tokens in the input sequences and the model will be trained to predict the original masked tokens. This is common for training BERT-like models.
mlm=False: The data collator will prepare the data for causal language modeling, where the model predicts the next token in the sequence. This is common for training GPT-like models.






