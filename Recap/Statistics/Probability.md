# Probability
* Probability mass function (PMF) is a function that gives the probability that a discrete random variable is exactly equal to some value.
* Probability density function (PDF) is associated with continuous random variables. A PDF must be integrated over an interval to yield a probability
* Thinking of probability as mass because similar to conervation of physical mass, the total probability for all hypothetical outcomes is 1.

#### Probability Distribution
* Bernoulli distribution: models sample sapce with 2 possible outcomes. P(x) = p or 1-p. Eg: Coin toss. 
* Binomial distribtuion: models the number of successes when someone draws n times with replacement. P(n) = C(n,k) (p^k)((1-p)^(n-k)). Eg: 1 head in 6 trials.
* Geometric dsitribution: models  number of trials needed to get one success. Eg. Toss until head
  

#### Expected value and Variance:
* Expected value = Summation over all i outcomes of (P(xi)* x(i))
* If delta = (X-u)^2, Variance = E(delta) = Summation over all i outcomes of (P(xi)* deltai)

#### The probability of Team A winning exactly k games in n games is given by:
* P(X=k)=(NCk)(p^k)(1-p)^(n−k)

#### Coupon Collector's Problem with n distinct items:
E=n*summation over 1 to n(1/i) 
Expected no. of buys to collect all n different coupons.

#### Questions
* What is the probability that a seven-game series goes to 7 games?
* What is the probability that two random chords in a circle will intersect? 1/3
* What is the expected number of rolls needed to see all 6 sides of a fair die? (1+6/5+6/4+6/3+6/2+6/1) = 14.7
* Say you roll three dice, one by one. What is the probability that you obtain 3 numbers in a strictly increasing order? 5/54

