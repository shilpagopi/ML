# Tokenization
#### Byte Pair Encoding (BPE)
It works by iteratively merging the most frequent pairs of characters or character sequences in a text corpus to form new, longer subword units. 
The process continues until a predefined vocabulary size is reached or no more merges can be made.
Models using BPE: GPT series (GPT-2, GPT-3, GPT-4), RoBERTa (often a variant called Byte-level BPE), BART, XLM.

Advantages:
* Handles OOV(out of vocab) words
* Manages vocabulary size: It creates a fixed-size vocabulary that is larger than character-level but much smaller than word-level, striking a good balance.
* Captures common morphological units: Learns prefixes, suffixes, and common word roots.
* Simplicity: The algorithm is relatively straightforward to implement.
* Better than character based tokenization as it would increase in the input sequence length.

Disadvantages:
* Greedy approach: May not always result in the linguistically most intuitive or optimal subword segmentation.
* Fixed vocabulary size: Requires pre-defining the target vocabulary size, which can be a hyperparameter to tune.
* Can create non-linguistic tokens: no semantic meaning on their own.

#### WordPiece
WordPiece is similar to BPE but uses a different merging criterion. Instead of simply merging the most frequent character pairs, WordPiece aims to select the pair that, when merged, results in the largest increase in the likelihood of the training data. This is typically achieved by finding the pair that maximizes the probability of the new subword in the language model trained on the corpus.
Models using WordPiece: BERT, DistilBERT, ALBERT.

How it works: \
Initial vocabulary: Starts with all individual characters in the corpus, often pre-tokenizing into words first (e.g., by whitespace).
Iterative merging:
For all possible pairs of existing subword units, calculate the likelihood increase if they were merged. This often involves a scoring function based on frequency: score= 
frequency(A)×frequency(B)/frequency(AB)
Merge the pair that yields the highest score.
Add the new subword to the vocabulary.
Update the corpus.
Repeat: Continue until the desired vocabulary size is reached.

Advantages:
* Improved segmentation: Often produces more linguistically meaningful subwords than vanilla BPE because it optimizes for a language modeling objective.
* Effective for OOV words: Similar to BPE, it handles OOV words by breaking them down into known subword units.
* Efficient for morphologically rich languages: Can effectively represent complex words by combining smaller, meaningful units.

Disadvantages:
* More complex merging criterion: The likelihood-based merging is computationally more involved than simple frequency counting.
* Depends on pre-tokenization: Typically assumes words are already split by whitespace, which might be an issue for languages without clear word boundaries (like Chinese, Japanese, Korean).


#### SentencePiece
SentencePiece is a more general and language-independent subword tokenization system developed by Google. A key distinction is that it treats the input text as a raw stream of characters (including whitespace) rather than relying on pre-tokenized words. This makes it particularly suitable for languages like Chinese, Japanese, and Korean, where word boundaries are not explicitly marked by spaces. SentencePiece implements both BPE and Unigram Language Model (ULM) algorithms.
Models using SentencePiece: T5, XLNet, ALBERT (can use SentencePiece for tokenization)

How it works (for BPE and ULM variants):
Raw text processing: It doesn't assume pre-tokenized words. Instead, it processes the raw character stream, including spaces, which are often escaped with a special character (e.g., _).
Vocabulary learning:
BPE (in SentencePiece): Similar to standard BPE, it iteratively merges frequent character/subword pairs.
Unigram Language Model (ULM): This is a probabilistic approach. It starts with a large initial vocabulary (e.g., all characters and common substrings). Then, it iteratively prunes tokens from the vocabulary based on how much their removal reduces the likelihood of the training corpus, aiming to optimize the overall likelihood. The goal is to find the smallest set of subwords that can represent the corpus with minimal loss of information.
Lossless encoding/decoding: By treating whitespace as a regular character (escaped), SentencePiece ensures that the original text can be perfectly reconstructed from its tokenized form, which is crucial for tasks like machine translation.

Advantages:
* Language-agnostic: Does not rely on language-specific pre-tokenization rules, making it highly versatile for multilingual models and languages without explicit word boundaries.
* Lossless tokenization: Enables perfect reconstruction of the original text from tokens, which is important for many NLP tasks.
* Flexible vocabulary size: Can be trained to produce a fixed vocabulary size.
* Supports multiple algorithms: Offers both BPE and Unigram Languge Model, allowing users to choose based on their needs.

Disadvantages:
* More complex implementation: Can be more involved to set up and train compared to simple word-level tokenizers.
* Subwords may not always align with human intuition: While effective, the generated subwords might not always correspond to clear morphological units from a human linguistic perspective.
