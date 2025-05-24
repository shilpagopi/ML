#LLM
Training
* Pre-training: Predicting the Next Word
* Instruction Fine-tuning
* Alignment: Reinforcement Learning from Human Feedback (RLHF)

#### Handling catastrophic forgetting while finetuning
* Rehearsal-Based Methods - Data Replay/Experience Replay: a small subset of data from previous tasks is stored and "replayed" (re-trained alongside the new data). If old data is not available,use self synthesized data.
* Regularization-Based Methods:
  * Elastic Weight Consolidation (EWC): Identifies "important" weights for previously learned tasks (e.g., using the Fisher Information Matrix). It then adds a regularization term to the loss function during new task training, penalizing large changes to these important weights. 
  * Synaptic Intelligence (SI): Tracks contribution of each weight to the loss over time and penalizes changes to those weights that have been consistently important.
  * Learning without Forgetting (LwF): This method uses knowledge distillation. When learning a new task, the original pre-trained model (or a model trained on previous tasks) acts as a "teacher" and provides "soft targets" (probability distributions over outputs) for the new data. The fine-tuned model then tries to match these soft targets while also learning the new task, thereby retaining previous knowledge.
  * Hierarchical Layer-Wise and Element-Wise Regularization: Calculating parameter importance at both the element-wise and layer-wise levels and more nuanced regularization.
