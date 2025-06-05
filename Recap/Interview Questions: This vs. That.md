# Interview Questions: This vs. That
### KNN vs K-means clustering
K-Nearest Neighbors is a supervised classification algorithm, while k-means clustering is an unsupervised clustering algorithm. 
KNN: k is the number of neighbours, K-Means: k is the number of clusters

### Standard GD vs Stochastic GD
In standard gradient descent, you'll evaluate all training samples for each set of parameters. This is akin to taking big, slow steps toward the solution.
In stochastic gradient descent, you'll evaluate only 1 training sample for the set of parameters before updating them. This is akin to taking small, quick steps toward the solution.

### Why not use linear regression in place of logistic regression for binary classification?
* Distribution of error terms: Linear regression assumes that error terms are normally distributed. In case of binary classification, this assumption does not hold true, as the data distribution is different.
* Model output: In linear regression, the output is continuous. Also, the predict values that can go beyond 0 and 1. If we want the output in the form of probabilities, which can be mapped to two different classes, then its range should be restricted to 0 and 1.
* Variance of Residual errors: Linear regression assumes that the variance of random errors is constant. This assumption is also violated in case of logistic regression.

### Inductive vs Deductive
* Inductive learning is the process of using observations to draw conclusions  
* Deductive learning is the process of using conclusions to form observations   

### When would you use random forests Vs SVM and why?
* Random forests allow you to determine the feature importance. SVM’s can’t do this.
* Random forests are much quicker and simpler to build than an SVM.
* For multi-class classification problems, SVMs require a one-vs-rest method, which is less scalable and more memory intensive.

### Which algorithm is better at handling outliers logistic regression or SVM?
Logistic regression will find a linear boundary if it exists to accommodate the outliers. Logistic regression will shift the linear boundary in order to accommodate the outliers. SVM is insensitive to individual samples. There will not be a major shift in the linear boundary to accommodate an outlier. SVM comes with inbuilt complexity controls, which take care of overfitting. This is not true in case of logistic regression.+

### Parametric vs Non-parametric Algorithm ?
* Parametric:  Once we’ve fit the finite no. of parameters and stored them away, the training data is not required to make future predictions. 
Eg. Linear Regression

* Non-Parametric: Need training data to make predictions. Storage to represent hypothesis grows linearly with the size of the training set.
Eg. Locally weighted linear regression algorithm.
### AI, ML, DL, Data Mining
DL -> subset of -> ML -> subset of -> AI 

### One-hot encoding vs Label encoding
Label encoding: var x = 1,2 or 3. No dimensionality increase.

### Layer norm vs Batch norm
* Normalization axis: Batch normalization normalizes across the batch dimension, while layer normalization normalizes across the feature dimension for a single training example.
* Sensitivity to batch size: Batch normalization is sensitive to batch size, while layer normalization is not
* Mathematical steps similar: compute mean and variance, Normalized_x = (x - mean(x)) / std(x), Scale and shift: Output = gamma * Normalized_x + beta

### Explain the difference between Maximum Likelihood Estimation (MLE) and Maximum A Posteriori (MAP) estimation.

Answer: Both MLE and MAP are methods for estimating the parameters of a statistical model, but they differ in their philosophical approach:
Maximum Likelihood Estimation (MLE):
A frequentist approach.
Aims to find the parameter values that maximize the likelihood of observing the given data.
Assumes the parameters are fixed but unknown.
It only considers the likelihood function, P(Data∣θ), where θ represents the parameters.
It is prone to overfitting with small datasets or complex models if not regularized.

Maximum A Posteriori (MAP) Estimation:
A Bayesian approach.
Aims to find the parameter values that maximize the posterior probability of the parameters given the data.
Incorporates prior knowledge or beliefs about the parameters in the form of a prior distribution, P(θ).
The formula is P(θ∣Data)∝P(Data∣θ)∗P(θ), where P(Data∣θ) is the likelihood and P(θ) is the prior.
When the prior is uniform (i.e., all parameter values are equally likely), MAP estimation reduces to MLE.
MAP can be more robust to small datasets by leveraging prior information.

### Differentiate between autoregressive and masked language models

| Feature           | Autoregressive Language Models (ARLMs) | Masked Language Models (MLMs)        |
| ---------------- | ------------------------------------- | ----------------------------------- |
| Prediction | Predicts the *next* token              | Predicts random *masked* tokens             |
| Context| Unidirectional (left-to-right)         | Bidirectional (left and right)       |
| Primary Use Case | Text *generation*, summarization, translation | Text *understanding*, classification, QA |
| Typical Architecture | Decoder-only Transformer               | Encoder-only Transformer             |
| Examples | GPT series (GPT-2, GPT-3, GPT-4)       | BERT, RoBERTa, ALBERT, DistilBERT    |

### Gradient Descent vs. Adam
<img width="702" alt="image" src="https://github.com/user-attachments/assets/0eb8b1b0-39ab-4000-ab68-21e344ec690a" />




