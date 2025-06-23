# Matrix Factorization
### Concept
The model learns to map each user into an embedding vector and each video into an embedding vector, such that their distance represents their relevance
<img width="807" alt="image" src="https://github.com/user-attachments/assets/92e565ea-41d8-4cbd-8b74-02b261fd63e3" />

### Training
A weighted combinaiton of user-video pairs for oberved and unobserved pairs (to avoid dominance of unobserved)
<img width="631" alt="image" src="https://github.com/user-attachments/assets/7986c0c5-6ac7-4bb7-97b3-b200408a251e" />

### Optimization
<img width="758" alt="image" src="https://github.com/user-attachments/assets/3e09f611-0551-4360-84ff-8dc019b267f4" />

### Inference
<img width="758" alt="image" src="https://github.com/user-attachments/assets/19e5637a-7eb3-440a-b60a-9acb1522a88a" />

### Pros and Cons
Cannot handle cold start videos and users
<img width="797" alt="image" src="https://github.com/user-attachments/assets/0ee6f902-0253-4264-8367-982f8b6a8b2a" />




