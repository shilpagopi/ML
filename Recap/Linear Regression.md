## Linear Regression

* Core idea: Fit a line to data
* Linear Regression is a machine learning algorithm based on supervised learning. 
* Regression models a target prediction value based on independent variables.
* Assumption: Errors are normally distributed, Variance of errors is constant. Variance of predictions is zero as the lie on straight line.

### _Cost function: MSE_

<img src="https://camo.githubusercontent.com/fb05a923f3c55f93488175bfc50b8a9349de312c/68747470733a2f2f6d69726f2e6d656469756d2e636f6d2f6d61782f3630302f312a337742356f746b674b456976395836476464307232514032782e706e67" alt="drawing" width="300" height="75"/>

### _R-Squared_

<img src="https://miro.medium.com/max/1406/1*_HbrAW-tMRBli6ASD5Bttw.png" width="400" height="75"/>

Two popular examples of regularization:
Lasso Regression: where J is modified to minimize the absolute sum of the coefficients (called L1 regularization).
Ridge Regression: ... L2 regularization

* Why is least square function an apt loss function for linear regression?  
y = wTx + e(=Error term)  
e is distributed IID (independently and identically distributed) according to a Gaussian distribution (also called a Normal distribution) mean *zero* and some variance σ^2.  
e ~ N(0,σ^2), y ~ N(wTx,σ^2)  
Least square function can be obtained by calculating log likelihood, P(y/x) = P(e), since w is fixed.  
