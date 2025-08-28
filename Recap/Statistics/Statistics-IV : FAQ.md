# FAQ
### At A Glance
* Central Limit Theorem 
* p-value
* Type-I (False Positive) and Type-II Errors (False Negative)
* ---
#### 1. What is the difference between descriptive and inferential statistics?
* Descriptive Statistics: Summarizes and describes the main features of a collection of information. It's about organizing, displaying, and describing data. Examples include mean, median, mode, standard deviation, and histograms.
* Inferential Statistics: Uses a sample of data to make inferences or predictions about a larger population. It involves hypothesis testing, confidence intervals, and regression analysis to draw conclusions beyond the observed data.

#### 2. Explain the Central Limit Theorem (CLT) and its significance.
The Central Limit Theorem states that, regardless of the original distribution of a population, the sampling distribution of the sample mean (or sum) will approach a normal distribution as the sample size increases. E[Xbar]=μ.
 This is significant because:
It allows us to use normal distribution properties for hypothesis testing and confidence intervals, even if the original population isn't normally distributed.
It's fundamental to understanding why many statistical methods work.
It applies to a wide range of real-world scenarios where data is aggregated.

#### 3. What is a p-value, and how is it used in hypothesis testing?
Answer: A p-value is the probability of observing a test statistic as extreme as, or more extreme than, the one calculated from the sample data, assuming the null hypothesis is true.
In hypothesis testing, we typically set a significance level (alpha, e.g., 0.05).
If the p-value is less than alpha, we reject the null hypothesis, suggesting there is sufficient evidence to support the alternative hypothesis.
If the p-value is greater than alpha, we fail to reject the null hypothesis, meaning there isn't enough evidence to support the alternative.

#### 4. Define Type I and Type II errors in hypothesis testing.
* Type I Error (False Positive): Rejecting a true null hypothesis. This means concluding there's an effect or relationship when there isn't one. The probability of a Type I error is denoted by α (alpha), the significance level.
* Type II Error (False Negative): Failing to reject a false null hypothesis. This means failing to detect an effect or relationship when one actually exists. The probability of a Type II error is denoted by β (beta).

#### 5. What is the difference between covariance and correlation?
* Covariance: Measures the direction of the linear relationship between two variables. A positive covariance means they tend to increase or decrease together, while a negative covariance means one tends to increase as the other decreases. Its magnitude is not standardized, making it difficult to interpret the strength of the relationship.
* Correlation: Measures both the direction and strength of the linear relationship between two variables. It's a standardized version of covariance, ranging from -1 to +1. A correlation of +1 indicates a perfect positive linear relationship, -1 a perfect negative linear relationship, and 0 no linear relationship.
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

#### 11. What are the properties of normal/Gaussian distribution/bell curve?
* Symmetry and shape
* Central Tendency: The mean, median, and mode are all equal and located at the exact center of the distribution, representing the value with the highest frequency
* Defined by mu and sigma (68-95-99.7 rule)
 

