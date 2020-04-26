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
Calculate gini index for each split, as the weighted Gini score of each node of that split  
<img src="https://miro.medium.com/max/417/1*QF-JeWpQQ86xhRhseHGecg.png" width="250" height="75">

### 4. Reduction in Variance  
Calculate variance for each split as the weighted average of each node variance.  
<img src="https://miro.medium.com/max/300/0*cTpeBgM-byR-rWx_.png" width="250" height="75"> 

## How to avoid overfitting?
* **Pruning**
  * Minimum samples for a terminal node
  * Maximum depth of tree
  * Maximum features to consider for split
* **Random forest**

## Decision trees vs Linear models?
* Choose linear regression, if the relationship between dependent & independent variable is well approximated by a linear model
* Choose decision tree, if there is a high **non-linearity and complex relationship** between dependent & independent variables

## Advantages
* Implicitly perform variable screening or feature selection
* Nonlinear relationships between parameters do not affect tree performance

## Disadvantages
* Unstable and **sensitive to variance**,as small variations in data might generate a completely different tree
* Greedy algorithms cannot guarantee to return the **globally optimal** decision tree
* May generate **biased** trees if some classes dominate (unbalanced data)
