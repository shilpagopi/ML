# Initialization

## K-Means Clustering Initialization Strategies
* Results of k-Means depend heavily on the initialization
#### Forgy Initialization
* Random K points initially
* Do multiple initializations and choose initialization with lowest WSS
* By randomly choosing points from data, it is more probable to get a point close to the modes.

#### Random Partition Method
* We randomly assign each point in the data to a random cluster ID.
* Use these cluster means to yield the initial points. 
* But this method is not recomemnded because all the intial centroid points may lie close to the mean of the data.

#### K-Means++
* Better than the above two.
* Process:
  * Randomly pick a point. Add it to centroids.
  * Compute distance of all points to nearest centroids.
  * Assign the point with maximum distance as new centroid.

#### Extra Points
* Some other clustering algorithms exist, which are able to detect non-convex clusters where the centroid might not even lie within the cluster.
* Results of k-Means can be used as starting points for other algorithms, eg. Gaussian Mixture Models.
