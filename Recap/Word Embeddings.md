# Word Embeddings
### Glove vs Word2vec
#### Similar Properties
* The relationship between words is derived by cosine distance between words. 
* Semantically similar words are close together.
* Valid arithmetic on these embedding vectors. Eg. “Berlin-Germany+France=Paris”.    
* Obtain phrasal embeddings by adding up word embeddings

#### Differences
Glove model is based on leveraging global word to word co-occurance counts leveraging the entire corpus.  
Word2vec on the other hand leverages co-occurance within local context (neighbouring words).  

##### Word2vec Trained models
![](https://machinelearninginterview.com/wp-content/uploads/2019/02/CBOW_eta_Skipgram-1024x481.png)

##### Glove Training
Glove is based on matrix factorization techniques on the word-context matrix. It first constructs a large matrix of (words x context) co-occurrence information, i.e. for each “word” (the rows), you count how frequently we see this word in some “context” (the columns) in a large corpus.  The number of “contexts” is of course large, since it is essentially combinatorial in size.

So then we factorize this matrix to yield a lower-dimensional (word x features) matrix, where each row now yields a vector representation for the corresponding word. In general, this is done by minimizing a “reconstruction loss”. This loss tries to find the lower-dimensional representations which can explain most of the variance in the high-dimensional data.

(Words x Context) = (Words x Features) * (Features x Context) 
