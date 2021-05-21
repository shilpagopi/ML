# DBSCAN (Density-Based Spatial Clustering of Applications with Noise)

#### K-Means vs DBSCAN
* Similar to K-means, but K need not be specified in advance
* K-Means lead to spherical clusters. DBSCAN creates clustrs of varied shape.
* In K-Means, a slight data change may affect centroids and output clusters. This problem is greatly reduced in DBSCAN.

#### Concepts
* Contiguous regions of high point density fall under one cluster
* Input parameters:
  * minPts: minimum number of points to be clustered together for a region to be considered dense.
  * eps (ε): A distance measure that will be used to locate the points in the neighborhood of any point.
* Density Reachability establishes a point to be reachable from another if it lies within a particular distance (eps) from it.
* Density Connectivity involves a transitivity based chaining-approach to determine if points fall into cluster. a->b->c (a and c in same cluster)
