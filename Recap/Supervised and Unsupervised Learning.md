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
#### Silhouette coefficient for a single sample: S = (a-b)/max(a,b)
a: mean distance between a sample and all other points in the same class
b: mean distance between between a sample and all other points in the next nearest cluster
* Silhouette coefficients near +1 indicate that the sample is far away from the neighboring clusters. A value of 0 indicates that the sample is on or very close to the decision boundary between two neighboring clusters and negative values indicate that those samples might have been assigned to the wrong cluster. 
* Also, the silhoutte values chart bars are narrow/broad based on number of instances falling into each cluster.

#### Inertia - how to choose K?
* Inertia is the sum of distances of all the points from its respective centroids. (=WSS?)
* Lesser the inertia value, the better our clusters are.
* Plot K vs inertia. Choose K where inertia almost becomes a constant.

#### Dunn Index
* Dunn index is the ratio of the minimum of inter-cluster distances and maximum of intracluster distances. 
* High dunn index => better clusters

#### Choose initialization with lowest WSS
WSS means the sum of distances between the points and the corresponding centroids for each cluster. WSS is a measure of compactness. 
BSS means the sum of distances between the centroids and the total sample mean multiplied by the number of points within each cluster. BSS is a measure of dispersion 
For clustering to be successful, we need to get the lower WSS and the higher BSS. 

#### Stopping criteria for clustering
* Centroids of newly formed clusters do not change
* Points remain in the same cluster
* Maximum number of iterations are reached
