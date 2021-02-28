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

### Kernel trick
Using the kernel trick enables us effectively run algorithms in a high-dimensional space with lower-dimensional data. This is done using the inner products between the images of all pairs of data in a feature space, without explicitly calculating the coordinates of points.

### Standard GD vs Stochastic GD
In standard gradient descent, you'll evaluate all training samples for each set of parameters. This is akin to taking big, slow steps toward the solution.
In stochastic gradient descent, you'll evaluate only 1 training sample for the set of parameters before updating them. This is akin to taking small, quick steps toward the solution.

### How to set classifier threshold?
* Plot ROC curve for various thresholds  
* G-Mean = sqrt(Sensitivity * Specificity)  
* Select the threshold with the largest G-Mean value.

### Why not use linear regression in place of logistic regression for binary classification?
* Distribution of error terms: Linear regression assumes that error terms are normally distributed. In case of binary classification, this assumption does not hold true, as the data distribution is different.
* Model output: In linear regression, the output is continuous. Also, the predict values that can go beyond 0 and 1. If we want the output in the form of probabilities, which can be mapped to two different classes, then its range should be restricted to 0 and 1.
* Variance of Residual errors: Linear regression assumes that the variance of random errors is constant. This assumption is also violated in case of logistic regression.

### Inductive vs Deductive
Inductive learning is the process of using observations to draw conclusions 
Deductive learning is the process of using conclusions to form observations 

### When would you use random forests Vs SVM and why?
* Random forests allow you to determine the feature importance. SVM’s can’t do this.
* Random forests are much quicker and simpler to build than an SVM.
* For multi-class classification problems, SVMs require a one-vs-rest method, which is less scalable and more memory intensive.

### Which algorithm is better at handling outliers logistic regression or SVM?
Logistic regression will find a linear boundary if it exists to accommodate the outliers. Logistic regression will shift the linear boundary in order to accommodate the outliers. SVM is insensitive to individual samples. There will not be a major shift in the linear boundary to accommodate an outlier. SVM comes with inbuilt complexity controls, which take care of overfitting. This is not true in case of logistic regression.+

### CRV curves? Lift Curves?

### Parametric vs Non-parametric Algorithm ?
* Parametric:  Once we’ve fit the finite no. of parameters and stored them away, the training data is not required to make future predictions. 
Eg. Linear Regression

* Non-Parametric: Need training data to make predictions. Storage to represent hypothesis grows linearly with the size of the training set.
Eg. Locally weighted linear regression algorithm.
