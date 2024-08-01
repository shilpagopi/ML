# Loss Functions

## Regression Loss Functions

### 1. MSE
<img src="https://miro.medium.com/max/600/1*3wB5otkgKEiv9X6Gdd0r2Q@2x.png" alt="drawing" width="250" height="75"/>

### 2. Squared Error Loss / L2 Loss 
<img src="https://cdn.analyticsvidhya.com/wp-content/uploads/2019/08/mse.jpg.jpg" width="250" height="75"/>

### 3. Absolute Error Loss
<img src="https://cdn.analyticsvidhya.com/wp-content/uploads/2019/08/mae.jpg.jpg" width="250" height="75"/>

* The MAE (Mean Absolute Error) cost is more robust to outliers as compared to MSE.
* However, handling the absolute or modulus operator in mathematical equations is not easy.

### 4. Huber Loss
<img src="https://cdn.analyticsvidhya.com/wp-content/uploads/2019/08/huber.jpg.jpg" width="500" height="150"/>

### 5. Regression Metrics
<img src="https://github.com/shilpagopi/ML/blob/master/Recap/img/regression-metrics.JPG" width="800" height="500"/>

## Classification Loss Functions
### 1. Cross Entropy
<img src="https://leakyreluhome.files.wordpress.com/2020/01/ce_loss.png" width="300" height="100"/>

### 2. Hinge Loss
<img src="https://cdn.analyticsvidhya.com/wp-content/uploads/2019/08/hinge.jpg.jpg" width="300" height="75"/>

* Hinge Loss not only penalizes the wrong predictions but also the right predictions that are not confident.
* Use class labels -1 and 1

### 3. Confusion Metrics
<img src="https://github.com/shilpagopi/ML/blob/master/Recap/img/classification-metrics.JPG" width="800" height="700"/>

* RoC: detection vs false alarm
* Type I Error = false positive, Type II error = false negative

* False Positive Rate, FPR = 1 - TNR = FP/TN+FP
* False Negative Rate, FNR = 1- TPR = FN/TP+FN

## Gen-AI Loss Functions
### 1. Perplexity: 
* Measure of uncertainty or surprise: It measures a model's ability to predict the next word in a sequence.
* It quantifies the model's "surprise" when encountering new data — lower surprise indicates better prediction accuracy
* Perpelxity = inverse of the geometric mean of the probability distribution over all possible outputs for a given input.
* Perplexity = 2 ^ Entropy
* Eg. if dog and cat can be predicted with [0.5, 0.5] prob, perplexity = 1/(sqrt(0.5*0.5) = 1.4
* For a very confident/reliable model, perplexity is 1.
* Perplexity of a fair k-sided dice is k. (Note: for geometric mean of n numbers, take nth root of product of those numbers.)
* Limitations: Ignores the natural word frequencies, overlooks word order significance
* Link for derivation: https://www.cs.bu.edu/fac/snyder/cs505/PerplexityPosts.pdf
