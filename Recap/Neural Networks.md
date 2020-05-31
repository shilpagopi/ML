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
