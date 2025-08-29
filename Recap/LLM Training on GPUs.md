# LLM Training on GPUs

## Size Estimation
* Model Parameters: 1B param =~ 4GB in FP32. FP32 means each parameter requires 4 bytes, FP16 requires 2.
* Optimizer States: Largest memory consumer. Optimizers like AdamW maintain extra tensors for tracking gradients and momentum, double the size for parameters.
* Gradients: Required for backpropagation. These usually match the precision of your model weights. Also, add another full copy of the parameter count to your VRAM requirements.
* Activations: The wild card in the equation. These vary based on batch size, sequence length, and model architecture. They can be managed through techniques like gradient checkpointing.

These components add up to the ~16GB per 1B parameter rule of thumb?
flash attention (which might save you 10-20%.)? 
gradient checkpointing?
Use FSDP / ZeRO for Efficient Training
* FSDP (Fully Sharded Data Parallel) distributes memory across multiple GPUs.?
* ZeRO (Zero Redundancy Optimizer) reduces optimizer memory overhead.?
Use High-Bandwidth Storage: Use NVMe SSDs instead of HDDs for storing models and datasets.?

#### Size required for different techniques and model sizes
<img width="1050" height="268" alt="Screenshot 2025-08-29 at 12 24 33 PM" src="https://github.com/user-attachments/assets/a547bd29-4e3c-40f0-be21-d360efe25612" />
* Full Model ->LORA (1/4th)
* LORA to QLORA with half precision (~60%)
* QLORA to QLORA half precision (1/2)

#### Training and Inference
You can train a 64 GB model on four 16 GB GPUs using parallelism techniques to split the workload. A 64 GB model, assuming FP16 precision, requires 64 GB of memory just for the model parameters. This far exceeds the capacity of a single 16 GB GPU, so you must distribute the model across multiple GPUs.

Training a 64 GB Model on Four 16 GB GPUs
The most effective method for this scenario is Fully Sharded Data Parallelism (FSDP), often implemented with techniques like Microsoft's DeepSpeed ZeRO.

Fully Sharded Data Parallelism (FSDP)
FSDP is a sophisticated training strategy that shards (partitions) the model's parameters, gradients, and optimizer states across multiple GPUs. This means no single GPU holds a complete copy of the model.


How it works: Instead of each GPU having a full copy of the model, each of the four 16 GB GPUs holds only a fraction of the model (1/4th of the parameters, gradients, and optimizer states).

Memory Savings: For a 64 GB model in FP16, the parameters alone take up 64 GB. The optimizer states and gradients can add another 2 to 4 times that amount. FSDP significantly reduces the per-GPU memory footprint by distributing these components.


The Process:

During the forward pass, a GPU needs the full weights of a layer to compute its activations. FSDP temporarily "gathers" the required weight shards from the other GPUs.

After the computation for that specific layer is complete, the gathered weights are freed, and the GPU only keeps its original portion.

This process is repeated for each layer, and a similar process happens in reverse during the backward pass to compute gradients.

This dynamic loading and unloading of weights allows the entire model to be trained even though it is too large for any single GPU.

Speeding Up Inference
Training and inference are different workloads. During inference, you don't need to store gradients or optimizer states, which dramatically reduces memory requirements. Even so, running a large model like a 64 GB one on a single GPU can be slow. Here's how to speed up inference:

1. Model Parallelism
If a model is too large to fit on a single GPU (like your 64 GB model on a 16 GB GPU), you must use model parallelism for inference. This is similar to the training approach. The model is split across the four GPUs.

How it works: Each GPU is responsible for a different part of the model (e.g., layers 1-20 on GPU 1, layers 21-40 on GPU 2, and so on). Data flows sequentially through the GPUs, with the output of one GPU becoming the input of the next.

Trade-off: This method reduces memory pressure but can introduce communication latency as data is passed between GPUs.

2. Quantization
Quantization is the process of converting a model's weights from a high-precision format (like FP16) to a lower-precision format (like INT8 or INT4).

Memory Savings: A 64 GB model in FP16 becomes a 32 GB model in INT8, potentially allowing it to fit on two 16 GB GPUs instead of four. An INT4 version would be even smaller. This reduces the number of GPUs needed, which in turn reduces communication overhead.

Performance: Lower precision data types can be processed faster by the hardware, which can increase inference speed.

3. Inference Engines
Specialized software and libraries are designed to optimize model inference specifically for production environments.

NVIDIA TensorRT: This is a key tool for NVIDIA GPUs. TensorRT optimizes models by fusing layers, tuning kernels for specific hardware, and applying quantization to create a highly efficient "engine" for inference. This can provide significant speedups—often 2x or more—over standard PyTorch or TensorFlow.

DeepSpeed Inference: Part of the DeepSpeed library, this tool offers similar optimizations for large-scale inference, including custom kernels and model partitioning, to reduce latency and increase throughput.

## Hardware
The NVIDIA A100 is a data center GPU designed for AI and high-performance computing (HPC). It's built on the Ampere architecture and comes most commonly with 40GB or 80GB of memory.
6,912 CUDA Cores (general-purpose parallel processing),432 Tensor Cores (accelerating matrix multiplication)

