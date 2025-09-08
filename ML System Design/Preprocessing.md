## Tokenization
<img width="787" alt="image" src="https://github.com/user-attachments/assets/ae0bc217-cf79-4e14-b717-0a8f07d77a9e" />

## Handling Text Inputs
* Models for Short Text (For short, concise texts like tweets, search queries, or single sentences):
  * Embeddings: Bag-of-Words (BoW) & TF-IDF, Word2Vec, Glove, FastText, SentenceBert (Most common: 768, all-MiniLM-L6-v2: 384, stsb-bert-large:1024)
  * Models: RNNs,CNNs
* Medium to Long Text (512 to 1024 tokens):
  * Embeddings: Doc2Vec (Paragraph Vector) (dim hyperparameter between 50-300), BERT/RoBERTa (512 tokens), Sentence-T5 (768, T5-large:1024 and T5-3B:4096)
  * Models:LSTMs, GRUs, Transformer Models
* Models for Very Long Text:
  * Chunking and Summarization
  * Long-Context Transformer Models: like LongFormer(4,096 tokens) using sparse attention, BigBird(4,096 tokens), LongT5 (16,384 tokens)
  * Hierarchical Transformer Models:
   Lower Level (Sentence Encoding): A model like SBERT processes each sentence independently to create a sentence embedding. 
Higher Level (Document Encoding): The sequence of sentence embeddings is then fed into a second transformer model. This higher-level transformer learns the relationships between the sentences, capturing the overall context, topic, and structure of the entire paragraph or document.

## Image Preprocessing
Resizing: Models usually require fixed image sizes (e.g., 224×224)
Scaling: Scale pixel values of the image to the range of 0 and 1
Z-score normalization: Scale pixel values to have a mean of 0 and variance of 1
Consistent : Ensuring images have a consistent color mode (e.g., RGB or CMYK)

Data augmentation: random crop, random saturation, vertical/horizontol flip, rotation/translation, affine transformation, changing brighness saturation contrast
offline: augment images before training, faster, need additional storage to store augmented images.
online: augment images on the fly during training, slow training, doens't consume additional storage.
Some output labels may need to be aptly modified based on transformations.

## Video Preprocessing
Process whole video(expensive) using 3D convolutions or transformers if capturing actions/motions/temporal semantics are relevant. 
<img width="550" alt="image" src="https://github.com/user-attachments/assets/81cd9dc8-811d-4503-9df3-214266db50e3" />

<img width="792" alt="image" src="https://github.com/user-attachments/assets/e5aba919-ddb4-4b1b-a080-27235876d639" />
<img width="708" alt="image" src="https://github.com/user-attachments/assets/bb70bbfd-c787-4419-bc57-d5753bde8fc4" />

