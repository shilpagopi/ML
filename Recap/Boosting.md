# Boosting

The core idea is to sequentially train models, with each subsequent model focusing on correcting the errors made by the previous ones.
Improve the predictive accuracy of models by combining multiple "weak" learners into a single "strong" learner.

<img width="726" alt="image" src="https://github.com/user-attachments/assets/230ff68c-d227-4d2b-bab0-fad190ab2dfb" />

### AdaBoost (Adaptive Boosting)

<img width="726" alt="image" src="https://github.com/user-attachments/assets/b1835549-b15b-4f5b-a7e7-8cdfa14b2d71" />
<img width="716" alt="image" src="https://github.com/user-attachments/assets/ef93d441-956d-43ed-9067-c2d4cc3f8cbd" />

```
a) Count of dataset instances = n
b) Initial weightage of each instance = 1/n
c) Find best feature to split on (e.g. using weighted gini index)
d) Error rate, E = sum of weightage of all misclassified instances/ total sum of weights
e) Stage value(Amount of Say of each weak classifier) = ln((1-E)/E) 
f) Update weights of misclassified instances: New weightage = weight*exp(stage value) ?
g) Normalize all weights (i.e,sum = 1)
h) Create new classifier
i) Predictions: Weighted average of individual classifier prediction using stage value
```

### Gradient Boosting
<img width="739" alt="image" src="https://github.com/user-attachments/assets/d261502c-9cde-41e7-b43a-174b66232191" />
<img width="739" alt="image" src="https://github.com/user-attachments/assets/b54c382c-467f-4c15-b9ce-bc5b5cbffe35" />

#### Pros of Boosting Algorithms:
* High Accuracy: Boosting algorithms often achieve state-of-the-art accuracy and generally outperform individual weak learners significantly. They are very effective at reducing bias.
* Handles Complex Data: They can effectively model complex non-linear relationships in the data.
* Feature Importance: Most boosting implementations provide insights into feature importance, helping understand which features contribute most to the predictions.
* Robust to Overfitting (with regularization): While a risk, modern boosting algorithms like XGBoost and LightGBM incorporate regularization techniques (L1/L2 penalties, learning rate, tree pruning) to mitigate overfitting.
* Handles Missing Data (some variants): Algorithms like XGBoost have built-in mechanisms to handle missing values, reducing the need for extensive preprocessing.

#### Cons of Boosting Algorithms:
* Prone to Overfitting (if not tuned properly): Without proper hyperparameter tuning (especially learning rate, number of estimators, and tree depth), boosting can easily overfit noisy data, particularly if the weak learners are too complex or there are too many iterations.
* Computationally Expensive: Due to their sequential nature, boosting algorithms can be slower to train compared to parallel methods like Bagging (e.g., Random Forests), especially for very large datasets.
* Sensitive to Outliers: Because boosting algorithms focus on misclassified samples by giving them higher weights, they can be sensitive to noisy data and outliers, which might be treated as "hard" cases and lead to overfitting on noise.
* Less Interpretable: Compared to a single decision tree or linear model, the ensemble nature of boosting models makes them harder to interpret and explain the individual decision-making process.
* Sequential Training: The sequential nature limits parallelization during the training phase, although some modern implementations (like XGBoost) achieve parallelization at other levels (e.g., finding the best split points).  

### XGBoost
<img width="740" alt="image" src="https://github.com/user-attachments/assets/190f710f-bd64-4d83-b1fa-4ff0c92503c6" />
<img width="740" alt="image" src="https://github.com/user-attachments/assets/924a2088-981d-493a-ac65-1cb17492da2b" />
<img width="740" alt="image" src="https://github.com/user-attachments/assets/bb1dd15a-a683-47d7-9ec6-2f8aff5593d8" />
<img width="740" alt="image" src="https://github.com/user-attachments/assets/6b570359-dc3c-4b19-825c-7e1083aaf2fa" />
<img width="740" alt="image" src="https://github.com/user-attachments/assets/6940527e-36b8-4f32-a62d-3fccd0ac85e5" />

### LightGBM
LightGBM, developed by Microsoft, is designed for speed and efficiency, particularly with large datasets. It introduces several novel techniques to achieve faster training times and lower memory consumption while maintaining high accuracy.
<img width="740" alt="image" src="https://github.com/user-attachments/assets/96c758cf-4ad2-452f-8e5d-17e186e86f08" />
<img width="740" alt="image" src="https://github.com/user-attachments/assets/0eb976cc-664b-43d6-a159-1d1946c87f83" />
<img width="740" alt="image" src="https://github.com/user-attachments/assets/bcd44152-731d-4901-9b51-3dcf560465c4" />

### CatBoost
CatBoost, developed by Yandex, stands out for its robust handling of categorical features and its approach to reducing overfitting. Its name comes from "Categorical Features" and "Boosting."
<img width="740" alt="image" src="https://github.com/user-attachments/assets/19521cd7-f6b6-41af-ac52-dc76055cebf0" />
<img width="740" alt="image" src="https://github.com/user-attachments/assets/1c0d47a6-aecf-4709-8bce-4094d94929a2" />
<img width="751" alt="image" src="https://github.com/user-attachments/assets/ebe41349-62cd-4ef8-b9c3-1f3eb96f2b02" />

<img width="751" alt="image" src="https://github.com/user-attachments/assets/1a980efb-fc3e-4fc4-a8bb-9dcfc9f6dd70" />
General Guidelines:

LightGBM: Choose when you prioritize speed and efficiency, especially with very large datasets and sufficient memory. Good for tasks where quick iteration is important.
XGBoost: A robust all-rounder. Choose when you need high performance and have a mix of numerical and categorical features (after preprocessing). It's very stable and widely used.
CatBoost: Ideal when your dataset has many categorical features, and you want to reduce preprocessing efforts and mitigate overfitting related to categorical variable encoding. It's also a good choice if you prefer strong default parameters.









