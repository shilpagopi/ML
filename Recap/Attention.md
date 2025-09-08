# Attention
### At A Glance

* The computational complexity of the standard self-attention mechanism is O(n^2⋅d) in terms of time and O(n2) in terms of space, where n is the sequence length and d is the model dimension.
* Types: Additive Attention (Bahdanau Attention) (check formulae below), Scaled Dot-Product Attention
* Attention Masking: Padding Masking and Look-Ahead Masking (negative infinity scores)
* Efficient Techniques: Sparse (local,global), Kernel based methods like Linformer and Performer: ~O(n.d) or O(nlogn), Low Rank Factorization
---

#### Types of Attention
* Additive Attention (Bahdanau Attention): More complex and computationally expensive.
<img width="779" height="577" alt="image" src="https://github.com/user-attachments/assets/535ef0eb-4ed4-4fa6-af4a-102ba07133a1" />

* Scaled Dot-Product Attention: standard for modern Transformer-based models, used for computational efficiency and simplicity

#### Attention Masking
How: Attention masking is the process of preventing an attention head from looking at certain tokens. This is done by adding a large negative value (e.g., -1e9) to the attention scores for the tokens to be masked, so that after the softmax function is applied, their attention weights become effectively zero.

Where: 
* Padding Masking: When training a batch of sequences, they are often padded to a uniform length. A padding mask is applied to prevent the model from attending to these meaningless padding tokens, ensuring that the model doesn't waste computational resources or learn spurious relationships from them.
* Look-Ahead Masking: In a decoder, during autoregressive generation (e.g., text generation), a look-ahead mask is used to prevent the model from "cheating" by attending to future tokens. It ensures that the prediction for a given token depends only on the tokens that have already been generated, preserving the sequential nature of generation.

#### Efficient attention
1. Sparse Attention
Instead of having every token attend to every other token, sparse attention methods limit the connections to a predefined, structured pattern. This reduces the number of pairwise computations.

Local Attention: Tokens only attend to other tokens within a fixed-size window around them. This is efficient for tasks where local context is most important.

Global Attention: A few selected tokens (e.g., [CLS] tokens or special "global" tokens) are allowed to attend to all other tokens, and all other tokens attend to them. This creates a few long-range connections while keeping the overall complexity low.

Combinations: Models like Longformer and BigBird combine local and global attention patterns to balance efficiency with the ability to capture long-range dependencies.

2. Kernel-Based Methods
These methods re-formulate the softmax function in the attention mechanism to avoid the explicit computation of the n×n attention matrix. By leveraging the properties of kernels, they can transform the attention calculation from Q×K T×V into a more efficient form like Q×(K_T×V), which can be computed with linear complexity.

Linformer and Performer are examples of this approach. They use a low-rank approximation or a kernel trick to achieve a complexity of O(n⋅d) or O(n⋅logn), respectively.

3. Recurrence with Attention
This approach breaks long sequences into smaller, manageable chunks. The model processes one chunk at a time, but it uses a memory mechanism to carry forward information from previous chunks. This allows the model to maintain a long-term context without needing to compute attention over the entire sequence at once.

Transformer-XL introduced this concept of a "memory" of past states, which allows it to handle sequences far longer than its attention window.

4. Low-Rank Factorization
This method assumes that the attention matrix is low-rank and can be approximated by multiplying two smaller matrices. This reduces the complexity from O(n2) to O(n⋅k) where k is the rank of the approximation.

# Rough work

3. Explain Self-Attention and Why It’s Important in Transformers
_________
Get a leg up on your competition with the Grokking the Advanced System Design Interview course and land that dream job!

Self-attention is a process where each word in a sequence considers every other word in the sequence to establish context. It’s crucial in transformers because it enables them to understand the relationships between words regardless of their position in the input. This is key to capturing global dependencies and producing high-quality embeddings for downstream tasks.

4. What Are the Key Components of a Transformer Model?
_________
Get a leg up on your competition with the Grokking the Advanced System Design Interview course and land that dream job!

The main components of a transformer are the encoder, the decoder, and the self-attention and feedforward layers within each. Encoders process the input sequence, while decoders generate the output sequence, typically in sequence-to-sequence tasks. The self-attention and feedforward layers, along with layer normalization and residual connections, make transformers highly efficient.

5. What Role Does Positional Encoding Play in Transformers?
_________
Don’t waste hours on Leetcode. Learn patterns with the course Grokking the Coding Interview: Patterns for Coding Questions.

Unlike RNNs, transformers lack inherent sequence order. Positional encoding is added to the input embeddings to introduce order by assigning unique vectors to each position in the sequence. This allows the model to differentiate between tokens in a sequence, capturing relative and absolute positions of each word in the context.

6. How Do Transformers Handle Large Input Sequences?
_________
Land a higher salary with Grokking Comp Negotiation in Tech.

Transformers handle large input sequences through multi-head attention, which divides attention into smaller “heads” that process data in parallel. However, longer sequences lead to higher computational costs. Various adaptations, like Longformer and Reformer, have been developed to reduce these costs and enable transformers to process longer sequences efficiently.

7. What is Multi-Head Attention, and Why is It Useful?
_________
Land a higher salary with Grokking Comp Negotiation in Tech.

Multi-head attention is a technique where multiple self-attention operations are run in parallel, each focusing on different parts of the input. The results are then combined, allowing the model to capture multiple types of relationships in a single forward pass. This improves the model’s ability to understand different contextual dependencies simultaneously.

8. Describe the Encoder-Decoder Structure in Transformers
_________
Get a leg up on your competition with the Grokking the Advanced System Design Interview course and land that dream job!

Transformers use an encoder-decoder structure in sequence-to-sequence tasks like translation. The encoder processes the input data and generates context-rich embeddings, which the decoder then uses to produce the output sequence. This structure makes transformers highly flexible for applications like text generation and language modeling.

9. How Do Transformers Compare to RNNs and CNNs in NLP Tasks?
_________
Don’t waste hours on Leetcode. Learn patterns with the course Grokking the Coding Interview: Patterns for Coding Questions.

Transformers outperform RNNs and CNNs in NLP tasks due to their parallel processing capabilities, which speed up training significantly. While RNNs are sequential and struggle with long dependencies, transformers leverage self-attention to capture these dependencies efficiently. Transformers have largely replaced RNNs and CNNs in NLP due to their superior scalability and performance on large datasets.

10. What Are Some Popular Transformer-Based Models?
_________
Don’t waste hours on Leetcode. Learn patterns with the course Grokking the Coding Interview: Patterns for Coding Questions.

Several transformer-based models have achieved state-of-the-art results across NLP and computer vision. Notable examples include BERT (Bidirectional Encoder Representations from Transformers) by Google, GPT (Generative Pre-trained Transformer) by OpenAI, and T5 (Text-To-Text Transfer Transformer) by Google. These models have various applications, from sentiment analysis to machine translation
