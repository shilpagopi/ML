# Decision Trees
Decision Tree algorithms are referred to as CART (Classification and Regression Trees), as they can be used to predict categorical and continuous target variables.

## Node-Splitting Criteria
### 1. Entropy
Entropy of a parent node, E(parent):   
<img src="https://miro.medium.com/max/446/0*BdgOokoatW17zEK7.png" width="400" height="250">  
Entropy after splitting based on a feature, E(parent,feature):     
<img src="https://miro.medium.com/max/491/0*d-tAV4Ci2D2mzhrg.png" width="600" height="400">  
### 2. Information gain
> IG =   E(parent) - E(parent,feature)

### 3. Gini index
Calculate gini index for each split, as the weighted Gini score of each node of that split (similar to entropy) 
Gini index range: 0(pure) to 0.5(most impure)
<img src="https://miro.medium.com/max/417/1*QF-JeWpQQ86xhRhseHGecg.png" width="250" height="75">

### 4. Reduction in Variance  
Calculate variance for each split as the weighted average of each node variance.  
<img src="https://miro.medium.com/max/300/0*cTpeBgM-byR-rWx_.png" width="250" height="75"> 

### 5. Reduction in MSE (for regression)  
Calculate MSE for each split as the weighted average of each node MSE.

### 6.Continuous Variable
Sort the data, the potential split points are typically the midpoints between consecutive values.
Heuristics: Random Selection of Split Points, Percentiles (focuses on regions with higher data density), Entropy-Based Sampling (calculating entropy for different intervals of the continuous variable)

### Prediction from a single impure leaf node
* Majority Voting/Probability-Based Prediction:
* Confidence-Based Prediction:if probability(class) in leaf node is below a confidence threshold, assign a default class.

## How to avoid overfitting?
* **Pruning**
* Pre-pruning
  * Minimum samples for a terminal node
  * Maximum depth of tree
  * Maximum features to consider for split
  * Minimum information gain
* Postpruning
  * Cost-complexity pruning: A cost-complexity parameter is introduced to balance tree size and accuracy.
  * Error-based pruning: Subtrees are removed if their removal doesn't increase the error rate significantly.
    
* **Random forest**

## Decision trees vs Linear models?
* Choose linear regression, if the relationship between dependent & independent variable is well approximated by a linear model
* Choose decision tree, if there is a high **non-linearity and complex relationship** between dependent & independent variables

## Advantages
* Implicitly perform variable screening or feature selection
* Nonlinear relationships between parameters do not affect tree performance
* Can handle missing data
* Handling mixed data types
* Interpretability and Explainability

## Disadvantages
* Unstable and **sensitive to variance**,as small variations in data might generate a completely different tree
* Greedy algorithms cannot guarantee to return the **globally optimal** decision tree
* May generate **biased** trees if some classes dominate (unbalanced data)

### Algorithms comparison
Feature| ID3	| C4.5	| CART|
--|--|--|--
Data type	| Categorical	|Categorical and continuous	|Categorical and continuous
Splitting criterion|	Information gain|	Gain ratio	|Gini impurity (classification), squared error (regression)
Handling missing values	|No	|Yes	|Yes
Pruning	|No	|Yes|	Yes
Tree structure	|Multi-way splits|	Multi-way splits	|Binary splits
