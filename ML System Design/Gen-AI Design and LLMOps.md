# Gen-AI Design and LLMOps

#### Architecture
* Off-the-shelf APIs are fast to deploy, require less maintenance, and offer high performance but come with a higher cost, less control, and potential data privacy concerns.
* Open-source models offer full control, better cost management for high volume, and data privacy but require significant infrastructure and MLOps expertise.
* A single large model is simpler to manage but can be expensive and inefficient for varied tasks. A combination of specialized models (e.g., one for summarization, another for Q&A) can be more cost-effective and performant but adds architectural complexity.
* RAG vs Finetuning: RAG brings in latency

### Deployment
*  FastAPI is great for a simple REST API wrapper, while Triton Inference Server is a specialized tool for high-throughput, low-latency model serving.  Deploy on GPUs/TPUs with Triton or vLLM for efficient serving.

### Cost and Latency Optimization
* using smaller models, quantizing models, using spot instances?, and leveraging caching for repeated requests, prompt caching, optimizing the inference stack (e.g., with frameworks like TensorRT),



  
