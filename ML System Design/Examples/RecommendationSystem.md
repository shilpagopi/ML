# Recommendation System
<img width="792" alt="image" src="https://github.com/user-attachments/assets/f4c8bf3c-16a3-40f2-9aed-3e50e6f023b4" />
<img width="498" alt="image" src="https://github.com/user-attachments/assets/2c66c953-03f1-42df-b7b6-5aef00611a9d" />
<img width="641" alt="image" src="https://github.com/user-attachments/assets/2220f1d2-4798-4677-aa3c-17b2b7cc95e5" />
<img width="641" alt="image" src="https://github.com/user-attachments/assets/9d6d358f-6063-4215-baf9-d429beb27c41" />
<img width="661" alt="image" src="https://github.com/user-attachments/assets/cc0dbf86-d14b-4527-9e94-a675d21ca7be" />

### Two-tower neural network
Two-tower neural networks are used for both content-based filtering and collaborative filtering. When a two-tower architecture is used for collaborative filtering, the video encoder is nothing but an embedding layer that converts the video ID into an embedding vector. This way, the model doesn't rely on other video features.

<img width="447" alt="image" src="https://github.com/user-attachments/assets/9e0d19de-8d02-498b-bd0c-2db9e1019d95" />
<img width="802" alt="image" src="https://github.com/user-attachments/assets/2f151aa8-a442-4fab-a064-938596c61ec8" />

#### Data Collection, Training, Inference 
##### Negative Samples
Negative Samples: It's not feasible to use all non-interactions, as the number would be astronomically large. Instead, various negative sampling strategies are used, such as:

* Random Negative Sampling: Randomly selecting non-interacted items from the entire corpus.
* In-Batch Negative Sampling: Using the other items within the same mini-batch as negative samples for each positive pair. This is a highly efficient method and is a common practice.
* Hard Negative Mining: Selecting non-interacted items that are particularly difficult for the model to distinguish from positive ones (e.g., items that are similar to the positive item but weren't interacted with).

##### Training
<img width="725" height="485" alt="Screenshot 2025-09-10 at 4 56 11 PM" src="https://github.com/user-attachments/assets/26c42f81-441e-4837-a589-28e0349c2005" />
Advantages: This approach directly optimizes for the retrieval task (ranking). It's particularly effective when paired with in-batch negative sampling, where all other positive items in the same batch are used as negative samples for a given query-item pair. This is a highly efficient way to generate hard negatives, as some of those "other" items might be very similar to the positive one, forcing the model to learn fine-grained distinctions.
##### Inference
Online Retrieval: When a new user query arrives, the query tower is used to generate a query embedding in real-time. This embedding is then used to perform an Approximate Nearest Neighbor (ANN) search against the pre-computed candidate embeddings.

### Diagrams
<img width="787" alt="image" src="https://github.com/user-attachments/assets/d9314820-4066-4450-92c0-243692af2bb1" />
<img width="519" alt="image" src="https://github.com/user-attachments/assets/100d2b14-c49a-45a7-a6da-1a40ef3dffc3" />

### Re-Ranker
### Pointwise Ranking Models
* Logistic Regression (For rating)
* GBDT

### Pairwise Ranking Models
<img width="725" height="446" alt="Screenshot 2025-09-10 at 5 36 57 PM" src="https://github.com/user-attachments/assets/5cf28ff6-6506-4d25-93bf-ebccc8865146" />

<img width="725" height="446" alt="Screenshot 2025-09-10 at 5 37 03 PM" src="https://github.com/user-attachments/assets/2f39a79d-198e-4329-98af-db7adf1fd640" />

<img width="739" height="512" alt="Screenshot 2025-09-10 at 5 37 18 PM" src="https://github.com/user-attachments/assets/880fad56-5f05-4c72-854d-c18e145dc63b" />

### PostProcessor
* Region-restricted videos
* Video freshness
* Videos spreading misinformation
* Duplicate or near-duplicate videos
* Fairness and bias
