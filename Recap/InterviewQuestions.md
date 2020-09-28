# Interview Questions
### How is KNN different from k-means clustering?
K-Nearest Neighbors is a supervised classification algorithm, while k-means clustering is an unsupervised clustering algorithm. 
KNN: k is the number of neighbours, K-Means: k is the number of clusters

### Cross-validation on Time series:
Fold 1 : training [1], test [2]  
Fold 2 : training [1 2], test [3]  
Fold 3 : training [1 2 3], test [4]  

### Accuracy Paradox
The accuracy paradox is the paradoxical finding that accuracy is not a good metric for predictive models when classifying in predictive analytics. For e.g., if the incidence of category A is dominant, being found in 99% of cases, then predicting that every case is category A will have an accuracy of 99%. Precision and recall are better measures in such cases
