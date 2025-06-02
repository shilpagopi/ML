## Linear Regression

* Core idea: Fit a line to data
* Linear Regression is a machine learning algorithm based on supervised learning. 
* Regression models a target prediction value based on independent variables.
  
### Assumptions:
* Errors are normally distributed, Variance of errors is constant. Variance of predictions is zero as the lie on straight line.
* Linearity: The relationship between the dependent variable and each independent variable should be linear. This can be checked by scatter plots of the dependent variable against each independent variable.
Independence of Errors (No Autocorrelation): The residuals (errors) should be independent of each other. This is particularly important for time-series data. The Durbin-Watson test can be used to check for autocorrelation.
* Homoscedasticity: The variance of the residuals should be constant across all levels of the independent variables. In other words, the spread of the residuals should be roughly the same throughout the range of predicted values. A scatter plot of residuals versus predicted values can help visualize this.
* Normality of Residuals: The residuals should be approximately normally distributed. This assumption is less critical for large sample sizes due to the Central Limit Theorem but is important for valid hypothesis testing and confidence intervals. Histograms or Q-Q plots of residuals can check this.
* No Multicollinearity: The independent variables should not be highly correlated with each other. High multicollinearity can make it difficult to estimate the individual coefficients accurately and can lead to an unstable model. This is checked using methods like Variance Inflation Factor (VIF), as discussed previously.
* No Outliers: There should be no extreme outlier data points that exert undue influence on the regression line.

### _Cost function: MSE_

<img src="https://camo.githubusercontent.com/fb05a923f3c55f93488175bfc50b8a9349de312c/68747470733a2f2f6d69726f2e6d656469756d2e636f6d2f6d61782f3630302f312a337742356f746b674b456976395836476464307232514032782e706e67" alt="drawing" width="300" height="75"/>

### _R-Squared_

<img src="https://miro.medium.com/max/1406/1*_HbrAW-tMRBli6ASD5Bttw.png" width="400" height="75"/>

R_2(coefficient of determination)is a statistical measure that represents the proportion of the variance in the dependent variable (the outcome you're trying to predict) that can be explained by the independent variable(s) (the predictor variables) in a regression model. It helps to assess the goodness of fit of a regression model

<img width="185" alt="image" src="https://github.com/user-attachments/assets/71746d0d-32f5-464f-add9-c5bfda6a721a" />
SSE is the usual Squared Loss or Sum of Squared Errors.

R^2 = 1-(Loss/SST)
Higher is Not Always Better: A very high R^2 can sometimes indicate overfitting. Sensitive to Outliers. Increases with More Independent variables.

### Adjusted_R-Squared_
<img width="726" alt="image" src="https://github.com/user-attachments/assets/efc9429a-e04a-4691-889d-cd74a5ce796d" />

  
Two popular examples of regularization:
Lasso Regression: where J is modified to minimize the absolute sum of the coefficients (called L1 regularization).
Ridge Regression: ... L2 regularization

* Why is least square function an apt loss function for linear regression?  
y = wTx + e(=Error term)  
e is distributed IID (independently and identically distributed) according to a Gaussian distribution (also called a Normal distribution) mean *zero* and some variance σ^2.  
e ~ N(0,σ^2), y ~ N(wTx,σ^2)  
Least square function can be obtained by calculating log likelihood, P(y/x) = P(e), since w is fixed.

## Linear Regression Analysis
* Regression Coefficients (β values): These tell you the estimated change in the dependent variable for a one-unit change in the corresponding independent variable, holding all other predictors constant.
  
* P-values: For each coefficient, a p-value indicates the statistical significance of that predictor. A small p-value (typically < 0.05) suggests that the independent variable is a significant predictor of the dependent variable.

* R-squared (R_2): This value indicates the proportion of the variance in the dependent variable that is explained by the independent variables in the model. It ranges from 0 to 1, with higher values indicating a better fit.

* Adjusted R-squared: This is a modified R-squared that accounts for the number of predictors in the model. It's often preferred when comparing models with different numbers of independent variables, as R-squared tends to artificially increase with more predictors, even if they aren't useful.
  
* F-statistic and its p-value: This tests the overall significance of the entire regression model. A small p-value for the F-statistic indicates that the model as a whole is statistically significant, meaning that at least one of the independent variables contributes to explaining the variation in the dependent variable.

### How to handle multicolliearity
#### 1. Correlation Matrix
How it works: Calculate the Pearson correlation coefficient between all pairs of your independent variables.
Interpretation:
Correlation coefficients range from -1 to 1.
Values close to +1 (strong positive correlation) or -1 (strong negative correlation) indicate a strong linear relationship between the two variables.
Rule of Thumb: Absolute correlation values above 0.7 or 0.8 (some even use 0.6) are generally considered to indicate a strong pairwise correlation, which might be a sign of multicollinearity.
Limitations: This method only detects pairwise multicollinearity. It might not catch cases where three or more variables are linearly related even if no two individual variables are highly correlated.
Correlation Coefficients beyond Pearson (for specific non-linear monotonic relationships):
Spearman's Rank Correlation or Kendall's Tau: These measure the strength and direction of a monotonic relationship (where variables tend to move in the same or opposite direction, but not necessarily at a constant rate). They can detect non-linear monotonic relationships, but not complex non-monotonic ones (like U-shaped).

####  2. Variance Inflation Factor (VIF)

How it works: VIF is a more robust and widely used method. For each independent variable, VIF measures how much the variance of its estimated regression coefficient is inflated due to multicollinearity with the other independent variables in the model. The VIF for a predictor Xj= 1/(1−Rj^2) Rj is the coefficient of determination (R-squared) of a regression model that regresses Xj against all the other independent variables in the model.

Interpretation:
VIF=1: No correlation between the independent variable and any other independent variables.
1<VIF<5: Moderate correlation, generally considered acceptable.
VIF≥5 (or ≥10): Indicates severe multicollinearity. A VIF of 5 means the variance of the coefficient is inflated by a factor of 5 due to multicollinearity. Some statisticians use 5 as a warning sign, while 10 is often considered a critical threshold.
Advantages: VIF can detect multicollinearity among multiple variables, not just pairwise correlations.

#### 3. Tolerance
How it works: Tolerance is simply the reciprocal of VIF: Tolerance_j= (1−Rj^2)
 
Interpretation:
A tolerance value close to 1 indicates little multicollinearity.
A tolerance value close to 0 indicates high multicollinearity.
Rule of Thumb: A tolerance value below 0.1 (which corresponds to a VIF of 10) is a strong indicator of multicollinearity.

#### 4. Condition Index (or Condition Number)
How it works: This method is based on the eigenvalues of the correlation matrix of the independent variables. A high condition index indicates multicollinearity. It's often reported as part of a multicollinearity diagnostic table in statistical software.
Interpretation:
Condition Index <10: Weak multicollinearity.
10≤Condition Index<30: Moderate multicollinearity.
Condition Index ≥30: Strong multicollinearity.
Advantages: It can identify cases where multicollinearity exists among more than two variables, even if pairwise correlations are not high. It also gives an idea of the number of multicollinear relationships present.

#### 5. Common Sense and Domain Knowledge

### Effects of using multicollinear variables:

Inflated Standard Errors and Unstable Coefficient Estimates:

This is the most critical consequence. When independent variables are highly correlated, it becomes difficult for the model to isolate the unique effect of each individual variable on the dependent variable.
As a result, the standard errors of the regression coefficients increase significantly. Large standard errors lead to wider confidence intervals, making it more difficult to determine the precise effect of each predictor.

The coefficient estimates become highly sensitive to small changes in the data or the addition/removal of other variables. This instability means that the estimated coefficients can fluctuate wildly across different samples, making them unreliable.

Reduced Statistical Significance (Higher p-values):

Due to the inflated standard errors, the t-statistics for the individual regression coefficients decrease (since t-statistic = coefficient / standard error).
This often leads to higher p-values, which can make otherwise important predictor variables appear statistically insignificant. You might find that the overall model is statistically significant (indicated by a significant F-statistic and a high R-squared), but none or few of the individual predictors have significant p-values.
Difficulty in Interpretation:

It becomes challenging to interpret the individual impact of each multicollinear variable on the dependent variable. The regression coefficients represent the change in the dependent variable for a one-unit change in that predictor, while holding all other predictors constant.

With highly correlated variables, it's practically impossible to hold one constant while changing another, as they tend to move together. This makes the "all else constant" interpretation of the coefficients less meaningful or even misleading.
Misleading Signs of Coefficients:

In some severe cases of multicollinearity, the sign of a regression coefficient might even be opposite to what you would expect based on theory or domain knowledge. This further complicates interpretation and can lead to incorrect conclusions about the relationships between variables.
Reduced Predictive Power (for out-of-sample prediction, sometimes):

While multicollinearity doesn't inherently reduce the overall predictive power of the model within the sample (the R-squared value isn't affected), it can lead to poor out-of-sample predictions if the relationship between the collinear variables in the new data differs from that in the training data.
What multicollinearity doesn't typically affect:

Overall model fit (R-squared): The R-squared value, which indicates how much of the variance in the dependent variable is explained by the independent variables, is generally not affected by multicollinearity. The model might still explain a large portion of the variance.
Forecasts/Predictions (within the range of the observed data): If the primary goal is prediction within the range of the observed data and the pattern of multicollinearity is expected to continue in future data, multicollinearity may not be a major concern for the overall predictions. However, the reliability of the individual coefficient estimates remains an issue.

### Linear vs Non-linear Measurements
##### Can t-test or chi squared test be used for non-linear relations?
No, they are not designed to detect or analyze non-linearity, hence reveal nothing about shape, direction or strength.T-test's purpose is to compare the means of two groups to determine if they are statistically significantly different.Chi test's purpose is to assess the association or independence between two or more categorical variables. For non-linear cases, use non-linear regression(e.g., exponential, logarithmic, polynomial regression, logistic regression) and Spearman's Rank Correlation or Kendall's Tau: These measure the strength and direction of monotonic relationships only.
