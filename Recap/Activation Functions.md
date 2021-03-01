# Activation Functions

| Name | Formula | Derivative | Remarks | Vanishing gradient | Activation Blowup |
|--|--|--|--|--|--|
| Linear | m x z | Constant m | If there is an error in prediction, the changes made by back propagation is constant and not depending on the change in input delta(x) ! | Y | Y |
| Exponential Linear Unit (ELU) | Similar to RELU, but for negative z values, alpha*(exp(z)-1) | 1 (z>0), alpha x exp(z) (z<0) |--| Y | Y |
| RELU | max (0,z) | 1 and 0 | Less computationally expensive than tanh and sigmoid because it involves simpler mathematical operations. Dying ReLu problem| NO | Y |
| Sigmoid | | g(z) (1-g(z))| non-linear, continuously differentiable, monotonic, and has a fixed output range. Not zero centered - makes optimization harder.| Y | NO |
|Tanh|| 1 - g(z)^2|Non-linear, zero-centered, more preferred to sigmoid (?), steeper gradient than sigmoid,  fixed output range |Y|NO|
| Leaky RELU| (alpha x z) when z<0 | alpha | usu, alpha = 0.01 | NO | Y |
* Vanishing gradients happens when derivative of activation function 0<=f’(x)<1; exploding gradients when f’(x)>1.
