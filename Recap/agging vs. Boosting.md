# Bagging vs. Boosting
Characteristic|Bagging (Bootstrap Aggregation)|Boosting
--------------|-------|--------
Dataset creation|Random subsets, of same size as original dataset, of the original training set are created by bootstraping(picking at random) with replacement and repetitions.|Sequentially with more weightage to the instances misclassified by previous model
Training|The models run in parallel and are independent of each other|Sequential process, where each subsequent model attempts to correct the errors of the previous model.
Model Weightage|Each model receives equal weight|Models are weighted according to their performance
Prediction|Majority voting or Aggregation principle|Weighted average of weak learners based on their performance
Betterment| Higher stability, decreased model variance (as they combine estimates from several models)|Higher stability, decreased model variance and bias, may increase over-fitting
Example|Random Forest|Adaboost

**Stacking**: Another meta-algorithm, normally used in competitions, when multiple algorithms are used to train on the same data set and average(max, min or other combinations) the result to obtain higher prediction accuracy

### Random Forest
**Randomness**
* Random sampling of training data points with replacement (bootstrapping) when building trees
* Random subset of features considered for splitting, at each node. sqrt(#features) or log2(#features) or None

**Probability Estimation**  
a) Fraction of trees voting for a class (hard voting)  
b) Average of terminal leaf probabilities  

**How to train**:
Hyperparameters: n_estimators (Number of Trees), number of features, max_depth, min_samples_leaf, set oob_score=True, n_jobs=-1 (to leverage all CPU cores)
oob_score (Out-of-Bag Score):
What it is: A boolean flag to calculate the out-of-bag (OOB) error. OOB samples are those training instances not included in a particular tree's bootstrap sample. These can be used as a validation set for that tree.
Monitor model performance as you increase n_estimators and see when the OOB error stabilizes.
RandomizedSearchCV instead of gridsearch for other hyperparameter tuning, if the dataset has say 1m rows.

#### Bias and Variance of a Single Decision Tree
High Variance: A single, unpruned decision tree tends to have high variance. This is because decision trees are very flexible models that can fit the training data extremely well, sometimes even perfectly. They are prone to overfitting, meaning they learn the noise in the training data in addition to the underlying patterns. If you were to train a decision tree on a slightly different subset of the training data, the resulting tree structure and predictions could change drastically. This sensitivity to the training data is the hallmark of high variance.

Low Bias: Conversely, a single, unpruned decision tree tends to have low bias. This is because, given enough depth, a decision tree can capture complex, non-linear relationships in the data. It can model almost any function, leading to a low systemic error (bias) in its predictions on the training data.
Bias and Variance of a Random Forest
Random Forest leverages the bias-variance tradeoff to achieve better overall performance than a single decision tree. It does this by combining multiple decision trees using a technique called bootstrap aggregating (bagging) and introducing additional randomness.

Here's how Random Forest typically behaves in terms of bias and variance:

Variance: Significantly Reduced
This is the primary strength of Random Forest. It reduces variance through two main mechanisms:

Bagging (Bootstrap Aggregating):
Random Forest builds multiple decision trees (the "forest"), where each tree is trained on a different bootstrap sample (a random sample with replacement) of the original training data.
Since each tree sees a slightly different subset of the data, they will make different errors.
For regression, the final prediction is the average of the predictions from all individual trees. For classification, it's a majority vote. Averaging (or voting) uncorrelated errors significantly reduces the variance of the overall ensemble. The more uncorrelated the trees are, the greater the variance reduction.

Feature Randomness (Random Subspace Method):
At each node in each individual tree, Random Forest considers only a random subset of the available features when determining the best split. This further decorrelates the trees, as they are less likely to split on the same strong features repeatedly. If one or two features are very strong predictors, a standard bagging approach might lead to very similar trees. By limiting feature consideration, Random Forest ensures greater diversity among the trees.

Bias: Slightly Increased (or similar to a single tree, depending on the context)
While the primary goal of Random Forest is variance reduction, it can introduce a slight increase in bias compared to a single unpruned decision tree. This is because:

Feature Randomness: By randomly selecting a subset of features at each split, individual trees might not always find the globally optimal split, potentially introducing a small amount of additional bias in each tree.
Averaging: Averaging multiple biased models doesn't necessarily reduce bias. However, the bias of a Random Forest is generally comparable to or only slightly higher than that of a single decision tree that is allowed to grow deep (low bias). The key is that the massive reduction in variance typically far outweighs any minor increase in bias, leading to a much better overall model.

### AdaBoost (Adaptive Boosting)
```
a) Count of dataset instances = n
b) Initial weightage of each instance = 1/n
c) Find best feature to split on (e.g. using weighted gini index)
d) Error rate, E = sum of weightage of all misclassified instances/ total sum of weights
e) Stage value(Amount of Say of each weak classifier) = ln((1-E)/E)
f) Update weights of misclassified instances: New weightage = weight*exp(stage value)
g) Normalize all weights (i.e,sum = 1)
h) Create new classifier
i) Predictions: Weighted average of individual classifier prediction using stage value
```
