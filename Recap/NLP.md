# NLP

### Classical NLP
* Stemming vs Lemmatization - eg. "better" ->stemmed:"better", lemmatized:"good"
* Pragmatic ambiguity - "I went to the bank"
* TF-IDF (Term Frequency-Inverse Document Frequency) formulae:
    * TF(W) = (Frequency of W in a document)/(The total number of terms in the document)
    * IDF(W) = log_e(The total number of documents/The number of documents having the term W)
    * Refer to log_e graph, If word is very common, IDF = log(~1) = 1. Else IDF increases as the term becomes rarer. IDF acts as a multiplier with value >=1
* What are regular expressions?
* Latent Semantic Indexing (LSI):
    * underlying principle: words carry a similar meaning when used in a similar context.
    * detect the hidden (latent) correlation between semantics (words)
    * SVD (singular value decomposition) technique: matrix contains rows for words and columns for documents.
    * handle static and unstructured data, generally
 
### LLM Training and Inference
* Self-supervised learning or Pretraining - as a next word predictor
* SFT: Supervised fine-tuning or instruction tuning - Prompts and sample inputs by human labeler are given as a labeled dataset.
* RLHF: Reinforcement Learning from Human Feedback - Generate multiple outputs, human ranks, train a reward model and freeze, optimize base model for higher rewards. Why RLHF - For human alignment, to maximize helpfulness, minimize harm, reduce dishonesty.      

