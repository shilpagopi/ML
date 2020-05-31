# Supervised Learning
## Model Types
Models | Discriminative | Generative
----|----|------------
Estimation| P(y/x) | P(x/y) -> P(y/x)
Learning | Decision boundary | Probability distribution
Example | SVM, Regression | Naive Bayes, GDA (Gaussian Dsicriminant Analysis)

## Types of predictions: Regression(continuous),Classifier(categorical)

## Newton-Raphson Method: 
theta = theta - L'(theta)/L''(theta)     (L = log-likelihood)

# Unsupervised Learning
E-M Algorithm

### Clustering
E-step: Assign clusters for data points
M-step: Recompute cluster means

### Hierarchical clustering
* Ward linkage : Minimize within cluster distance
* Average linkage : Minimize average distance between cluster pairs	
* Complete linkage : Minimize maximum distance of between cluster pairs

### Performance Assessment
Silhouette coefficient for a single sample: S = (a-b)/max(a,b)
a: mean distance between a sample and all other points in the same class
b: mean distance between between a sample and all other points in the next nearest cluster