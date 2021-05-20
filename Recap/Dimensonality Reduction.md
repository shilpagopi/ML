# Dimensionality Reduction

#### Why to reduce dimensions? 
 * Avoid overfitting; When dim increases, generalization becomes exponentially harder, as training dataset represents only a smaller fraction of input space
 * Improve model efficiency: time and space complexity - reduced feature set boosts learning rates and removes redundant features
 * Filter noisy datasets: least significant component captures most noise.
 * Visualization, interpretability 

#### Principal Component Analysis (PCA)
* unsupervised, non-parametric statistical technique
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

#### Disadvantages
* PCA can lead to low model performance after applying it if the original dataset has a weak correlation or no correlation. The variables need to be related to one other to apply PCA perfectly.


