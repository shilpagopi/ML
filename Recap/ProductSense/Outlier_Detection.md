##### You have a stream of user actions, and you want to detect unusual activity in real-time. How would you approach this problem using statistical methods?

Answer: This is an anomaly detection problem in a streaming context.
Define "Normal" Activity: This is the most crucial step. What constitutes normal user behavior? This could be based on:
Frequency: Number of actions per minute/hour (e.g., login attempts, clicks, purchases).
Sequence: Typical order of actions.
Volume: Data transferred, number of items added to cart.
Time of Day/Week: Usage patterns vary.
User Profiles: Different user types might have different normal behaviors.
Feature Engineering: Extract relevant features from the streaming data. Examples:
Rate of events (e.g., moving average of logins per second).
Time since last similar event.
Deviation from historical average for a given user/group.
Entropy of visited pages.
Choose a Statistical Model/Method:
Statistical Process Control (SPC) Charts: Shewhart charts (X-bar, R-charts) can track metrics over time and flag deviations beyond control limits. Useful for detecting shifts in mean or variance.
Z-score/Thresholding: For simple metrics, calculate a rolling mean and standard deviation. An activity is anomalous if its value deviates by more than a certain number of standard deviations (e.g., 3-sigma rule).
Exponentially Weighted Moving Average (EWMA): Gives more weight to recent observations, making it suitable for streams where patterns might change over time.
Isolation Forest: An ensemble method that "isolates" anomalies by randomly partitioning data. Anomalies require fewer partitions. Good for high-dimensional data.
One-Class SVM: Learns a boundary around the "normal" data points. Anything outside the boundary is considered an anomaly.
Time Series Models (ARIMA, Prophet): If there's strong seasonality or trend, forecast future values and flag deviations from predictions.
Probabilistic Models (e.g., Gaussian Mixture Models): Model the distribution of normal data and assign low probability to anomalous points.
Bayesian Online Learning: Continuously updates probability distributions as new data arrives.
Online Learning/Adaptation: As the stream evolves, the definition of "normal" might change. The model should adapt.
Use techniques like decaying averages or periodic retraining to adjust to new patterns.
Concept drift detection: Monitor for changes in the underlying data distribution that might require model updates.
Alerting and Action: Define thresholds for what constitutes an anomaly that warrants an alert. This could be a fixed threshold, adaptive thresholds, or based on the severity of the anomaly.
Feedback Loop: Human analysts can review flagged anomalies and provide feedback to improve the model. This is crucial for reducing false positives and false negatives over time.
