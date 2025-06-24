# Harmful Content Detection
* Late fusion: process different modalities (image, text, author) independently, then combine their predictions to make final prediction. We can train, evaluate, improve each model independently. But bad that we need to have separate training data for each modality, and combination of modalities might be harmful even if each modality is good.
* Early fusion: modalities are combined first, then make prediction. Good that it's unnecessary to collect training data for each modality, also model can capture harmful combinations of good modalities in unified feature vector. But complex relationships are difficult to learn.

### Model
* Single binary classifier: not easy to identify harmful classes
* One binary classifier per harmful class: each model determines if it's violent/hate, etc.
* Multiple classifiers - reduntant reuse/overlap of features
  
Multi-task classifier: model learn multiple tasks simultaneously, can learn similarities between tasks, no unnecessary computations.
Fused features -> Shared layers -> Transformed features -> Task specific layers -> Hate/violence probability
shared layers: newly transformed features to make predictions for each harmful classes
task-specifc layers: various Hate/violence/... classification head

### Metrics
precision-recall curve: tradeoff between precision and recall
receiver operating characteristic (ROC) curve: tradeoff between true positive (recall) and false positive.
