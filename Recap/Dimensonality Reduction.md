# Dimensionality Reduction

#### Why to reduce dimensions? 
 * Avoid overfitting; When dim increases, generalization becomes exponentially harder, as training dataset represents only a smaller fraction of input space
 * Improve model efficiency: time and space complexity - reduced feature set boosts learning rates and removes redundant features
 * Filter noisy datasets: least significant component captures most noise.
 * Visualization, interpretability 

#### Principal Component Analysis (PCA)
* unsupervised (target variable does not matter), non-parametric statistical technique
* Curse of Dimensionality where “Many algorithms that work fine in low dimensions become intractable when the input is high-dimensional"
* PCA makes maximum variability in the dataset more visible by rotating the axes. Principal component captures the most variance
* PCA involves the transformation of variables in the dataset into a new set of uncorrelated, orthogonal variables which are called PCs (Principal Components). 
* n dataset variables => number of principal components

#### How to compute new features using PCA?
* Normalize data, as variance computed is sensitive to scaling
* Compute covariance matrix: The off-diagonal elements represent the covariance among each pair of variables and the diagonal elements represent variances of each variable.
* Find eigen vectors for cov matrix: (A - ƛI).v = 0
* Form a feature maatrix using selected eigen vectors
* New features = Scaled Data x Feature Matrix

#### Covariance
> cov = (1/N)(Summation of (Xi-X)(Yi-Y))  
> where X, Y are means and N = n-1 for sample, N = n for population

#### Assumptions
* Sample size: Minimum of 150 observations and ideally a 5:1 ratio of observation to features (Pallant, 2010)
* Correlations: The feature set is correlated, so the reduced feature set effectively represents the original data space.
* Linearity: All variables exhibit a constant multivariate normal relationship, and principal components are a linear combination of the original features.
* Outliers: No significant outliers in the data as these can have a disproportionate influence on the results.
* Large variance implies more structure: high variance axes are treated as principal components, while low variance axes are treated as noise and discarded.

#### Disadvantages
* May lower model performance if original features have a weak/no correlation or do not meet the assumptions of linearity.
* Classification accuracy: If the differentiating characteristics of the classes lie in low variance components, they may be lost.
* Outliers: PCA is also affected by outliers, and normalization of the data needs to be an essential component of any workflow.
* Interpretability: Each principal component is a combination of original features and does not allow for the individual feature importance to be recognized

