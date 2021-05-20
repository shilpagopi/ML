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
* PCA involves the transformation of variables in the dataset into a new set of variables which are called PCs (Principal Components). 
* The principal components would be equal to the number of original variables in the given dataset.
* One method to find PCA: First compute covariance matrix and then find eigen vectors for cov matrix

#### Covariance
> cov = (1/N)(Summation of (Xi-X)(Yi-Y))  
> where X, Y are means and N = n-1 for sample, N = n for population
