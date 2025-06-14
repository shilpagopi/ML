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



## Pre-training 
<img width="731" alt="image" src="https://github.com/user-attachments/assets/b6bfee6a-0eb9-4d3b-8349-d5abdfd1d48e" />
Unidirectional encoding is implemented through "causal mask" in the self-attention mechanism.
Practical Tips: 
For causal language modeling, the labels are typically the input IDs shifted by one.
DataCollatorForLanguageModeling handles this automatically.
Code line: data_collator = DataCollatorForLanguageModeling(tokenizer=tokenizer, mlm=False)
mlm=True: The data collator will randomly mask a percentage of tokens in the input sequences and the model will be trained to predict the original masked tokens. This is common for training BERT-like models.
mlm=False: The data collator will prepare the data for causal language modeling, where the model predicts the next token in the sequence. This is common for training GPT-like models.






