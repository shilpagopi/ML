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

### How SMOTE(Synthetic Minority Over-sampling Technique) Works
SMOTE addresses class imbalance by generating synthetic (artificial) samples for the minority class, rather than simply duplicating existing minority class samples (which can lead to overfitting). It creates new data points that are similar to existing minority class samples but are not exact copies, thereby enriching the minority class and helping the model learn more robust patterns.

Here's a step-by-step breakdown of the SMOTE algorithm:
Identify Minority Class Instances: SMOTE first identifies all the data points belonging to the minority class.
Select a Minority Class Instance: For each minority class instance, SMOTE selects it as a "seed" point.
Find K-Nearest Neighbors: It then finds its k nearest neighbors (typically using Euclidean distance) within the same minority class. The value of k is a user-defined parameter (commonly k=5).
Generate Synthetic Samples: For each seed point and its selected neighbors:
Randomly choose one of the k nearest neighbors.
Calculate the difference vector between the seed point and the chosen neighbor.
Multiply this difference vector by a random number between 0 and 1 (inclusive).
Add this result to the features of the original seed point to create a new, synthetic data point.
Mathematically, if x_i is the minority class instance and x_zi is one of its k nearest neighbors in the minority class, a new synthetic instance is generated as:
x_new=x_i+rand(0,1)×(x_zi−x i) where rand(0,1) is a random number between 0 and 1.
Repeat: This process is repeated until the desired balance between the minority and majority classes is achieved (e.g., minority class size equals majority class size, or a specified ratio).

###### Advantages of SMOTE:
Reduces Overfitting: Unlike simple oversampling (duplicating existing samples), SMOTE creates unique synthetic samples, which helps to reduce the risk of overfitting to specific minority class examples.
Introduces Variability: By interpolating between existing samples, SMOTE generates new samples that are in the "feature space" of the minority class, increasing the diversity of the minority class data.
Improves Model Performance: By balancing the class distribution, SMOTE allows classification algorithms to learn the patterns of the minority class more effectively, leading to better generalization and improved performance metrics (especially recall, precision, and F1-score for the minority class).
Versatile: SMOTE can be applied with various machine learning classifiers.

###### Disadvantages and Limitations of SMOTE:
Generates Samples Without Considering the Majority Class: SMOTE generates synthetic samples solely based on the minority class. It doesn't consider the majority class, which can lead to synthetic samples being generated in regions where the minority and majority classes overlap. This can blur the decision boundary and introduce noise.
Can Increase Noise: If the original minority class samples contain outliers or noise, SMOTE will generate synthetic samples around these noisy points, potentially amplifying the noise in the dataset.
Less Effective in High-Dimensional Data: In very high-dimensional feature spaces, the concept of "nearest neighbors" can become less meaningful due to the "curse of dimensionality," potentially reducing SMOTE's effectiveness.
Not Suitable for Categorical Features (Vanilla SMOTE): The basic SMOTE algorithm relies on numerical distances and interpolation, making it unsuitable for datasets with purely categorical features. Variants like SMOTE-NC (for Nominal and Continuous) and SMOTEN (for Nominal) have been developed to handle mixed or purely categorical data.
May Create Overlapping Samples: If the minority and majority classes are intrinsically very close or overlapping in the feature space, SMOTE might generate synthetic samples that fall into the majority class region, making classification harder.

###### Variants of SMOTE:
Due to its limitations, several variants of SMOTE have been developed to improve its performance in specific scenarios:

Borderline-SMOTE: Focuses on generating synthetic samples for minority class instances that are on the "border" of the decision boundary, as these are often the most difficult to classify correctly.
ADASYN (Adaptive Synthetic Sampling): Generates more synthetic samples for minority class instances that are harder to learn (i.e., those that have more majority class neighbors).
SMOTE-ENN (Edited Nearest Neighbors): Combines SMOTE with an "editing" technique (ENN) to remove noisy or ambiguous samples after oversampling, cleaning up the decision boundary.
SMOTE-Tomek Links: Combines SMOTE with Tomek Links (which identifies pairs of samples from different classes that are each other's nearest neighbors, suggesting a boundary or noise) to remove redundant or noisy samples.

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

### What is Bootstrapping?
Definition: Bootstrapping is a statistical procedure that involves resampling a single observed data set to create many simulated samples. This technique is used to estimate the sampling distribution of a statistic (like a mean, median, standard error, or confidence interval) when the underlying population distribution is unknown or difficult to work with.

How it Works (Simplified):
Original Sample: You have a single sample of data.
Resampling with Replacement: You repeatedly draw new "bootstrap samples" from your original sample, with replacement. This means a data point can be selected multiple times for the same bootstrap sample. Each bootstrap sample is typically the same size as the original sample.

Calculate Statistic: For each bootstrap sample, you calculate the statistic of interest (e.g., the mean of that sample).
Create Distribution: After many repetitions (often thousands), you'll have a distribution of your statistic.
Inference: This distribution can then be used to estimate things like the standard error of the statistic, construct confidence intervals, or perform hypothesis testing.

Benefits:
Distribution-Independent: It doesn't require assumptions about the underlying distribution of the population (e.g., normality), which is useful when traditional parametric methods aren't suitable.
Simplicity: It's conceptually straightforward and can be applied to a wide range of statistics.
Handles Complex Estimators: It can be used for complex statistics where analytical formulas for standard errors or confidence intervals are unavailable.

#### Types of Cross-Validation
K-Fold Cross-Validation, Stratified K-Fold Cross-Validation,Leave-One-Out Cross-Validation (LOOCV): Each data point is used as a validation set once - computationally expensive for large datasets.
