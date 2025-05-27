# A/B Testing
##### How would you design an A/B test to determine if a new website button color increases click-through rate (CTR)? What metrics would you track, and what potential pitfalls should you consider?

Answer:
Design:
Define Hypothesis:
Null Hypothesis (H_0): The new button color has no significant impact on CTR.
Alternative Hypothesis (H_1): The new button color significantly increases CTR 

Define Metric: The primary metric is Click-Through Rate (CTR) = (Clicks / Impressions).

Randomization: Randomly assign users to two groups:
Control Group (A): Sees the original button color.
Treatment Group (B): Sees the new button color. Ensure random assignment to minimize confounding variables.

Sample Size: Calculate the required sample size using power analysis to detect a statistically significant difference (if one exists) with a desired confidence level and statistical power. Factors include baseline CTR, desired minimum detectable effect, significance level (α), and power (1−β).
Duration: Run the test for a sufficient duration to capture daily/weekly variations and accumulate enough data (e.g., 1-2 full business cycles, often weeks).

Metrics to Track:
Primary: Click-Through Rate (CTR) for the button.
Secondary/Guardrail Metrics: Overall conversion rate, time on page, bounce rate, revenue per user, to ensure the new button isn't negatively impacting other important aspects.

Potential Pitfalls:
Novelty Effect/Seasonality: Initial enthusiasm for a new feature might skew results; running the test long enough helps mitigate this.
Network Effects: Users influencing each other (e.g., if one user in a group sees the new feature and tells others).
Sampling Bias: Ensuring true randomness in user assignment (e.g., not based on device, location, or time of day).
Multiple Testing: If running many A/B tests simultaneously, the probability of false positives increases. Adjust significance levels (e.g., Bonferroni correction).
External Factors: Holidays, marketing campaigns, or news events can influence results.
Instrumentation Errors: Incorrect tracking of clicks or impressions.
Switchback/Interference: If the change affects different segments of users who interact with each other, it can be tricky.

##### Steps after A/B Testing
* Validate the Experiment Setup: Double-check that the A/B test was set up correctly (randomization, tracking, no biases, etc.) to ensure the results are reliable.
* Analyze Secondary Metrics: Review all other relevant metrics (engagement, retention, revenue per user, time on page, customer support tickets, etc.) to ensure the improvement in conversion rate didn't come at the cost of other important aspects.
* Segment Analysis: Investigate if the improvement is consistent across all user segments (e.g., new vs. old users, different demographics, different devices). There might be specific segments where the new product performs exceptionally well or poorly.
* Qualitative Feedback: Gather qualitative data (user interviews, surveys, heatmaps, session recordings) to understand why Product B performed better. This provides valuable insights beyond just the numbers.
* Rollout Strategy: Based on validation and further analysis, propose a rollout strategy. This could be a full rollout, a phased rollout, or even further iteration if unexpected issues arise.
* Learning and Iteration: Document the learnings from this experiment. This helps inform future product development and experimentation efforts.

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
