# Gaussian Mixture Models (GMM)
#### Concept
* To model more complex data distribution, we can use a linear combination of several Gaussians instead of using just one.

#### E-M (Expectation Maximization) Step
* For fixed u, E and cluster weights (πk for each cluster, Sum = 1):
* E-step: Output a set of soft assignments per data point for each cluster rik (forms responsibility vector of a data point for each cluster)
* M-Step: Recompute u,E,

#### K: Cluster count?
> Let  L  be the maximum value of the likelihood function for the model,  p  be the number of estimated parameters in the model and  N  be the total number of data points.  
> AIC=2⋅p−2⋅ln(L)  
> BIC=−2⋅ln(L)+p⋅ln(N)  
> For both evaluation criteron, the lower the better.  
