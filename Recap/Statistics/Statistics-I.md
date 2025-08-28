# Statistics

### Confidence Interval: point estimate±z∗SE
* z: critical value corresponding to the confidence level. (Critical value is the number of standard deviations we'd have to go from the mean of the normal distribution to capture the proportion of the data associated with the desired confidence level.) Roughly, z = 2 for 95% confidence.
* SE: standard error for a point estimate. For example, the standard error for the sample mean is sigma/sqrt(n), where s is the standard deviation and n is the number of samples.
* z∗SE: margin of error

* A confidence interval is a range of values above and below a point estimate that captures the true population parameter at some predetermined confidence level. 
If you want to have a 95% chance of capturing the true population parameter with a point estimate and a corresponding confidence interval, we'd set our confidence level to 95%.
* Higher confidence levels result in a wider confidence intervals.
* 95% confidence interval means that 95% of confidence intervals, each from random samples of the same size from the same population will contain the true population parameter.

### Standardized Normal Distribution
*  μ = 0 and σ = 1
*  To convert X into normal distribution, use Z= (X−μ)/σ

### Bias vs Variance
  * Bias: oversimplification
  * Variance: noise capturing
  * Low bias machine learning algorithms — Decision Trees, k-NN and SVM 
  * High bias machine learning algorithms — Linear Regression, Logistic Regression  
  * The k-nearest neighbour algorithm has low bias and high variance, but the trade-off can be changed by increasing the value of k which increases the number of neighbours that contribute to the prediction and in turn increases the bias of the model.
  * The support vector machine algorithm has low bias and high variance, but the trade-off can be changed by increasing the C parameter that influences the number of violations of the margin allowed in the training data which increases the bias but decreases the variance.

### Types of Selection Bias
  * Sampling bias
  * Time interval
  * Data
  * Attrition

