# Text Processing
* Models for Short Text (For short, concise texts like tweets, search queries, or single sentences):
  * Embeddings: Bag-of-Words (BoW) & TF-IDF, Word2Vec, Glove, FastText, SentenceBert (Most common: 768, all-MiniLM-L6-v2: 384, stsb-bert-large:1024)
  * Models: RNNs,CNNs
* Medium to Long Text (512 to 1024 tokens):
  * Embeddings: Doc2Vec (Paragraph Vector) (dim hyperparameter between 50-300), BERT/RoBERTa (512 tokens), Sentence-T5 (768, T5-large:1024 and T5-3B:4096)
  * Models:LSTMs, GRUs, Transformer Models
* Models for Very Long Text: Chukning and Summarization, Long-Context Transformer Models (like LongFormer using sparse attention, BigBird)
