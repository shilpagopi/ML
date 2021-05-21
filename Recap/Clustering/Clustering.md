# Clustering
#### Major Types of Clustering
* K Means Clustering
* Hierarchical Clustering (Agglomerative (bottom-up) or Divisive (top-down))
* Gaussian Mixture Models

#### K-Means vs GMM


#### Drawbacks of K-means
* Global optimum convergence is not guaranteed, E-M convergence may happen (Not guranteed in GMMs too)
* The clusters have a circular shape, because the centroids of the clusters are updated iteratively using the mean value. Not a good choice to represent non-circular distributions.
* Hard clustering: hard assignment of instance to one cluster. No intrinsic measure of probability estimation (bootstrap approaches based on distances possible).
* Boundaries of K-Means clusters is linear, so dofficult to model complex geometries. Solution might be to use kernelized k-means. Estimate the kernel based on nearest neighbours.
* Estimation of k is difficult. Perhaps use silhoutte analysis.
* Slow for large number of data points. Batched K-Means can be used.

#### Gaussian Mixture Models (GMM)
* Global optimum convergence is not guaranteed, E-M convergence may happen.
* Generative model hence, inherently has a probability distribution for the dataset
* Number of clusters tobe decided using BIC or AIC (works as a density estimator not really a clustering model)

#### Agglomerative (bottom-up) Clustering
* Start with each example in its own singleton cluster
* At each time-step, greedily merge 2 most similar clusters
* Stop when there is a single cluster of all examples, else go to 2nd step

* (Dis)Similarity measures in cluster merging:
  * If dissimilarity betwen two instances is d(Xr,Xs) where Xr belongs to cluster r, Xs belongs to cluster s:
  * Min-link or single-link = min of all dissimilarities : results in chaining (clusters can get very large)
  * Max-link or complete-link = max on all dissimilarities: results in small, round shaped clusters
  * Average-link: (1/(#R * #S)) * sum of all dissimilarities





