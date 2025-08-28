# FAQ
### At A Glance
* Central Limit Theorem 
* p-value
* Type-I (False Positive) and Type-II Errors (False Negative)
* Covariance vs. Correlation
* Z-test vs t-Test
* PDF vs CDF
* Law of Large Numbers
---
#### 1. What is the difference between descriptive and inferential statistics?
* Descriptive Statistics: Summarizes and describes the main features of a collection of information. It's about organizing, displaying, and describing data. Examples include mean, median, mode, standard deviation, and histograms.
* Inferential Statistics: Uses a sample of data to make inferences or predictions about a larger population. It involves hypothesis testing, confidence intervals, and regression analysis to draw conclusions beyond the observed data.

#### 2. Central Limit Theorem (CLT)
The Central Limit Theorem states that, regardless of the original distribution of a population, the sampling distribution of the sample mean (or sum) will approach a normal distribution which has a mean μ and a variance V/n, as the value of n (= number of data points in each sample = 30) goes up. E[Xbar]=μ. (In fact, in the sampling distribution of the mean, the number of samples is assumed to be infinite.)

This is significant because:
It allows us to use normal distribution properties for hypothesis testing and confidence intervals, even if the original population isn't normally distributed.
It applies to a wide range of real-world scenarios where data is aggregated.

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

#### 3. What is a p-value, and how is it used in hypothesis testing?
A p-value (0-1) is the probability of observing a test statistic as extreme as, or more extreme than, the one calculated from the sample data, assuming the null hypothesis is true.

In hypothesis testing, we typically set a significance level (alpha, e.g., 0.05).
* If the p-value is less than alpha, we reject the null hypothesis, suggesting there is sufficient evidence to support the alternative hypothesis.
* If the p-value is greater than alpha, we fail to reject the null hypothesis, meaning there isn't enough evidence to support the alternative.
* Low p-value (≤ 0.05) indicates strength against the null hypothesis which means we can reject the null Hypothesis. High p-value (≥ 0.05) indicates strength for the null hypothesis which means we can accept the null Hypothesis p-value of 0.05 indicates the Hypothesis could go either way.

#### 4. Define Type I and Type II errors in hypothesis testing.
* Type I Error (False Positive): Rejecting a true null hypothesis. This means concluding there's an effect or relationship when there isn't one. The probability of a Type I error is denoted by α (alpha), the significance level.
* Type II Error (False Negative): Failing to reject a false null hypothesis. This means failing to detect an effect or relationship when one actually exists. The probability of a Type II error is denoted by β (beta).

#### 5. What is the difference between covariance and correlation?
* Covariance: Measures the direction of the linear relationship between two variables. A positive covariance means they tend to increase or decrease together, while a negative covariance means one tends to increase as the other decreases. Its magnitude is not standardized, making it difficult to interpret the strength of the relationship.
* Correlation: Measures both the direction and strength of the linear relationship between two variables. It's a standardized version of covariance, ranging from -1 to +1. A correlation of +1 indicates a perfect positive linear relationship, -1 a perfect negative linear relationship, and 0 no linear relationship.(strong: +/-1, weak : 0 linear relationship). Can be computed between two variables, two populations or two samples.
Correlation is covariance normalized by product of both standard deviations.
<img width="642" height="263" alt="Screenshot 2025-08-28 at 10 38 04 AM" src="https://github.com/user-attachments/assets/318a341e-f2fd-4b90-bf5d-2d346aec9aab" />

#### 6. Explain what a confidence interval is and how to interpret a 95% confidence interval.
A confidence interval is a range of values that is likely to contain the true population parameter with a certain level of confidence.
A 95% confidence interval means that if you were to repeat the sampling process and construct confidence intervals many times, approximately 95% of those intervals would contain the true population parameter. It does not mean there is a 95% probability that the true parameter falls within this specific interval.

#### 7.	Z-test vs	T-test
Feature | Z-test | T-test
--|--|--
Population Standard Deviation|	Known	| Unknown (estimated by sample std dev)
Sample Size	Large |(typically N > 30)	| Small (typically N < 30)
Distribution	|Standard Normal (Z-distribution)	|Student's t-distribution
Degrees of Freedom	|Not applicable|	Yes (e.g., n-1 for one-sample)
Conservativeness|	Less conservative (narrower confidence intervals for a given alpha)|	More conservative (wider confidence intervals for a given alpha). The t-distribution has heavier tails than the normal distribution, especially for small sample sizes. This wider spread accounts for the increased variability due to estimating the population standard deviation from a small sample. As the sample size (and thus degrees of freedom) increases, the t-distribution approaches the standard normal distribution.

#### 8. Expected value of random variable?
For discrete: <img width="240" alt="image" src="https://github.com/user-attachments/assets/d8fbab23-21b9-4924-82bb-3d6e42d7c3b8" />
For continuous: <img width="721" alt="image" src="https://github.com/user-attachments/assets/7d1785fd-6148-4e8e-9125-5f4583e9dc78" />

#### 9.How does the sample size affect the power of a test and the p-value?
A larger sample size generally increases the statistical power of a test because it reduces the standard error of the mean, making it easier to detect a true effect. With a larger sample, a smaller p-value is more likely if an effect truly exists.

#### 10. PDF vs CDF
The PDF shows the rate of change of probability (the slope of the CDF), while the CDF shows the total accumulated probability. The PDF describes the relative likelihood of a variable taking a specific value, while the CDF gives the cumulative probability of the variable being less than or equal to a certain value. 
The CDF is the integral of the PDF. This means you can get the CDF by integrating the PDF from negative infinity up to a given point.
The PDF is the derivative of the CDF. Differentiating the CDF gives you the PDF.
<img width="741" height="470" alt="Screenshot 2025-08-28 at 10 49 42 AM" src="https://github.com/user-attachments/assets/73a7ba26-1afd-4060-af23-3a7bd2e20710" />
<img width="741" height="431" alt="Screenshot 2025-08-28 at 10 50 07 AM" src="https://github.com/user-attachments/assets/69ef2a84-0ebb-44d2-b16c-39637e0124da" />

#### 11. What are the properties of normal/Gaussian distribution/bell curve?
* Symmetry and shape
* Central Tendency: The mean, median, and mode are all equal and located at the exact center of the distribution, representing the value with the highest frequency
* Defined by mu and sigma (68-95-99.7 rule)

#### 12. What Is the Law of Large Numbers?
It is a theorem that describes the result of performing the same experiment a large number of times. This theorem forms the basis of frequency-style thinking. It says that the sample means, the sample variance and the sample standard deviation converge to what they are trying to estimate.

