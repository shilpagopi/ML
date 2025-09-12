# Solution Track
1. **Problem Scope** and business understanding/goals, target audience/enduser, and key constraints, accuracy requirements/hallucination tolerance.
2. **Functional Requirements and NFR** : Scale, Latency, Privacy, Security, Online/Offline, Guardrails
3. **Data**:
  * Data features
  * Data type(static/dynamic, structured/unstructured, derived features, biases)
  * Scale
  * Inference realtime/offline
  * Training/retraining periodicity
  * Annotated data - Data augmentation
    
3. **ML Problem formulation** and **Metrics (ML and Business)**:
  * Metrics (relative or absolute): Business metrics and Optimization objective
   * Classification: Binary/Categorical Cross entropy Loss
   * Recommendation: Hit Ratio, MRR (mean reciprocal rank), Precision@K, MAP (mean average precision), NDCG, Coverage
   * Regression: MSE (mean squared error), MAE (mean average error)
  * ML problem category
  * ML System I/O
    
4. **Data Preprocessing**:
  * Data collection, filtering, analysis, storing, validation
  * **Address challenges**: Biases, Long-tail categories, imbalance
  * Feature Engineering
    
5. **Core Architectural Choices**
  * Trade-offs: latency, interpretability, data types, scale, nonlinearity, feature engg.
  * Classification: Logistic Regression, GBDT, Neural Networks
  * Regression: Linear Regression, GBDT
  * Recommendation
    * Candidate Generation: Collaborative Filtering vs Two Tower model: Cold start, Other categorical features, Scale
    * Ranking: GBDT vs. DNN(Wide and Deep): Interpretability, Unstructured/Embedded features, Complex to train(DNN), Wide and Deep (Memoization + Generalization)
    * Reranking: Heuristics and business data - for freshness, diversity, fairness, business rules
  * ML modeling: optimizations - regularization, hyper parameter tuning
  * cold-start solution
  * Feedback loops
  * If LLM-based solution, RAG vs finetuning? Open source-vs-off the shelf models. Prompt engineering techniques.
    
6. **Deployment, Postproduction:**
    * Data Processing and Feature Engineering: <br> Spark/Dask: For handling large-scale datasets, these distributed computing frameworks are essential for ETL (Extract, Transform, Load) tasks and feature engineering.
    * Feature Stores (Feast, Tecton): <br>  A feature store is a centralized repository that standardizes the management and serving of features. It ensures consistency between offline training and online inference, preventing "training-serving skew."
    * Model Training: <br> TensorFlow, PyTorch, NVIDIA Merlin
    * Model Serving and Deployment: <br> TensorFlow Serving / TorchServe, Vector Databases (e.g., Milvus, Pinecone, FAISS, ScaNN), Kubernetes / Docker: containerization and orchestration of multiple microservices and handle auto-scaling, Cloud Platforms (AWS SageMaker, Google Vertex AI, Azure ML)
   * ML OPs, Versioning: <br> MLflow / Weights & Biases (W&B)
   * Operational Metrics: <br> Prometheus / Grafana
     
7. **Online metrics: A/B testing**

Tips: 
* For optimizing latency, train smaller models using knowledge distillation
* For optimizing latency and storage: pruning technique (prune featuremaps) not detrimental to model quality.
* Use an approximate, fast classification model, say XGBoost or LightGBM, as a candidate generation model before actual huge transformer based models.
* For query disambiguation, cover multiple possible intents in proportion to their popularity. Rely on further user signals.
* Freshness and Recency: Query classification helps identify which queries require fresh results versus those that can use evergreen content. Time-based decay functions can be applied to relevance scores to naturally deprecate older content when appropriate.
* Feedback Loops: Regularly injecting randomness into rankings to gather unbiased feedback. Position bias can be addressed through inverse propensity scoring and click data debiasing.Maintaining golden sets unaffected by feedback loops provides stable evaluation baselines

Examples: 
* Visual Search System
* Google Street View Blurring System
* YouTube Video Search
* Harmful Content Detection
* Video Recommendation System
* Event Recommendation System
* Ad Click Prediction on Social Platforms
* Similar Listings on Vacation Rental Platforms
* Personalized News Feed
* People You May Know
* Design a feed recommendation system
* Design Youtube(Google)
* Design Google contact ranking(Google)
* Design an item replacement recommendation(Instacart)
* Design an ML System to optimize coupon distribution with a set budget(Netflix).

Gen-AI System Design examples
* Gmail Smart Compose
* Google Translate
* ChatGPT: Personal Assistant Chatbot
* Image Captioning
* Retrieval-Augmented Generation
* Realistic Face Generation
* High-Resolution Image Synthesis
* Text-to-Image Generation
* Personalized Headshot Generation
* Text-to-Video Generation

Books: Generative AI System Design Interview,Machine Learning System Design Interview,
