# LLM
#### Training
* Pre-training: Predicting the Next Word
* Instruction Fine-tuning
* Alignment: Reinforcement Learning from Human Feedback (RLHF)

#### Evaluation
* Human evaluation:Rating Scales (e.g., Likert scale), Ranking, A/B Testing, Critique and Annotation.
  Human evaluation parameters: Fluency/Naturalness,Coherence/Consistency, Relevance/Fidelity to Prompt, Creativity/Diversity, Factuality/Truthfulness, Safety/Harmlessness, Aesthetics, Task-Specific Criteria

* For Text Generation:
Reference-based Metrics (require ground truth): 
 * BLEU (Bilingual Evaluation Understudy) - precision of n-gram overlap. Higher scores better. 
 * ROUGE (Recall-Oriented Understudy for Gisting Evaluation): Measures recall of n-gram overlap
 * METEOR (Metric for Evaluation of Translation with Explicit Ordering): Considers precision, recall, and word alignments (including stemming and synonymy)
 * CIDEr (Consensus-based Image Description Evaluation): Originally for image captioning, it measures consensus with a set of reference captions.
 * BERTScore: A more semantically aware metric that uses contextual embeddings (from BERT) to calculate similarity between generated and reference sentences

Reference-free Metrics:
* Perplexity: Measures how well a language model predicts a sample. Lower perplexity generally indicates a better model.
  Perplexity(W)=exp(− 1/N(summation of all log probabilities of each word given previous word)
  Perplexity is the exponentiated average negative log-likelihood of a sequence of words.
  Intuitive meaning: The weighted average number of choices the model has for the next word. More choices..more confused the model is.
  Not comparable across models with different vocabularies. Doesn't measure other factors liek factual accuracy.
 
* Diversity metrics:
 * Distinct-N: Measures the number of unique n-grams in the generated text, indicating how diverse the vocabulary is.
 * Self-BLEU/Self-ROUGE: Compares each generated sample against other generated samples to detect lack of diversity or mode collapse (higher self-BLEU indicates less diversity).
* Coherence/Fluency Scores: Often rely on pre-trained language models to assign scores based on grammatical correctness and semantic flow.
* Factuality Metrics: Emerging metrics use knowledge bases or entailment models to check if generated statements are factually correct.
* Safety/Toxicity Scores: Use classifiers (e.g., Perspective API) to detect toxic, biased, or harmful language.

* For Image Generation:

Reference-based Metrics (require ground truth images):
* PSNR (Peak Signal-to-Noise Ratio): Measures pixel-wise similarity. Simple but doesn't always correlate well with human perception.
* SSIM (Structural Similarity Index): Measures structural similarity, luminance, and contrast. Better aligns with human visual perception than PSNR.
* LPIPS (Learned Perceptual Image Patch Similarity): Uses a pre-trained deep neural network to measure perceptual similarity between images, which correlates better with human judgment.

Reference-free Metrics (often compare distributions of real vs. fake images):
* Inception Score (IS): Measures both the quality (clarity of objects) and diversity of generated images using a pre-trained Inception model. Higher IS is better.
* Fréchet Inception Distance (FID): Compares the statistical properties (mean and covariance of features from an Inception model) of generated images to real images. Lower FID indicates higher quality and diversity, as it suggests the generated distribution is closer to the real one. It's often considered a more robust metric than IS.
* CLIPScore / CLIP-based Metrics: Leverages the CLIP model's ability to align images and text. Used to assess prompt alignment (how well the generated image matches its text description) and aesthetic quality.
* Diversity metrics: Beyond IS/FID, specific metrics can quantify the variety of generated samples, especially to detect mode collapse.

#### Handling catastrophic forgetting while finetuning
* Rehearsal-Based Methods - Data Replay/Experience Replay: a small subset of data from previous tasks is stored and "replayed" (re-trained alongside the new data). If old data is not available,use self synthesized data.
* Regularization-Based Methods:
  * Elastic Weight Consolidation (EWC): Identifies "important" weights for previously learned tasks (e.g., using the Fisher Information Matrix). It then adds a regularization term to the loss function during new task training, penalizing large changes to these important weights. 
  * Synaptic Intelligence (SI): Tracks contribution of each weight to the loss over time and penalizes changes to those weights that have been consistently important.
  * Learning without Forgetting (LwF): This method uses knowledge distillation. When learning a new task, the original pre-trained model (or a model trained on previous tasks) acts as a "teacher" and provides "soft targets" (probability distributions over outputs) for the new data. The fine-tuned model then tries to match these soft targets while also learning the new task, thereby retaining previous knowledge.
  * Hierarchical Layer-Wise and Element-Wise Regularization: Calculating parameter importance at both the element-wise and layer-wise levels and more nuanced regularization.
* Architectural Methods:
 * Parameter-Efficient Fine-Tuning (PEFT): Like LoRA (Low-Rank Adaptation) and Prefix-Tuning introduce a small number of trainable parameters while keeping the vast majority of the pre-trained LLM's weights frozen. 
 * Progressive Neural Networks (ProgNets): This approach involves adding a new "column" or network for each new task. Each new column is connected to previously trained columns, allowing it to leverage prior knowledge without directly modifying the weights of older tasks.
 * Memory-Augmented Models
 * Dynamic Architectures
* Optimization-Based Methods:
 * Sharpness-Aware Minimization (SAM): Some research suggests a direct link between the flatness of the model's loss landscape and the extent of catastrophic forgetting. SAM aims to find flatter minima in the loss landscape during training, which can lead to better generalization and potentially mitigate forgetting.
 * Multi-objective Optimization
