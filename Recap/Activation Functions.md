# Activation Functions

| Name | Formula | Derivative | Remarks | Vanishing Gradient Exists | Activation Blowup Exists |
|--|--|--|--|--|--|
| Linear | m x z | Constant m | Used for predicting continuous target variables. Else, rarely used in neural networks. If there is an error in prediction, the changes made by back propagation is constant and not depending on the change in input delta(x) ! constant derivatinve can increase vanishing gradient problems.| Y | Y |
| Sigmoid (Logistics)| | g(z) (1-g(z))| Range: 0-1, non-linear, continuously differentiable, monotonic, and has a fixed output range. Not zero centered - makes optimization harder.| YES | NO (values bounded) |
|Tanh|(e^z-e^(-z))/(e^z+e^(-z))| 1 - g(z)^2|Range:-1 to 1, Non-linear, zero-centered, more preferred to sigmoid (?), steeper gradient than sigmoid,  fixed output range |YES|NO (values bounded)|
| Exponential Linear Unit (ELU) | Similar to RELU, but for negative z values, alpha*(exp(z)-1) | 1 (z>0), alpha x exp(z) (z<0) |--| Y | no, due to neg values |
| RELU | max (0,z) | 1 and 0 | derivative =1 allows for faster convergence as they don't vanish. sparsity also helps in the same, and acts as a regularisation by turning some neurons off. <br> Less computationally expensive than tanh and sigmoid because it involves simpler mathematical operations. Dying ReLu problem: if input neg, value becomes 0, gradient also 0, neuron does.| NO for z>0, but ~dying Relu when z<0 | Y |
| Leaky RELU| (alpha x z) when z<0  | 1 when z>0, else alpha | usu, alpha = 0.01(constant). solved dying Relu problem. | NO | Y |
| Parametric RELU ||| same as leaky Relu, but alpha is a learnable parameter learnt through back propagation. df/dalpha = 0 (z>0),z (z<0) |NO|YES
| Softmax|s(z)= e^z/sum(e^z) | derivative: i==j s(1-s), else: -s(zi).s(zj) exponential scaling amplifies the differences between input values, leading to a winner-takes-it-all effect.||
* Vanishing gradients happens when derivative of activation function 0<=f’(x)<<1 (close to zero); exploding gradients when f’(x)>1. Gradients used to update the network's weights become extremely small or "vanish" as they are backpropagated from the output layers to the earlier layers. (Eg. sigmoid, tanh)

##### Why do we need activation functions?
Its primary purpose is to introduce non-linearity into the model, which allows he network to approximate any continuous function (Universal Approximation Theorem). Without activation functions, a neural network would be equivalent to a simple linear regression model, incapable of learning complex patterns in data.

##### Activation functions depending on output layer
softmax is used for multi-class classification, sigmoid for binary classification, and linear for regression.   

##### Activation functions depending on architecture
Generative Adversarial Networks (GANs): Leaky ReLU for the generator, and sigmoid or tanh for the discriminator
RNN: Tanh or ReLU (more nowadays)
CNN: ReLU

##### Why is RELU better?
* Computational Simplicity
* Negative inputs can output true zero values allowing a sparse representation which accelerates learning and simplifies the model.
* Easier to optimize when its behavior is linear or close to linear.

##### Solutions to Vanishing Gradient Problem
* Activation Functions:ReLU and its variants
* Weight initialization techniques like Xavier and He initialization
* Gradient Clipping
* Batch Normalization: Normalizing activations
* Architectural: Resnets (skip connections), LSTM and GRU gates
* Optimization algorithsm with Adaptive learning rate methods. Eg: Adam and RMSprop

##### Recent Advancements
* Mish: a smooth, continuous, self regularized, non-monotonic activation function:
  * Mish: f(x) = x*tanh(log(1+e^x))
  * Mish is bounded below at around 0.31, and unbound above.
  * Due to the preservation of a small amount of negative information, Mish eliminated the Dying ReLU phenomenon.
* Swish
* Gaussian Error Linear Unit (GELU):Inspired by dropout, GELU introduces a stochastic element into the activation function.
* Hybrid Activation Functions:Combining multiple activation functions within a single layer
* Areas of interest:
  * Smoothness: to help with gradient flow and optimization)
  * Non-monotonicity: to introduce more complex behaviors and improve model expressivity
  * Adaptivity: to adapt to different data distributions or training stages




