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

#### Tips: 
* Identify type of distribution (Eg. if geometric with each trial independent, find prob, p of success and invert it. E(X) = 1/p. If geometric without replacement, then say ans = E. If the sample is exhaustive, try to dsitribute equidistantly.. eg. #draws till ace in a deck of 52 cards)
  
#### Questions
* What is the probability that a seven-game series goes to 7 games?
* What is the probability that two random chords in a circle will intersect? 1/3
* What is the expected number of rolls needed to see all 6 sides of a fair die? (1+6/5+6/4+6/3+6/2+6/1) = 14.7
          The number of rolls needed to get all six numbers is the sum of number of rolls to get each number. That is, it is the number of rolls to get the first unique number plus the number of rolls to get the second number, plus the number of rolls to get the third number, et cetera.
        
        To get the first number, there are six possible outcomes, of which all six qualify. The expected number of rolls to get the first number is 6/6=1.
        
        To get the second number, there are six possible outcomes, of which five qualify; the number initially rolled does not qualify. The expected number of rolls to get the second unique number is 6/5.
        
        How do we know it takes 6/5 rolls to get the second number? Define p so that p = the expected number of rolls.
        
        If we roll and duplicate the first number, then we need to roll again. The expected number of rolls to get the second number when we don't get it on the first try = 1+p.
        
        If we roll and don't duplicate the first number, we are done. The expected number of rolls is 1.
        
        The overall expected number of rolls is the probability of duplicating the first number times the expected number of rolls when we duplicate the first number plus the probability of not duplicating the first number times the expected number of rolls when we don't duplicate the first number.
        
        Or, p = (1/6)*(1+p) + (5/6)*1
        
        p = 1/6 + p/6 + 5/6
        
        p - p/6 = 1/6 + 5/6
        
        p * 5/6 = 1
        
        p = 6/5
        
        Similarly, the number of rolls for the third number is,
        
        p = (2/6)*(1+p) + (4/6)*1
        
        p - (2/6)*p = (2/6) + (4/6)
        
        p = 6/4
        
        The overall number of rolls is,
        
        6/6+6/5+6/4+6/3+6/2+6/1
        
        = 1+1.2+1.5+2+3+6
        
        = 14.7
* Say you roll three dice, one by one. What is the probability that you obtain 3 numbers in a strictly increasing order? 5/54
* What is the expected number of coin flips needed to get two consecutive heads? 6
  <img width="741" alt="image" src="https://github.com/user-attachments/assets/d11dd209-df09-4b65-a899-a72f039e4c6c" />
* What is the probability that none of the ants collide, if k ants sit on k corners of an equilateral polygon and each ant randomly picks a direction and starts moving along the edge ? Ans. 1/(2^(k-1))
* How many cards would you expect to draw from a standard deck before seeing the first ace? 10.6
* The expected number of cards to draw until the first special card is observed is given by the formula: E= (N+1)/(K+1), where N=52,K=number of special cards.
  Formula basis: Think of aces being evenly spread out. 4*10.6+(10.6-1)=52
* A and B are playing a game where A has n+1 coins, B has n coins, and they each flip all of their coins. What is the probability that A will have more heads than B? 0.5 (intuitive answer)
* Say you are given an unfair coin, with an unknown bias towards heads or tails. How can you generate fair odds using this coin? use "HT" to denote head and "TH" to denote tail coz prob = p(1-p), equal for both cases. Ignore "HH" and "TT"  
​* A fair die is rolled n times. What is the probability that the largest number rolled is r, for each r in 1..6? <img width="164" alt="image" src="https://github.com/user-attachments/assets/4b31b4f8-e9ae-4710-b3c0-a49704ec82fb" />
* There are two groups of n users, A and B, and each user in A is friends with those in B and vice versa. Each user in A will randomly choose a user in B as their best friend and each user in B will randomly choose a user in A as their best friend. If two people have chosen each other, they are mutual best friends. What is the probability that there will be no mutual best friendships? [(n−1)/n]]^(2n)



