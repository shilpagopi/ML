# Hyperparameter Tuning
* * Grid Search: Exhaustively explores all combinations of hyperparameter values within a specified grid.
* * Random Search: Randomly samples hyperparameter values from a specified distribution.   
* * Bayesian Optimization: Define a prior distribution for each of the parameters. The objective function will return the neg of cross validation score of model.
* (Hyperopt package minimizes during optimization). Optimize the objective function.
* Packages: Optuna, hyperopt, scikit-learn
