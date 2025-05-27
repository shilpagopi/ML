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

##### Given two samples for A/B testing, how to conclude if the change is effective?
1. Revisit Your Hypotheses
Before diving into calculations, confirm your hypotheses:

Null Hypothesis: There is no statistically significant difference between the control (A) and the variant (B) in terms of your primary metric. Any observed difference is due to random chance.MetricA=MetricB

Alternative Hypothesis: There is a statistically significant difference between the control (A) and the variant (B).
Two-tailed: use not equal to
One-tailed: use one metric is < or > than the other.

2. Choose Your Statistical Test Based on Metric Type
###### For Proportions/Rates (e.g., Conversion Rate, Click-Through Rate):
You're comparing two proportions. The most common tests are:
Chi-Squared Test: Suitable for comparing observed frequencies in categorical data.
Z-test for Proportions: Often used for large sample sizes, and simpler than chi-squared for two groups. In many practical scenarios, these tests will yield similar results.
###### For Continuous Averages (e.g., Average Revenue Per User (ARPU), Time on Page):
You're comparing two means. The most common test is:
Two-Sample t-test: Used when the population standard deviation is unknown (which is almost always the case).
Independent t-test: For independent groups (standard A/B test).
Paired t-test: If the same users are exposed to both A and B (less common in A/B, more in before/after studies).

3. Calculate the Test Statistic
Let's illustrate with the most common scenario: comparing conversion rates (proportions).
<img width="733" alt="image" src="https://github.com/user-attachments/assets/781fb9d3-7244-44d8-a202-64f0eb62f759" />

4. Determine the P-value
The p-value is the probability of observing a test statistic as extreme as, or more extreme than, the one you calculated, assuming the null hypothesis is true.

Look up the p-value: Using your calculated Z-statistic (or t-statistic), consult a standard normal distribution table (for Z-test) or a t-distribution table (for t-test), or more practically, use statistical software.
Two-tailed vs. One-tailed:
For a two-tailed test: the p-value is the probability of getting a Z-score greater than ∣Z_calculated∣ or less than −∣Z calculated∣. You typically multiply the one-tailed p-value by 2.
For a one-tailed test, the p-value is the probability of getting a Z-score greater than Z calculated (if the hypothesis is in positive direction?)
​
 .
5. Compare P-value to Significance Level (α)
Significance Level (α): This was set before the test, commonly 0.05 (5%). It represents the **maximum acceptable probability of making a Type I error (false positive)**.
Decision Rule:
If p-value ≤α: Reject the null hypothesis 
This means the observed difference is statistically significant. You have enough evidence to conclude that the variant (B) does have a different effect than the control (A).
If p-value >α: Fail to reject the null hypothesis 
This means the observed difference is not statistically significant. You do not have enough evidence to conclude that the variant (B) is different from the control (A). The difference you saw could easily be due to random chance.

6. Calculate Confidence Intervals
While the p-value tells you if a difference exists, the confidence interval tells you the magnitude and direction of that difference, and the range of plausible values for the true difference.
<img width="721" alt="image" src="https://github.com/user-attachments/assets/3c62fb41-479b-437d-88e9-12aaf69ac93e" />


Confidence Interval: Answers the question: "What is the range of plausible values for the true effect?"
Doesn't include zero: Statistically significant effect, direction is clear.
Includes zero: Not statistically significant, zero difference is a plausible outcome.
Practical Significance: Even if a result is statistically significant, is the magnitude of the change large enough to be meaningful from a business perspective? A 0.01% increase in conversion rate might be statistically significant with huge sample sizes, but it might not be worth the development effort.
Sample Size and Duration: Ensure your test ran long enough and collected sufficient data as determined by your initial power analysis. Stopping early invalidates results.
Assumptions: Be aware of the assumptions of the statistical tests you use (e.g., independence of observations, approximate normality for t-tests with smaller samples).

