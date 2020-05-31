# Regularization

Why? To prevent overfitting.  
Regularization significantly reduces the variance of the model, without substantial increase in its bias.  

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
```
The only difference between the normal gradient descent and gradient descent regularized, 
is that it finds a converged value of theta as low as possible. The starting point of 
every theta iteration is slightly lesser than the previous value of theta.
```

### Dropout in Neural Networks
Dropout is the fraction of neurons we "drop", randomly picked for each iteration.
We delete the connections going into, and out of, the neuron when we drop it.
