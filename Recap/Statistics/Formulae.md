# Formulae
#### <img width="360" alt="image" src="https://github.com/user-attachments/assets/e9e83fda-b88e-4d1e-94be-3fdc4f0dc714" />
'n' refers to the size of the dataset you actually collected. n is not the number of samples, you draw to create the sampling distribution.

#### Basic Probability
<img width="681" alt="image" src="https://github.com/user-attachments/assets/0e582407-14e4-4881-a2e4-de44e0a2c2f2" />

#### Combinatorics
<img width="720" alt="image" src="https://github.com/user-attachments/assets/11dcfb70-5499-4deb-894c-c310bab70b0d" />

#### Random Variables
<img width="637" alt="image" src="https://github.com/user-attachments/assets/3d3b8171-f13f-48bd-a6fa-a4baa7a8edfb" />

E(X,Y) = E(X)E(Y) + Cov(X,Y)

#### Probability Distributions
Multinomial distribution:
* The expected number of times the outcome i was observed over n trials is: E(Xi) = n* pi
* Var(Xi) = n* pi(1-pi)
* Cov(Xi,Xj) = -n * pi * pj
* Correlation(Xi,Xj) = Cov(Xi,Xj)/Sqrt(Var(Xi) * Var(Yi))

Discrete uniform distribution (over integers a,a+1,...,b):
* E(X) = a+b/2
* Var(X)= ((b−a+1)^2-1)/12

* Mode = 3 Median – 2 Mean
* For symmetirc distribution, all 3 are equal. For left skewed (long tail on left), mode<median<mean. For right skewed, mean<median<mode. median is always in the middle and mode is the highest peak of the curve. 

##### Types of distributions
> Multinomial distribution is a generalization of the binomial distribution. It models the probability of counts for each side of a k-sided die rolled n times.  
> k=2,n=1: Bernoulli distribution   
> k=2,n>1: Binomial distribution  
> k>2,n=1: Categorical distribution

 > Discrete uniform distribution is a type of probability distribution where every possible outcome within a given finite set has an equal probability of occurring. eg. rolling a fair six-sided die.
Key Characteristics: Discrete Outcomes,Finite Set of Outcomes,Equal Probability

> PMF(probability mass function): P(X=x)= 1/n
> ​Mean and Variance for a discrete uniform distribution over integers a,a+1,...,b:

> Mean (Expected Value): E[X]= a+b/2
> ​For a standard die (a=1,b=6), the mean is (1+6)/2=3.5.
> Variance: Var(X)= ((b−a+1)^2-1)/12
> For a standard die, n=(6−1+1)=6. So, the variance is (6^2−1)/12=(36−1)/12=35/12≈2.9167.

#### Common Discrete Distributions
<img width="709" alt="image" src="https://github.com/user-attachments/assets/83aa9dc1-aca7-488a-a501-1ba7c21d82b0" />

#### Common Continuous Distributions
<img width="709" alt="image" src="https://github.com/user-attachments/assets/851b1c26-29e4-493f-8fc8-703401433495" />

#### Descriptive Statistics
<img width="644" alt="image" src="https://github.com/user-attachments/assets/47c5a397-8f37-42a7-a207-93ce441db6a7" />

#### Inferential Statistics
<img width="705" alt="image" src="https://github.com/user-attachments/assets/95b03826-7e6e-4959-976a-235a90c54d2e" />
<img width="715" alt="image" src="https://github.com/user-attachments/assets/b4c6dbe0-f282-47c3-8135-60cf62d0713e" />
<img width="714" alt="image" src="https://github.com/user-attachments/assets/5dd3154b-22bb-4561-99af-44da5811b2e4" />
<img width="710" alt="image" src="https://github.com/user-attachments/assets/f56ee798-0c71-4d53-8720-552dfe22ecbc" />

#### Hypothesis Testing
<img width="716" alt="image" src="https://github.com/user-attachments/assets/124660e0-8319-4c3a-b73c-be4da10a6a07" />
<img width="720" alt="image" src="https://github.com/user-attachments/assets/66f6b3a8-427b-48b8-a3fc-fa20613e073b" />
One tailed vs two tailed t-distributions
<img width="735" alt="image" src="https://github.com/user-attachments/assets/2e711830-ec6a-4f52-9799-d5fbc19a5463" />


#### F test
There is no upper limit for the F-statistic value. It can theoretically range from zero to positive infinity.
<img width="741" height="589" alt="image" src="https://github.com/user-attachments/assets/12b2c859-0044-42c1-b4f7-9eafbc2b504e" />
<img width="741" height="717" alt="image" src="https://github.com/user-attachments/assets/25d1b9b3-fd8f-4756-acb2-5f814f73c18e" />


<img width="777" height="550" alt="image" src="https://github.com/user-attachments/assets/79f258d2-f021-47a3-adc7-5e50fa3ebafd" />
<img width="750" height="449" alt="image" src="https://github.com/user-attachments/assets/3d3d9c49-1770-4d7a-a517-a467288357ed" />
<img width="750" height="698" alt="image" src="https://github.com/user-attachments/assets/3c455e17-edc5-4970-a048-914c5c72ab70" />
Using the F-critical value:
This method involves comparing your calculated F-statistic to a critical value from an F-distribution table. The critical value depends on your chosen significance level (α) and the degrees of freedom for your numerator and denominator.
<img width="750" height="570" alt="image" src="https://github.com/user-attachments/assets/57f49496-5571-43c8-8fea-44dbfd1669ae" />
<img width="750" height="387" alt="image" src="https://github.com/user-attachments/assets/c55d3cd8-2f8a-4e15-8aa8-7a7860614a10" />

Rule: If the calculated F-statistic is greater than the F-critical value, you reject the null hypothesis.
This is conceptually equivalent to the p-value method, as a large F-statistic corresponds to a small p-value.

<img width="741" height="397" alt="image" src="https://github.com/user-attachments/assets/f7a5c7c0-eeec-4f3d-a578-330acc4a6e20" />

Example:
<img width="741" height="627" alt="image" src="https://github.com/user-attachments/assets/0c3e5c92-2f51-4341-a482-57a2df34bd41" />
<img width="741" height="651" alt="image" src="https://github.com/user-attachments/assets/8fa72ca7-929b-48f0-a0f2-ae7ab3a47350" />
<img width="741" height="656" alt="image" src="https://github.com/user-attachments/assets/cabe9e23-a3ad-4520-9e24-a64acd5e198b" />
p_value = stats.f.sf(f_statistic, df1, df2)

For Linear Regression: 
<img width="741" height="656" alt="image" src="https://github.com/user-attachments/assets/47d3be43-82ff-4023-b240-463e6f306a0c" />
















