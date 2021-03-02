# Initialization

### K-Means Clustering Initialization Strategies
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

### Zero Initialization
* If all the weights are initialized with 0, the derivative with respect to loss function is the same for every w in W[l], thus all weights have the same value in subsequent iterations. This makes hidden units symmetric.

### Random Initialization
* If weights are initialized high values or very low values, gradient saturation or activation blowing up.

### He Initialization
* factor = sqrt(2/input_embedding_dimension)
* weight = randomly initialized weight x factor

### Xavier Initialization
* factor = sqrt(1/input_embedding_dimension) ; Usually used with tanh activation

### Another initialization 
* factor = sqrt(2/(input_embedding_dimension+hidden layer dimension))

> Good initialization techniques set the weights neither too bigger than 1, nor too lesser than 1. So, the gradients do not vanish or explode too quickly. They help avoid slow convergence, also ensuring that we do not keep oscillating off the minima. There exist other variants of the above, where the main objective again is to minimize the variance of the parameters.

