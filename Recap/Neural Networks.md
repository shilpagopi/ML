# Neural Networks
<img src="https://hackerwins.github.io/assets/img/2019-06-16-cs229a-week4/basic-unit-of-nn.png" width="400" height="400">

## Variants of RNN
One-to-one, one-to-many, many-to-one, many-to-many (input and output: same size, different size), bi-directional, deep (DRNN)

## Activation Functions
<img src="https://github.com/shilpagopi/ML/blob/master/Recap/img/activation-functions.JPG" width="750" height="300">

## BackPropagation
<img src="https://github.com/shilpagopi/ML/blob/master/Recap/img/gradient_descent.png" width="250" height="250">

## RNN Architecture
### RNN
<img src="https://github.com/shilpagopi/ML/blob/master/Recap/img/RNN%20Cell.png" width="750" height="400">

### GRU
<img src="https://github.com/shilpagopi/ML/blob/master/Recap/img/GRU%20Cell.png" width="750" height="400">

### LSTM
<img src="https://github.com/shilpagopi/ML/blob/master/Recap/img/LSTM%20Cell.png" width="750" height="400">

### Advantages of RNN 
* Possibility of processing input of any length
* Model size not increasing with size of input
* Computation takes into account historical information
* Weights are shared across time	

### Disadvantages of naive RNN
* Vanishing/Explodding gradient (solved by Gradient Clipping or Gates in LSTMs/GRUs)
* Difficulty of accessing information from a long time ago (solved by LSTMs/GRUs)
* Cannot consider any future input for the current state (solved by Bi-directional RNNs)

### What is a Linear Transformation
A Linear Transformation, also known as a linear map, is a mapping of a function between two modules that preserves the operations of addition and scalar multiplication.
U, also called the domain, to the vector space V, also called the codomain. ( T : U → V ) The linear transformation has two properties:
T(u1+u2)=T(u1)+T(u2) for all u1,u2∈U
T(αu)=αT(u)T(αu)=αT(u) for all u∈U and all α∈C

### Bias term in NN
The units have a constant bias input, which each output unit can weight independently to achieve the effect of a translation vector. 
The bias input determines the baseline value for the unit. 
