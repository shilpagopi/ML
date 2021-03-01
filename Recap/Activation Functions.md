# Activation Functions

| Name | Formula | Derivative | Remarks |
|--|--|--|--|
| Linear | m x z | Constant m | If there is an error in prediction, the changes made by back propagation is constant and not depending on the change in input delta(x) ! |
| Exponential Linear Unit (ELU) | Similar to RELU, but for z values, alpha*(exp(z)-1) | 1 (z>0), alpha x exp(z) (z<0) | No vanishing gradient issues|


* Vanishing gradients happens when derivative of activation function 0<=f’(x)<1; exploding gradients when f’(x)>1.
