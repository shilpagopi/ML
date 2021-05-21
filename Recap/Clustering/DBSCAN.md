# DBSCAN (Density-Based Spatial Clustering of Applications with Noise)

#### K-Means vs DBSCAN
* Similar to K-means, but K need not be specified in advance
* K-Means lead to spherical clusters. DBSCAN creates clustrs of varied shape.
* In K-Means, a slight data change may affect centroids and output clusters. This problem is greatly reduced in DBSCAN.
* K-Means assigns every point into a cluster whereas DBSCAN creates 3 types of points: Core, Border and Noise.

#### Concepts
* Contiguous regions of high point density fall under one cluster
* Input parameters:
  * minPts: minimum number of points to be clustered together for a region to be considered dense.
  * eps (ε): A distance measure that will be used to locate the points in the neighborhood of any point.
* Setting Input Parameters
  * Thumb rule: minPoints>=Dimensions+1 or minPoints=Dimensions*2
  * The optimum value of epsilon is at the point of maximum curvature in the K-Distance Graph (data point vs. its nearest data point for all dataset points)
*  A data point is a Core point if the circle around it contains at least ‘minPoints’ number of points. If the number of points is less than minPoints, then it is classified as Border Point, and if there are no other data points around any data point within epsilon radius, then it treated as Noise.


#### Density Reachability and Connectivity
* Directly Density-Reachable: A point X is directly density-reachable from point Y if dist(X, Y) <= epsilon and Y is a core point (viceversa may not be true)
* Density-Reachable: C is density reachable from A if A->B->C where -> means 'directly density-reachable'
* Density-Connected: X is density-connected from Y if there exists a point O such that X<-O and O->Y
