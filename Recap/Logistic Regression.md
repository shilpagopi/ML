# Logistic Regression
Logistic Regression is used when the dependent variable(target) is categorical.  
Decision boundary can be linear or non-linear. Polynomial order can be increased to get complex decision boundary.
It uses a maximum likelihood estimation rather than the least squares estimation  

> z = w.x  
> h = sigmoid(z) 

> Loss function, L = - ylog(h) - (1-y)log(1-h)  
> Gradient, dL/dw1 = (h-y).x1

> Probability = h (as it is a value between 0 and 1)

# Multinomial/Softmax Logistic Regression
```
Do the maths, considering K labels. It will turn out to be equivalent to training independent k-1 regressors. Separate w for each class.
An alternative approach is to train K regressors. Do softmax to get output probabilities summing to 1.
z1 = w1.x
p(k=1) = exp(z1)/(sum(exp(z)) for k = 1 to K)
