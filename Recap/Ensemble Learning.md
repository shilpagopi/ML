# Ensemble Learning
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
* Random subset of features considered for splitting, at each node

**Probability Estimation**  
a) Fraction of trees voting for a class (hard voting)  
b) Average of terminal leaf probabilities  

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
