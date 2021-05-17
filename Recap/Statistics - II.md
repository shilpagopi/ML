# Statistics - II

#### General Tips
* Qualitative variables take on values that are names or labels (categorical)
* A measurable characteristic of a *population* (eg. mean) is called a *parameter*; but a measurable characteristic of a *sample* is called a *statistic*
* When sampling with replacement, sample size can be greater than population size
* Uniform distribution: When the observations in a set of data are equally spread across the range of the distribution. It has no clear peaks.
* Most of the observations are on the *left* side of the distribution, so the distribution is *right-skewed*
* The columns are positioned over a label that represents a continuous, quantitative variable (a single value or a range of values)

#### Mean vs Median
The median may be a better indicator of the most typical value if a set of scores has an outlier.   
However, when the sample size is large and does not include outliers, the mean score usually provides a better measure of central tendency.

#### Sample Variance
Observations from a simple random sample can be used to estimate the variance of a **population**  
s^2 = Σ ( xi - x )^2 / ( n - 1 )  
If population data is given, use n in denominator  
**Why?** 
Notice that we divide by n − 1 in the denominator and not n. Intuitively, we have to do this because ¯x, which is not the true mean µ but
is instead an estimate of the true mean, is “closer” to each of the observed values of x’s compared to the true mean µ. Put another way, the distance between each observed value
of x and ¯x tends to be smaller than the distance between each observed value of x and µ. In the case of expectation, some such errors were positive and others were negative, so they cancelled out on average. But, since we’re squaring the distances, our values, (xi − x¯)^2 will be systematically lower than the true ones (xi − µ)^2. So, if we divide by n instead of n − 1, we’ll end up underestimating our uncertainty.

#### Standard Score / Z score
Z-score indicates how many standard deviations an element is from the mean. z = (X - μ) / σ  
Z = (sample mean - μ) / SE

####  Interquartile range is equal to Q3 - Q1

#### Outlier
As a "rule of thumb", an extreme value is often considered to be an outlier if it is at least 1.5 interquartile ranges below the first quartile (Q1), or at least 1.5 interquartile ranges above the third quartile (Q3).

#### Corelation Coefficient
* The greater the absolute value of the Pearson product-moment correlation coefficient, the stronger the linear relationship. (strong: +/-1, weak : 0 linear relationship)
* Can be computed between two variables, two populations or two samples.

#### Linear Regression Assumptions
* The dependent variable Y has a linear relationship to the independent variable X. To check this, make sure that the XY scatterplot is linear and that the residual plot shows a random pattern. (Don't worry. We'll cover residual plots in a future lesson.)
* For each value of X, the probability distribution of Y has the same standard deviation σ. When this condition is satisfied, the variability of the residuals will be relatively constant across all values of X, which is easily checked in a residual plot.
* For any X,
  * The Y values are independent, as indicated by a random pattern on the residual plot.
  * The Y values are roughly normally distributed (i.e., symmetric and unimodal). A little skewness is ok if the sample size is large. A histogram or a dotplot will show the shape of the distribution.

* If you know the linear correlation (r) between two variables, then the coefficient of determination (R2) is easily computed using the following formula: R2 = r2.
* A random pattern of residuals supports a linear model; a non-random pattern supports a nonlinear model. The sum of the residuals is always zero, whether the data set is linear or nonlinear.

#### Population mean and Sample statistics
Population mean (μ), population std deviation (σ), E[sample mean] = μ, E[variance] =σ^2

#### Bernoulli Distribution
E(x) = p; Var(x) = p(1-p)

#### Binomial Distribution
E(x) = np; Var(x) = np(1-p)

#### Random quantity
* The random quantity is approximately Gaussian with mean p and variance p(1−p)/n
* If variance of population is given, var of sample = (var of popu.)/n
* Standard error(SE) = σ of population/√n
* Test statistic: t = (µˆ − µ)/SE

#### Significance level or alpha = 1 – Confidence level
