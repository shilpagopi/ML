# Solution Track
1. Problem Scope and business understanding. Any particular business metrics?
2. Data:
  * Data features
  * Data type(static/dynamic, structured/unstructured, derived features, biases)
  * Scale
  * Inference realtime/offline
  * Training/retraining periodicity
  * Annotated data - Data augmentation 
3. ML Problem formulation:
  * Metrics (relative or absolute): Business metrics and Optimization objective
  * ML problem category
  * ML System I/O
4. Data Preprocessing:
  * Data collection, filtering, analysis, storing, validation
  * Biases, Long-tail categories, imbalance
  * Feature Engineering
5. Core Architectural Choices
  * ML modeling: optimizations - regularization, hyper parameter tuning
  * cold-start solution
  * Feedback loops
6. Deployment, MLOps, monitoring, logging, model versioning etc.
7. Online metrics, A/B testing

Tips: 
* For optimizing latency, train smaller models using knowledge distillation
* For optimizing latency and storage: pruning technique (prune featuremaps) not detrimental to model quality.
* Use an approximate, fast classification model, say XGBoost or LightGBM, as a candidate generation model before actual huge transformer based models.  

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
