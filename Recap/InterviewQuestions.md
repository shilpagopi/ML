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
* Use under sampling or over sampling to balance the data (oversampling - overfitting, undersampling - info loss)
* Change the prediction threshold value
* Assign larger sample weights to minority labels
* Use apt eval metrics (prec, rec, f1 instead of accuracy)
* Detect anomalies

### Maximum Likelihood Estimation (MLE)
The likelihood function is essentially the joint probability (or probability density) of observing your given data, viewed as a function of the unknown parameters θ.
Steps to Find the MLE:
Assume a Probability Distribution: Based on your knowledge of the data, assume a statistical model (e.g., Bernoulli, Normal, Poisson).
Write Down the Likelihood Function: Formulate L(θ) based on your assumed distribution and observed data.
Write Down the Log-Likelihood Function: Take the natural logarithm of L(θ).
Differentiate and Set to Zero: Take the partial derivative of the log-likelihood function with respect to each parameter in θ, and set the derivatives equal to zero.
Solve for the Parameter(s): Solve the resulting equation(s) to find the value(s) of θ that maximize the log-likelihood. This value is your Maximum Likelihood Estimate ( θ_MLE).
Verify Maximum: (Optional but good practice) Check the second derivative to ensure it's a maximum (concave down) and not a minimum or saddle point.

<img width="725" alt="image" src="https://github.com/user-attachments/assets/11b37843-487b-4cea-a80d-e987af7e231c" />
<img width="725" alt="image" src="https://github.com/user-attachments/assets/b449f45d-5b00-4c4e-abd4-59f4f0c96156" />


### Why Log-Likelihood?
Often, it's easier to work with the log-likelihood function (the natural logarithm of the likelihood function) because:
* Simplifies Calculations: Products become sums, which are much easier to differentiate. logL(θ)=∑ log(P(x_i∣θ))
* Monotonicity: The logarithm is a monotonically increasing function, meaning that maximizing logL(θ) is equivalent to maximizing L(θ). The value of θ that maximizes one will also maximize the other.
* Numerical Stability: Multiplying many small probabilities can lead to very small numbers, which can cause underflow errors in computer calculations. Summing logarithms avoids this.
### CRV curves? Lift Curves?

#### Types of Cross-Validation
K-Fold Cross-Validation, Stratified K-Fold Cross-Validation,Leave-One-Out Cross-Validation (LOOCV): Each data point is used as a validation set once - computationally expensive for large datasets.
