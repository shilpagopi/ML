# LLM Training on GPUs

## Size Estimation
* Model Parameters: The foundation of your LLM. FP32 means each parameter requires 4 bytes, FP16 requires 2.
* Optimizer States: Often the largest memory consumer. Traditional optimizers like AdamW maintain multiple copies of the parameters.
* Gradients: Required for backpropagation. These usually match the precision of your model weights. Also, add another full copy of the parameter count to your VRAM requirements.
* Activations: The wild card in the equation. These vary based on batch size, sequence length, and model architecture. They can be managed through techniques like gradient checkpointing.

These components add up to the ~16GB per 1B parameter rule of thumb?
flash attention (which might save you 10-20%.)? 
gradient checkpointing?

#### Size required for different techniques and model sizes
<img width="1050" height="268" alt="Screenshot 2025-08-29 at 12 24 33 PM" src="https://github.com/user-attachments/assets/a547bd29-4e3c-40f0-be21-d360efe25612" />
* Full Model ->LORA (1/4th)
* LORA to QLORA with half precision (~60%)
* QLORA to QLORA half precision (1/2)

## Hardware
The NVIDIA A100 is a data center GPU designed for AI and high-performance computing (HPC). It's built on the Ampere architecture and comes most commonly with 40GB or 80GB of memory.
6,912 CUDA Cores (general-purpose parallel processing),432 Tensor Cores (accelerating matrix multiplication)

