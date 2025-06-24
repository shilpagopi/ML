# Optimizers
## Gradient Descent: 
<img width="337" alt="image" src="https://github.com/user-attachments/assets/1a2f6b5e-5c8b-49fb-9893-f1b76b611ba4" />  

### Batch Gradient Descent (BGD)
How it works: Calculates the gradient of the loss function using all training examples in each iteration.  
Pros: Guaranteed to converge to the global minimum for convex loss functions and a local minimum for non-convex functions.  
Cons: Computationally very expensive , Can get stuck in local minima more easily in non-convex landscapes.  

### Stochastic Gradient Descent (SGD)
How it works: Calculates the gradient and updates parameters using one random training example at each iteration.
Pros: Much faster per iteration compared to BGD. The "noisy" updates (due to using single examples) can help escape shallow local minima and saddle points.
Cons: Noisy updates, causing the loss to fluctuate significantly (oscillations) rather than smoothly converging.
Can make slow progress towards the minimum if the gradients are consistently pointing in slightly different directions. Sensitive to the choice of learning rate.
      
### Mini-Batch Gradient Descent (MBGD)
How it works: A compromise between BGD and SGD. It calculates the gradient and updates parameters using a small random subset (mini-batch) of the training data in each iteration.
Pros: Balances the speed of SGD with the stability of BGD. More computationally efficient than BGD. Updates are more stable than SGD due to averaging gradients over a batch.
Most commonly used variant in deep learning.
Cons: Still requires careful tuning of the learning rate.

## Optimizers with Adaptive Learning Rates
### Momentum
How it works: Introduces a "momentum" term that accelerates optimization in the correct direction and dampens oscillations. It accumulates an exponentially decaying average of past gradients and uses this average to update the parameters.
<img width="490" alt="image" src="https://github.com/user-attachments/assets/6b34ef8d-00f7-435b-9803-15468b9bc495" />

Pros:
* Helps overcome local minima and saddle points.
* Speeds up convergence, especially in directions with consistent gradients.
* Reduces oscillations.
Cons: Still requires a manually set learning rate.

### Adagrad (Adaptive Gradient Algorithm)
How it works: Adapts the learning rate for each parameter individually based on the sum of the squares of its past gradients. Parameters with large past gradients get a smaller learning rate, while those with small past gradients get a larger learning rate.
<img width="709" alt="image" src="https://github.com/user-attachments/assets/80199d54-3422-4e68-aa9d-46f133b88293" />

Pros:
Automatically adapts learning rates for each parameter.
Particularly effective for sparse data, where some features are updated infrequently (e.g., in NLP tasks).
Cons: The accumulated sum of squared gradients in the denominator can grow indefinitely, causing the learning rate to eventually become extremely small and stop learning prematurely.

### RMSprop (Root Mean Square Propagation)
How it works: Addresses Adagrad's vanishing learning rate problem by using an exponentially decaying average of squared gradients instead of a cumulative sum. 
This prevents the learning rate from diminishing too rapidly.
<img width="471" alt="image" src="https://github.com/user-attachments/assets/7b59bce7-fd7c-48da-bc48-b91fa6255e81" />

Pros:
Effectively solves Adagrad's diminishing learning rate issue.
Well-suited for non-stationary objectives and recurrent neural networks (RNNs).
Cons: Still requires a manually set global learning rate.

### Adam (Adaptive Moment Estimation)
How it works: Widely considered one of the best general-purpose optimizers. It combines the best aspects of Momentum and RMSprop:
It uses an exponentially decaying average of past gradients (like Momentum - first moment).
It uses an exponentially decaying average of past squared gradients (like RMSprop - second moment).
It includes bias correction terms for both moments, especially important in the initial steps of training.

<img width="738" alt="image" src="https://github.com/user-attachments/assets/0aafeb52-21fa-4bec-9e0a-bdbb8a6d9923" />

Pros:
Fast convergence.
Adapts learning rates for each parameter.
Robust to hyperparameter choices.
Works well on a wide variety of deep learning tasks.
Cons: Can sometimes generalize slightly worse than SGD with momentum in specific scenarios, but this is often debated and depends on the specific problem and hyperparameter tuning.

### How to Choose: 
Start with Adam: It's a great default choice for most deep learning problems due to its adaptive learning rates and robustness.
For highly optimized or fine-tuned models: Consider SGD with Momentum or Nesterov Momentum. Sometimes, with careful learning rate scheduling, these can achieve slightly better generalization than adaptive methods like Adam.
For sparse data: Adagrad can be effective, though Adam or RMSprop usually handle it well too.
Experiment...
