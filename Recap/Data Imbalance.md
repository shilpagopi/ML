# Handling Data Imbalance
* Data-based approaches: Use under sampling or over sampling to balance the data (oversampling - overfitting, undersampling - info loss), synthetic data generation(eg. SMOTE)
* Algorithmic approaches: Ensemble methods(Eg.Random Forest, XGBoost), Cost-Sensistive Learning : Change the prediction threshold value, Assign larger sample weights to minority labels
* Use apt eval metrics (prec, rec, f1 instead of accuracy)
* Othe rmethods: Collect more data, Feature Engineering, Anomaly detection algorithms (If the minority class truly represents anomalies or outliers), Change the Problem Formulation

### 1.Data-Level Approaches (Resampling Techniques)

#### Oversampling the Minority Class
* Random oversampling
* SMOTE like techniques
Caution: Apply resampling only to the training data; ensure that the resampling happens within each fold of your cross-validation to prevent data leakage

##### How SMOTE(Synthetic Minority Over-sampling Technique) Works
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

##### Advantages of SMOTE:
Reduces Overfitting: Unlike simple oversampling (duplicating existing samples), SMOTE creates unique synthetic samples, which helps to reduce the risk of overfitting to specific minority class examples.
Introduces Variability: By interpolating between existing samples, SMOTE generates new samples that are in the "feature space" of the minority class, increasing the diversity of the minority class data.
Improves Model Performance: By balancing the class distribution, SMOTE allows classification algorithms to learn the patterns of the minority class more effectively, leading to better generalization and improved performance metrics (especially recall, precision, and F1-score for the minority class).
Versatile: SMOTE can be applied with various machine learning classifiers.

##### Disadvantages and Limitations of SMOTE:
Generates Samples Without Considering the Majority Class: SMOTE generates synthetic samples solely based on the minority class. It doesn't consider the majority class, which can lead to synthetic samples being generated in regions where the minority and majority classes overlap. This can blur the decision boundary and introduce noise.
Can Increase Noise: If the original minority class samples contain outliers or noise, SMOTE will generate synthetic samples around these noisy points, potentially amplifying the noise in the dataset.
Less Effective in High-Dimensional Data: In very high-dimensional feature spaces, the concept of "nearest neighbors" can become less meaningful due to the "curse of dimensionality," potentially reducing SMOTE's effectiveness.
Not Suitable for Categorical Features (Vanilla SMOTE): The basic SMOTE algorithm relies on numerical distances and interpolation, making it unsuitable for datasets with purely categorical features. Variants like SMOTE-NC (for Nominal and Continuous) and SMOTEN (for Nominal) have been developed to handle mixed or purely categorical data.
May Create Overlapping Samples: If the minority and majority classes are intrinsically very close or overlapping in the feature space, SMOTE might generate synthetic samples that fall into the majority class region, making classification harder.

##### Variants of SMOTE:
Due to its limitations, several variants of SMOTE have been developed to improve its performance in specific scenarios:

Borderline-SMOTE: Focuses on generating synthetic samples for minority class instances that are on the "border" of the decision boundary, as these are often the most difficult to classify correctly.
ADASYN (Adaptive Synthetic Sampling): Generates more synthetic samples for minority class instances that are harder to learn (i.e., those that have more majority class neighbors).
SMOTE-ENN (Edited Nearest Neighbors): Combines SMOTE with an "editing" technique (ENN) to remove noisy or ambiguous samples after oversampling, cleaning up the decision boundary.
SMOTE-Tomek Links: Combines SMOTE with Tomek Links (which identifies pairs of samples from different classes that are each other's nearest neighbors, suggesting a boundary or noise) to remove redundant or noisy samples.

###### Borderline-SMOTE
Problem Addressed: Standard SMOTE can generate synthetic samples anywhere in the feature space of the minority class, including in safe regions far from the decision boundary. This might not be as effective in improving the classifier's ability to distinguish between classes, especially for minority instances that are difficult to classify because they lie close to the majority class.

How it Works: Borderline-SMOTE focuses on generating synthetic samples only for minority class instances that are on the "borderline" or close to the decision boundary. These are the samples that are most likely to be misclassified. Identify Borderline Minority Samples: For each minority instance, Borderline-SMOTE first finds its k nearest neighbors. It then counts how many of these k neighbors belong to the majority class.

* "Danger" Samples: If a minority instance has more than half of its k neighbors belonging to the majority class, it's considered a "danger" or "borderline" sample. These are the critical points.
* "Noise" Samples: If all of its k neighbors belong to the majority class, it's considered a "noise" sample and is typically ignored (not used for synthetic generation).
* "Safe" Samples: If all of its k neighbors belong to the minority class, it's a "safe" sample and also not prioritized for generation.
Generate Synthetic Samples from Borderline Points: Only the "danger" (borderline) minority samples are used to generate synthetic instances. The generation process is similar to original SMOTE: it interpolates between the "danger" minority sample and one of its minority class nearest neighbors.

Variants:
* Borderline-SMOTE1: Generates synthetic samples by interpolating between a "danger" minority instance and its minority class neighbors.
* Borderline-SMOTE2: Generates synthetic samples by interpolating between a "danger" minority instance and any of its neighbors (could be minority or majority class). However, the interpolation factor is typically chosen to ensure the new sample stays closer to the minority class to avoid blurring the boundary too much.
Benefit: By concentrating synthetic sample generation on the critical decision boundary region, Borderline-SMOTE can create more informative samples, leading to a clearer and more robust decision boundary.

###### ADASYN (Adaptive Synthetic Sampling)
Problem Addressed: Standard SMOTE generates the same number of synthetic samples for every minority class instance, regardless of how "hard" that instance is to learn. Some minority instances might be easy to classify (e.g., in a dense cluster), while others are much harder (e.g., near the majority class).

How it Works: ADASYN adaptively shifts the decision boundary by generating more synthetic data for minority class instances that are harder to learn (i.e., those that are surrounded by more majority class instances).

Calculate "Hardness" for Each Minority Instance: For each minority instance x_i, ADASYN calculates a ratio r_i based on the number of majority class instances among its k nearest neighbors.

A higher r_i means the minority instance x_i is harder to learn (more majority neighbors around it).
This ratio r_i is then normalized to form a probability distribution.
Adaptive Synthetic Sample Generation: The number of synthetic samples to be generated for each minority instance is proportional to its r_i value.

Minority instances that are harder to learn (higher r_i) will have more synthetic samples generated around them.
Minority instances that are easier to learn (lower r_i) will have fewer synthetic samples generated around them.
Generation Process: The synthetic sample generation itself is similar to SMOTE, involving interpolation between a minority instance and one of its minority nearest neighbors.

Benefit: ADASYN is "adaptive" because it focuses more synthetic sample generation on regions where the minority class is sparse or where the decision boundary is ambiguous. This helps to reduce bias towards easy-to-learn minority examples and directs more learning effort to the challenging ones.

#### Undersampling the Majority Class
* Random Undersampling: Simple, reduces training time. Can lead to significant loss of potentially valuable information from the majority class.
* NearMiss: Selects majority class samples whose average distance to the k-nearest minority class samples is smallest. Aims to keep only "borderline" majority samples.
* Tomek Links: Identifies pairs of samples from different classes that are each other's nearest neighbors. Removing the majority class sample from such a pair helps to clean the class boundary.
* Edited Nearest Neighbors (ENN): Removes samples from the majority class if their k-nearest neighbors mostly belong to a different class, thus cleaning noisy or overlapping majority samples.
* Cluster Centroids: Replaces clusters of majority instances with the cluster centroids, effectively summarizing the majority class.

#### Combined Sampling Approaches:
Using both oversampling and undersampling. Eg. SMOTE + Tomek Links / SMOTE + ENN

### 2.Algorithm-Level Approaches (Cost-Sensitive Learning)
* Adjust sample weights: Example: In scikit-learn, many classifiers (e.g., LogisticRegression, SVC, RandomForestClassifier, GradientBoostingClassifier) have a class_weight parameter (often set to 'balanced'), which assigns weights inversely proportional to classes.<img width="617" alt="image" src="https://github.com/user-attachments/assets/1851dff7-2917-45fa-8373-963b90e9e57d" />
Note that sample weights assigned during the training phase of a decision tree classifier or regressor are generally NOT used during inferencing (prediction).
* Change the prediction threshold value (For models that output probabilities (like logistic regression))

### 3.Ensemble Methods
Combining multiple models can improve performance on imbalanced datasets.
Bagging (e.g., BalancedBaggingClassifier): Trains multiple base learners on different subsets of the data. For imbalanced data, each subset can be sampled to be balanced.
Boosting (e.g., AdaBoost, Gradient Boosting): Sequentially builds models, with later models focusing more on instances that earlier models misclassified. AdaBoost can inherently pay more attention to misclassified minority samples.
  
