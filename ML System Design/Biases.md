# Biases
<img width="735" alt="image" src="https://github.com/user-attachments/assets/6b263d82-75d0-4848-99bd-e860f5c7ed41" />
## Mitigation
* shuffle (top) results uniformly at random (RandN or RandTopN). Any difference in customer engagement can be cleanly attributed to position bias. The downside is that this adversely impacts the customer experience and is usually too costly or out of the question.
* search result randomization (same as above) over a small percentage of production traffic
* exploit the inherent randomness: if production rankers are being updated frequencty or multiple client device forms are available, compare historic positions vs user engagement.
* add a bit of randomness into item positions. For example, FairPairs swaps items at positions k and k+1 while RandPair swaps items at positions 1 and k.
* add a random value to item positions and re-sort
* Boltzmann exploration where we (i) normalize/softmax the raw scores into probabilities and then (ii) sample the recommendations (based on these probabilities) as we populate our widget starting from position 1. This gives each recommended item a chance to gain a higher position weighted by recommendation probability (which we can also use in counterfactual evaluation). Unlike RandTopN, these approaches anchor each item to its original position before adding randomness, possibly reducing the negative customer impact.

* Resources:
* Other bias mitigation methods: https://dl.acm.org/doi/pdf/10.1145/3159652.3159732: infer position bias to train models optimized on inverse propensity weighted precision.
