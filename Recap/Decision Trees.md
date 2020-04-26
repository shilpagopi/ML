# Decision Trees
Decision Tree algorithms are referred to as CART (Classification and Regression Trees), as they can be used to predict categorical and continuous target variables.

### Node-Splitting Criteria
#### 1. Entropy
Entropy of a parent node, E(parent):   
<img src="https://miro.medium.com/max/446/0*BdgOokoatW17zEK7.png" width="400" height="250">  
Entropy after splitting based on a feature, E(parent,feature):     
<img src="https://miro.medium.com/max/491/0*d-tAV4Ci2D2mzhrg.png" width="600" height="400">  
#### 2. Information gain
> IG =   E(parent) - E(parent,feature)
#### 3. Gini index
<img src="https://miro.medium.com/max/417/1*QF-JeWpQQ86xhRhseHGecg.png" width="250" height="75">

#### 4. Reduction in Variance  
Calculate variance for each split as the weighted average of each node variance.  
<img src="https://miro.medium.com/max/300/0*cTpeBgM-byR-rWx_.png" width="250" height="75"> 
