# Statistics

### Central Limit Theorem (CLT)
Given a population with unknown distribution (it could be uniform, binomial or completely random), the sample means will approximate the normal distribution.

Given a population whose means is μ and variance V. The sampling distribution of the mean will approach a normal distribution which has a mean μ and a variance V/n, as the value of n (= number of data points in each sample = 30) goes up. (In fact, in the sampling distribution of the mean, the number of samples is assumed to be infinite.)

* Assumptions
  * The data must be sampled randomly
  * Samples should be independent of each other.
  * Sample size should be not more than 10% of the population when sampling is done without replacement
  * The sample size should be sufficiently large. (a sample size of 30 is considered sufficient when the population is symmetric.)
 
* Applications/Inferences:
  * We have the information of a valid sample. We can make accurate assumptions about it’s population.
  * We have the information of the population. We can make accurate assumptions about a valid sample from that population.
  * We have the information of a population and a valid sample. We can accurately infer if the sample was drawn from that population.
  * We have the information about two different valid samples. We can accurately infer if the two samples where drawn from the same population.

### Confidence Interval: point estimate±z∗SE

* A confidence interval is a range of values above and below a point estimate that captures the true population parameter at some predetermined confidence level. 
If you want to have a 95% chance of capturing the true population parameter with a point estimate and a corresponding confidence interval, we'd set our confidence level to 95%.
* Higher confidence levels result in a wider confidence intervals.

* z: critical value corresponding to the confidence level. (Critical value is the number of standard deviations we'd have to go from the mean of the normal distribution to capture the proportion of the data associated with the desired confidence level.) Roughly, z = 2 for 95% confidence.
* SE: standard error for a point estimate. For example, the standard error for the sample mean is sigma/sqrt(n), where s is the standard deviation and n is the number of samples.
* z∗SE: margin of error

### Standardized Normal Distribution
*  μ = 0 and σ = 1
*  To convert X into normal distribution, use Z= (X−μ)/σ

### P-value
p-value is a number between 0 and 1. Based on the value it will denote the strength of the results. The claim which is on trial is called the Null Hypothesis.

Low p-value (≤ 0.05) indicates strength against the null hypothesis which means we can reject the null Hypothesis. High p-value (≥ 0.05) indicates strength for the null hypothesis which means we can accept the null Hypothesis p-value of 0.05 indicates the Hypothesis could go either way.
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
  
### What Is the Law of Large Numbers?
It is a theorem that describes the result of performing the same experiment a large number of times. This theorem forms the basis of frequency-style thinking. It says that the sample means, the sample variance and the sample standard deviation converge to what they are trying to estimate.
