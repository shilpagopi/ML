# Regularization

Why? To prevent overfitting.  
Regularization significantly reduces the variance of the model, without substantial increase in its bias.
Regularization reduces flexibility of complex models

### Lasso Regression (L1 Norm)
<img src = "https://miro.medium.com/max/1094/1*tHJ4sSPYV0bDr8xxEdiwXA.png" width = "600" height = "100">

### Ridge Regression (L2 Norm)
<img src = "https://miro.medium.com/max/1106/1*CiqZ8lhwxi5c4d1nV24w4g.png" width = "600" height = "100">

### Elastic Net
Trade off between Lasso and Ridge regressions:  
a(Wi^2) + (1-a)(Wi)  

**L1 vs L2**
* Choose L1, when we intend to drop the weights for meaningless dimensions to exactly 0.
L2 regularization encourages weights to be small, but doesn't force them to exactly 0.0.

* L2 penalizes higher coefficients more than L1
* L1 corresponds to setting a Laplacean prior on the terms, while L2 corresponds to a Gaussian prior.
```
The only difference between the normal gradient descent and gradient descent regularized, 
is that it finds a converged value of theta as low as possible. The starting point of 
every theta iteration is slightly lesser than the previous value of theta.
```

### Dropout in Neural Networks
Dropout is the fraction of neurons we "drop", randomly picked for each iteration.
We delete the connections going into, and out of, the neuron when we drop it.

### Batch Normalization
* normalize the inputs of a layer for each mini-batch, typically applied after the activation function.
* Normalized_x = (x - mean(x)) / std(x), Output = gamma * Normalized_x + beta, gamma and beta are learnable params.
* Benefits
  * Reduces internal covariate shift between layers: By normalizing the inputs, it helps to stabilize the distribution of activations across layers, preventing the distribution of inputs to later layers from changing drastically.
  * Improves gradient flow: By reducing the magnitude of activations, it helps to prevent vanishing or exploding gradients.
  * Acts as a regularizer: Reduces overfitting by introducing noise into the training process.
  * Allows for higher learning rates: Since the inputs are normalized, higher learning rates can be used without causing instability.   

### Using cross-validation techniques also reduces variance.
* Cross-validation on Time series:
Fold 1 : training [1], test [2]  
Fold 2 : training [1 2], test [3]  
Fold 3 : training [1 2 3], test [4]  
