# Tranformers
##### Advantages
* Capture long range dependencies using attention mechanism (which RNNs struggle with)
* Parallel processing

##### Core components
* Encoder: Processes the input sequence into a sequence of representations.   
* Decoder: Generates the output sequence based on the encoder's output.   
* Attention mechanism: Allows the model to focus on different parts of the input sequence when making predictions.

## Attention
Scaled Dot-Product Attention
The attention mechanism operates on three main components: Queries (Q), Keys (K), and Values (V).

Imagine you're trying to find relevant information in a database:

Query (Q): What you're looking for (e.g., "Show me documents about machine learning.").
Keys (K): Labels or indices that categorize the information in the database (e.g., "NLP," "Computer Vision," "Machine Learning algorithms").
Values (V): The actual information content associated with those keys (e.g., the full text of documents categorized as "Machine Learning algorithms").
The attention mechanism calculates how "relevant" each Key is to the Query, and then uses these "relevance scores" to take a weighted sum of the Values.

Steps and Dimensions:

Let's assume:

seq_len: Length of the input sequence (number of tokens).
d_model: The dimensionality of the input embedding for each token (also known as d_embed or hidden_size). This is the main dimension of the Transformer model.
d_k: The dimension of the Query and Key vectors. In the original Transformer, d_k = d_v = d_model / num_heads.
Input Embeddings:

Each token in the input sequence is first converted into a dense vector embedding.
Input: Token embeddings (e.g., after adding positional encodings) for a sequence of length seq_len.
Dimension: (seq_len, d_model)
Linear Transformations to Q, K, V:
For each input embedding vector (corresponding to a token), three separate linear transformations are applied to create its Query, Key, and Value vectors. These transformations are learned during training via weight matrices.

Query Weights (W_Q): (d_model, d_k)
Key Weights (W_K): (d_model, d_k)
Value Weights (W_V): (d_model, d_v) (where d_v is typically equal to d_k)
When applied to the entire input sequence matrix (X):

Query Matrix (Q): Q=XW_Q
Dimension: (seq_len, d_model) x (d_model, d_k) = (seq_len, d_k)
Key Matrix (K): K=XW_K
Dimension: (seq_len, d_model) x (d_model, d_k) = (seq_len, d_k)
Value Matrix (V): V=XW_V
Dimension: (seq_len, d_model) x (d_model, d_v) = (seq_len, d_v)
Calculate Attention Scores (Similarity):
The core idea is to calculate how well each Query matches each Key. This is done using a dot product.

Operation: QK(transpose)
Dimension: (seq_len, d_k) x (d_k, seq_len) = (seq_len, seq_len)
This resulting (seq_len, seq_len) matrix contains a score for every possible pair of (Query from token i, Key from token j).
Scaling:
The dot product scores are scaled by dividing by the square root of d_k. This is done to prevent the dot products from becoming too large, which could push the softmax function into regions with tiny gradients, making training difficult.
​Dimension: Remains (seq_len, seq_len)
Softmax Activation (Attention Weights):
A softmax function is applied **row-wise** to the scaled scores. This converts the scores into a probability distribution, where each row sums to 1. These are the attention weights. Each weight indicates how much attention the current token (row's Query) should pay to other tokens (columns' Keys).
Dimension: Remains (seq_len, seq_len)

Output: Attention_Weights (matrix)
Weighted Sum of Values:
Finally, the attention weights are multiplied by the Value matrix. This effectively sums up the Value vectors, weighted by how relevant their corresponding Keys were to the Query.

Operation: softmax{Attention_Weights).V
Dimension: (seq_len, seq_len) x (seq_len, d_v) = (seq_len, d_v)
Output: This (seq_len, d_v) matrix is the output of one attention head. Each row is a new, contextually rich representation of a token, formed by attending to all other tokens in the sequence.

II. Multi-Head Attention
Instead of performing a single attention calculation, Multi-Head Attention allows the model to jointly attend to information from different representation subspaces at different positions. It does this by:

Parallel Attention Heads: It divides the d_model dimension into h (number of heads) smaller dimensions. For each head i, it projects the input into Q_i, K_i, V_i using separate learned weight matrices.

Dimension for each head:
d_k_head = d_model / h
d_q_head = d_k_head
d_v_head = d_model / h (typically d_k_head = d_v_head)
Weight Matrices for each head i:(d_model, d_k_head)

Each head then performs the scaled dot-product attention independently:
Output of each head i: (seq_len, d_v_head)
Concatenation: The outputs from all h attention heads are concatenated along the d_v_head dimension.

Operation: Concat(head_1, ..., head_h)
Dimension: (seq_len, h * d_v_head) = (seq_len, d_model) (since h * (d_model / h) = d_model)
Final Linear Transformation: The concatenated output is then passed through a final linear layer with a weight matrix W_O (d_model, d_model)
Operation: MultiHead(Q,K,V)=Concat(all_heads)*W_O 
Output: (seq_len, d_model) x (d_model, d_model) = (seq_len, d_model)
This final (seq_len, d_model) output is the context-aware representation of the input sequence, ready to be passed to the next layer (e.g., a feed-forward network or another attention layer).

##### Types of Attention in Transformers:
* Self-Attention (Intra-Attention): Used in both the encoder and decoder. Queries, Keys, and Values all come from the same sequence (the input sequence for the encoder, or the previously generated part of the output sequence for the decoder).
* Encoder-Decoder Attention (Cross-Attention): Used in the decoder. Queries come from the decoder's previous layer output, while Keys and Values come from the encoder's output. This allows the decoder to focus on relevant parts of the input sequence when generating the output.
* Masked Self-Attention (Causal Attention): Used in the decoder for training. It's a special type of self-attention where future tokens are "masked out" (set to negative infinity before softmax) to prevent the model from "cheating" by looking at subsequent tokens when predicting the current one. This ensures that the generation process remains autoregressive (only depends on past information).

##### Types of Attention:
* Scaled Dot product attention discussed above.
  
* Additive Attention (Bahdanau Attention):
Concept: Unlike dot-product attention which relies on a multiplicative interaction (dot product), additive attention computes alignment scores using a feed-forward neural network with a single hidden layer.
How it works: It combines the query and key vectors (often from different sequences, e.g., encoder hidden states and decoder hidden states) and passes them through a tanh activation function, followed by a linear transformation and then softmax. The formula often looks something like: 
​(h_i,s_j) = v*  tanh(W[h i;s j])  (?)
Context: This was a popular attention mechanism before the Transformer introduced scaled dot-product attention, particularly in sequence-to-sequence models with Recurrent Neural Networks (RNNs).

* Local Attention:
Concept: Traditional (global) attention mechanisms compute attention weights over the entire input sequence, which can be computationally expensive for very long sequences (quadratic complexity). Local attention addresses this by restricting the attention mechanism to a smaller, localized window around a certain position in the sequence.
Benefit: Reduces computational complexity, making it more efficient for long sequences, especially when the relevant information is likely to be found in a local context (e.g., in time series data or very long documents).

* Linear Attention:
Concept: A class of attention mechanisms that aim to reduce the quadratic complexity of standard attention to linear complexity with respect to sequence length.
How it works: Instead of the dot product followed by softmax, linear attention typically uses a different similarity function (e.g., a kernel function or a combination of operations) that allows for the factorization of the attention matrix, leading to linear time and space complexity.
Examples: Performer, Linformer, and models like BASED utilize linear attention variants. This is particularly relevant for handling extremely long sequences in large language models.
