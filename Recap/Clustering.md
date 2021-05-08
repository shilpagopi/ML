# Clustering
#### Major Types of Clustering
* K Means Clustering
* Hierarchical Clustering
* Gaussian Mixture Models

#### K-Means vs GMM


#### Drawbacks of K-means
* Global optimum convergence is not guaranteed, E-M convergence may happen.
* The clusters have a circular shape, because the centroids of the clusters are updated iteratively using the mean value. Not a good choice to represent non-circular distributions.
* Hard clustering: hard assignment of instance to one cluster. No probability estimation possible.
* Boundaries of K-Means clusters is linear, so dofficult to model complex geometries. Solution might be to use kernelized k-means. Estimate the kernel based on nearest neighbours.
* Estimation of k is difficult. Perhaps use silhoutte analysis.
* Slow for large number of data points. Batched K-Means can be used.
