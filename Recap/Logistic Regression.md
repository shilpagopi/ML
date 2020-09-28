# Logistic Regression
Logistic Regression is used when the dependent variable(target) is categorical.  
Decision boundary can be linear or non-linear. Polynomial order can be increased to get complex decision boundary.
It uses a maximum likelihood estimation rather than the least squares estimation  

> z = w.x  
> h = sigmoid(z) 

> Loss function, L = - ylog(h) - (1-y)log(1-h)  
> Gradient, dL/dw1 = (h-y).x1

> Probability = h (as it is a value between 0 and 1)

* The input to the sigmoid function ‘g’ doesn’t need to be linear function. It can very well be a circle or any shape. z = w1x1^2 + w2x2^2

* We cannot use the same cost function that we used for linear regression because the Sigmoid Function will cause the output to be wavy, causing many local optima. 
  In other words, it will not be a convex function. Hence, the cost function is transformed using the logarithm of the sigmoid function.

# Multinomial/Softmax Logistic Regression
```
Do the maths, considering K labels. It will turn out to be equivalent to training independent k-1 regressors. Separate w for each class.
An alternative approach is to train K regressors. Do softmax to get output probabilities summing to 1.
z1 = w1.x
p(k=1) = exp(z1)/(sum(exp(z)) for k = 1 to K)
```

# Evaluation of Model Fit
* Pseudo R2 =1 − (L1/L0)  
where, L1 and L0 are the log-likelihood of trained model and a base model with a logistic regression on just a constant (and does not depend on x) (yi=1/(1+exp(−α)))

* Akaike information criterion, AIC = 2k-2*ln(L)  
k is the number of estimated parameters in the model
L is the maximum value of the likelihood function for the model  
Prefer model with the minimum AIC value  
Intuition: Information loss  

