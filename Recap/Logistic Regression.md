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

* If input is given as linear, then decision boundary must be a line.

* We cannot use the same cost function that we used for linear regression because the Sigmoid Function will cause the output to be wavy, causing many local optima. 
  In other words, it will not be a convex function. Hence, the cost function is transformed using the logarithm of the sigmoid function.

### Formulation behind Logistic Regression
Our goal is to predict the probability,P(0-1). 
Odds= P/1−P
Why use odds?
Probabilities are bounded between 0 and 1. This makes it difficult to model them directly using a linear equation, as a linear equation's output can range from −∞ to +∞.
Odds, however, range from 0 to +∞. This is an improvement, but they are still not symmetric around 1

​<img width="292" alt="image" src="https://github.com/user-attachments/assets/662a4b46-a38f-4f98-a85d-4294f462c281" />
Why use log-odds/logit?
The log-odds range from −∞ to +∞. This is crucial because it allows us to model this quantity using a standard linear regression equation, which can produce any real number.
It creates a symmetric scale. For example, an odds of 2 has a log-odds of ln(2)≈0.693, while an odds of 0.5 (1/2) has a log-odds of ln(0.5)≈−0.693. The absolute values are the same, reflecting a symmetric distance from "even odds."

<img width="709" alt="image" src="https://github.com/user-attachments/assets/c3d85821-4ba9-42ff-9d92-4efad58d1b27" />
From Log-Odds Back to Probability (The Sigmoid Function)
The sigmoid function "squashes" any real number z (the log-odds) into a probability between 0 and 1.
<img width="215" alt="image" src="https://github.com/user-attachments/assets/81eb2c16-10cf-433e-a58e-c9dba54ae0f5" />

So, in essence: Input Variables → Linear Combination (produces z, which is the log-odds/logit) → Sigmoid Function → Predicted Probability (0 to 1)

### Assumptions of Logistic Regression
* Binary or Categorical Dependent Variable: The outcome variable must be dichotomous (for binary) or categorical (for multinomial/ordinal - ordered multi class).
* Independence of Observations: Each observation should be independent of the others.
* No High Multicollinearity: Independent variables should not be highly correlated with each other.
* Linearity of Independent Variables with Log-Odds: The independent variables should be linearly related to the log-odds of the dependent variable. This is different from linear regression, where variables are linearly related to the raw dependent variable.
* Large Sample Size: MLE generally requires a relatively large sample size for reliable parameter estimates.

### Loss Function
Its main purpose is to measure the difference between two probability distributions: the true (ground-truth) distribution of labels and the predicted probability distribution from your model. It measures the average number of bits required to identify an event from the true distribution (p) when using an encoding scheme optimized for the predicted distribution (q).
<img width="443" alt="image" src="https://github.com/user-attachments/assets/411db1e0-b35c-426d-bfe9-9ab86ab8b62b" />

The loss is only concerned with the predicted probability of the correct class.
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

