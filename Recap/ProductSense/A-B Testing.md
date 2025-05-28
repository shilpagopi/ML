# A/B Testing
#### Template: Answering A/B Testing Questions
"A/B testing is a powerful method for data-driven decision-making, allowing us to compare two versions of a product, feature, or experience to see which performs better on a specific metric. My approach to A/B testing involves several key stages to ensure robust and actionable results."

##### Phase 1: Planning and Setup
Understand the Business Problem & Objective:

Question: "What problem are we trying to solve?" or "What opportunity are we trying to capture?"
Example: "Low sign-up rate on the landing page," or "Users aren't engaging with a new feature."
This drives the entire test.

##### Research & Hypothesis Formulation:

Research: Analyze existing data (e.g., analytics, heatmaps), conduct user research (surveys, interviews) to understand why the problem exists.
Hypothesis: Based on research, formulate a clear, testable hypothesis.
Structure: "If we change [specific element], then [primary metric] will [direction of change: increase/decrease] because [reason/user behavior insight]."
Example: "If we change the CTA button color to orange, then the click-through rate (CTR) will increase because it will stand out more and attract more attention."
Define Control (A) & Variant (B):

Control (A): The existing version (baseline).
Variant (B): The modified version with one single change based on the hypothesis. (Emphasize the 'one change' rule to isolate impact; mention Multivariate Testing for multiple changes if relevant to the conversation, but clarify A/B focuses on one).

##### Metric Selection:

Primary Metric: The single most important metric directly tied to the hypothesis and business objective. This is what you'll use for statistical significance.
Examples: Click-Through Rate (CTR), Conversion Rate, Average Revenue Per User (ARPU), Time on Page, Retention Rate.
Secondary Metrics: Other metrics to monitor for unintended positive or negative consequences.
Examples: Bounce Rate, Page Load Time, Error Rate.

##### Determine Sample Size and Duration:
Key Inputs for Sample Size Calculation
To calculate the required sample size, you need to specify four main parameters. These are often referred to as the "four pillars" of power analysis:

* Baseline Conversion Rate (or Mean): This is the current performance of your control group (version A). A very low baseline rate (e.g., 0.1%) requires a much larger sample size to detect a given absolute change than a higher baseline (e.g., 10%). For continuous metrics (e.g., ARPU, Time on Page): The current average value and its variability (standard deviation).

* Minimum Detectable Effect (MDE) - (δ):
This is the smallest difference between the control and variant that you consider practically significant for your business. It's the minimum lift you'd be interested in detecting.
Absolute vs. Relative:
Absolute: If your baseline conversion is 10%, and you want to detect a change to 10.5%, the absolute MDE is 0.5 percentage points.
Relative: If your baseline conversion is 10%, and you want to detect a 5% relative increase, then the MDE is 0.5 percentage points (10% * 0.05 = 0.5%). Relative MDEs are often more intuitive for business stakeholders.

Why it's important: You don't want to run a test for an incredibly small, statistically significant difference that has no real business impact. The smaller the MDE you want to detect, the larger your required sample size will be.
How to get it: This is a business decision. What is the smallest improvement that justifies the effort of making the change? What's the opportunity cost?

* Significance Level (α) - (Type I Error Rate):
This is the probability of making a Type I error (False Positive): incorrectly rejecting the null hypothesis when it is actually true (i.e., concluding there's a difference when there isn't one). Commonly set at 0.05 (5%). This means you're willing to accept a 5% chance of rolling out a change that has no real impact.
The lower α is, the more evidence you need to reject the null hypothesis, and thus the larger the required sample size.

* Statistical Power (1 - β) - (Type II Error Rate): This is the probability of correctly detecting a real effect.
Commonly set at 0.80 (80%) or 0.85 (85%). A power of 80% means there's a 20% chance of making a Type II error (False Negative): failing to detect a real difference when one truly exists. The higher the power you want, the larger your required sample size will be.

How to Compute Sample Size
You typically use online A/B test sample size calculators or statistical functions in programming languages (like Python's statsmodels.stats.power or R's pwr package).
Example using a common A/B test calculator (e.g., Optimizely, Evan Miller, or VWO's calculators):

Let's say your metric is Conversion Rate:

For Baseline Conversion Rate (Control): 10%, Minimum Detectable Effect (MDE): 1%, Significance Level (α): 0.05, Statistical Power (1-β): 0.80; yields a sample size **(per group)** of around 7,800-8,000 users. 

Duration: Run the test until the required sample size for both groups is reached AND it covers full weekly cycles (e.g., at least 7 days, or multiples of 7, to account for day-of-week variations). Consider seasonality, novelty effect, External Factors:

** Why Sample Size and Duration are Crucial ?**
* Avoid False Positives (Type I Error) - "Peeking Problem": If you stop a test early simply because you see a "winner" (p-value ≤α), you significantly increase your chance of making a Type I error. Random fluctuations in data can temporarily show a significant difference that isn't real.
* Avoid False Negatives (Type II Error) - "Underpowered Test": If your sample size is too small, you might not have enough power to detect a real, meaningful difference, even if one exists. This means you could miss out on a valuable improvement.
* Resource Optimization: Running a test for too long (over-sampling) wastes resources (time, traffic allocation) that could be used for other experiments.
Validity of Statistical Tests: Many statistical tests rely on assumptions that are more likely to be met with larger sample sizes (e.g., the Central Limit Theorem helps ensure the sampling distribution of the mean or proportion is approximately normal).

##### Phase 2: Execution
Randomization:

Users must be randomly assigned to either group A or group B. This ensures the groups are comparable and minimizes bias.
Mention using A/B testing tools (e.g., Optimizely, VWO, internal tools) for proper traffic splitting.
Implementation & QA:
Implement the changes carefully.
Thoroughly test both versions across different devices/browsers to ensure functionality and correct display.
Monitoring:

Monitor the experiment for technical issues, but resist the urge to analyze preliminary results before the predetermined duration/sample size is met.

##### Phase 3: Analysis and Decision
Collect Data: Gather the observed data for both groups based on your chosen metrics.

Choose the Right Statistical Test: This depends on the type of your primary metric.

##### A. For Proportions/Rates (e.g., Conversion Rate, Click-Through Rate, Signup Rate):
Description: These are binary outcomes (success/failure).
Data Structure: 2×2 Contingency Table (Observed Frequencies).
Algorithms/Tests:
Chi-Squared Test: Most common. Compares observed vs. expected frequencies. Robust for larger samples.
Z-test for Proportions: Mathematically equivalent to Chi-Squared for 2×2 tables; often used for direct comparison of proportions.
Fisher's Exact Test: Use if any expected cell counts in the contingency table are less than 5 (for small sample sizes).

##### B. For Continuous Values (e.g., Average Revenue Per User (ARPU), Average Order Value, Time on Page, Number of Items in Cart):

Description: Metrics that can take on any value within a range.
Data Structure: Raw data points for each user in each group.
Algorithms/Tests:
Two-Sample t-test (Welch's t-test): Recommended. Compares the means of two independent groups assuming unequal variances. It's more robust and generally preferred.
Two-Sample t-test (Pooled): Assumes equal variances between groups. Less robust than Welch's if variances are actually different. (Might mention F-test/Levene's test to check for equal variances, but emphasize Welch's generally safe default).

##### C. For Count Data (e.g., Number of daily active users, Number of likes):

Description: Non-negative integer counts.
Algorithms/Tests: Often transformed to continuous (e.g., ARPU) or proportions (e.g., new vs. returning users). If truly count data (e.g., number of events per user), Poisson regression or negative binomial regression might be considered, but for general A/B tests, often approximated by t-test if sufficiently large and not heavily skewed. (Mention these are more advanced but not typical for basic A/B test analysis in interviews).

##### Compute Test Statistic and P-value:

Perform the chosen statistical test.
P-value: This is the probability of observing our test results (or more extreme results) if the null hypothesis were true.
Make a Decision (based on P-value):

Compare p-value to α (e.g., 0.05):
If p-value ≤α: Reject the Null Hypothesis: The difference is statistically significant. We have sufficient evidence to say that Variant B performed differently (better or worse) than Control A.
If p-value >α: Fail to Reject the Null Hypothesis:The difference is not statistically significant. We do not have enough evidence to claim a real difference; the observed difference could be due to random chance.

##### Calculate and Interpret Confidence Intervals:

Purpose: Provides a range of plausible values for the true difference between the two groups.
Interpretation:
If the confidence interval does NOT include zero, it reinforces statistical significance and indicates the likely range and direction of the true effect.
If the confidence interval DOES include zero, it means zero difference is a plausible outcome, consistent with non-significance.
Assess Practical Significance & Effect Size:

##### Practical Significance: Is the observed difference (even if statistically significant) meaningful from a business perspective? A tiny lift might not be worth the development cost.
Effect Size (e.g., Cohen's d for means, or simply the percentage difference for proportions): Quantifies the magnitude of the difference. A p-value tells you if a difference exists; effect size tells you how big that difference is.

##### Phase 4: Post-Test Actions
Implement or Iterate:
Winner: If the variant is a significant and practically meaningful winner, roll it out to all users.
No Winner / Loser: If there's no significant difference or the control performed better, revert to the control. The test still provides valuable learning.
Next Steps: Formulate new hypotheses based on learnings.
Document Learnings:

Keep a record of all tests, hypotheses, results, and conclusions to build institutional knowledge and avoid repeating past experiments.

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

## For 2 samples with continuous values:
<img width="734" alt="image" src="https://github.com/user-attachments/assets/a9bc6885-17ad-44ce-b484-831f8fe1ee3a" />

<img width="720" alt="image" src="https://github.com/user-attachments/assets/350adb39-0a7c-49ac-8604-105ef6c42122" />

<img width="734" alt="image" src="https://github.com/user-attachments/assets/7e68a4fe-4e3f-46ac-90a9-63d290de7cae" />

<img width="727" alt="image" src="https://github.com/user-attachments/assets/192bbbd8-ea63-40f5-8989-9d71ae17251a" />

## For 2 samples with categorical values:
<img width="727" alt="image" src="https://github.com/user-attachments/assets/6434c2bd-ecfc-4588-b665-d162eded78d5" />

<img width="736" alt="image" src="https://github.com/user-attachments/assets/56a2f0e8-12a6-432b-a3de-0adc52bb9374" />

<img width="725" alt="image" src="https://github.com/user-attachments/assets/9caff218-f911-4f79-ad60-ce2a9a273248" />







