# Interview Questions

### Accuracy Paradox
The accuracy paradox is the paradoxical finding that accuracy is not a good metric for predictive models when classifying in predictive analytics. For e.g., if the incidence of category A is dominant, being found in 99% of cases, then predicting that every case is category A will have an accuracy of 99%. Precision and recall are better measures in such cases

### Kernel trick
Using the kernel trick enables us effectively run algorithms in a high-dimensional space with lower-dimensional data. This is done using the inner products between the images of all pairs of data in a feature space, without explicitly calculating the coordinates of points.

### How to set classifier threshold?
* Plot ROC curve for various thresholds  
* G-Mean = sqrt(Sensitivity * Specificity)  
* Select the threshold with the largest G-Mean value.

### How to handle data imbalance
* Use under sampling or over sampling to balance the data
* Change the prediction threshold value
* Assign laregr sample weights to minority labels 
* Detect anomalies

### CRV curves? Lift Curves?

### AI, ML, DL, Data Mining
DL -> subset of -> ML -> subset of -> AI 

#### Types of Cross-Validation
K-Fold Cross-Validation, Stratified K-Fold Cross-Validation,Leave-One-Out Cross-Validation (LOOCV): Each data point is used as a validation set once - computationally expensive for large datasets.
