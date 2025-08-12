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
* Geometric Interpretation: L2 constrains the weights to lie within a sphere centered at the origin, L1 constrains the weights to lie within a diamond shape centered at the origin.
```
The only difference between the normal gradient descent and gradient descent regularized, 
is that it finds a converged value of theta as low as possible. The starting point of 
every theta iteration is slightly lesser than the previous value of theta.
```

### Dropout in Neural Networks
Dropout is the fraction(p) of neurons we "drop", randomly picked for each iteration.
We delete the connections going into, and out of, the neuron when we drop it.

How it works:
Reduced Co-adaptation: Prevents neurons from co-adapting too much to specific features in the training data. If a neuron relies too heavily on the output of another specific neuron, dropout breaks that dependency.
Ensemble Effect: It can be seen as training an ensemble of many different "thinned" networks simultaneously. When the full network is used at test time, it's akin to averaging the predictions of this ensemble, which generally leads to better generalization.

During Testing: Dropout is not applied during testing. Instead, the weights of the remaining (non-dropped-out) neurons are scaled by the dropout probability (1−p or inverse of p, depending on implementation) to account for the fact that all neurons are active. A common practice is "inverted dropout," where activations are scaled during training.

### Early Stopping
Prevents the model from learning noise in the training data after it has already learned the general patterns.

### Batch Normalization
While its primary purpose is to stabilize and accelerate training (by reducing internal covariate shift), Batch Normalization also has a significant regularization effect.Internal covariate shift means change in the distribution of inputs to subsequent layers as the previous layer's paranters are trained/updated. this leads to the network taking more time to adapt and learning rates to be slow.

Concept: Normalizes the activations of each layer (by subtracting the batch mean and dividing by the batch standard deviation) for each mini-batch during training. It also introduces learnable scale and shift parameters (γ and β).

Regularization Effect:
Adds Noise: The mean and variance are computed per mini-batch, which introduces a slight amount of noise into the activations. This noise acts as a regularizer, similar to dropout, making the model less sensitive to individual training examples.
Smoother Landscape: By keeping the activation distributions stable, it creates a smoother loss landscape, which can implicitly reduce overfitting by allowing the optimization algorithm to find better minima.
During Testing: Uses fixed mean and variance values (typically calculated as moving averages during training) to normalize activations.

* normalize the inputs of a layer for each mini-batch, typically applied after the activation function.
* Normalized_x = (x - mean(x)) / std(x), Output = gamma * Normalized_x + beta, gamma and beta are learnable params.

* Benefits
  * Reduces internal covariate shift between layers: By normalizing the inputs, it helps to stabilize the distribution of activations across layers, preventing the distribution of inputs to later layers from changing drastically.
  * Improves gradient flow: By reducing the magnitude of activations, it helps to prevent vanishing or exploding gradients, by having zero centred inputs to nonlinearities which will result in stable gradients and not saturated gradients and also clips/bounds the values by normalisation preventing exploding gradients.
* Reduces sensitivity to initializations 
  * Acts as a regularizer: Reduces overfitting by introducing noise into the training process.
  * Allows for higher learning rates: Since the inputs are normalized, higher learning rates can be used without causing instability.

### Using cross-validation techniques also reduces variance.
* Cross-validation on Time series:
Fold 1 : training [1], test [2]  
Fold 2 : training [1 2], test [3]  
Fold 3 : training [1 2 3], test [4]

### Batch Normalization vs Layer Normalization
<img width="737" alt="image" src="https://github.com/user-attachments/assets/4f015fd2-f1d9-413d-9e69-7ec8f72b746e" />
<img width="737" alt="image" src="https://github.com/user-attachments/assets/f4bb6512-c1a7-41f9-8962-d63e9f684ff2" />
<img width="737" alt="image" src="https://github.com/user-attachments/assets/da530963-d57c-4eb3-9a85-241306b50c2a" />
<img width="737" alt="image" src="https://github.com/user-attachments/assets/377e6d4b-edfb-45e4-aae1-02b524bfdc9b" />
<img width="737" alt="image" src="https://github.com/user-attachments/assets/86cb05e7-07f5-4edd-a4e4-e748b06c0e90" />
<img width="737" alt="image" src="https://github.com/user-attachments/assets/db0c5a1a-5b45-450a-90e9-0c13e5b88235" />
<img width="737" alt="image" src="https://github.com/user-attachments/assets/6541040d-1da2-484f-80c5-42fd0c8c0bcf" />








