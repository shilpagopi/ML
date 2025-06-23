# ML Metrics
## Mean reciprocal rank (MRR)
<img width="1253" alt="image" src="https://github.com/user-attachments/assets/ad9eaa12-1afd-4466-ace9-090185000461" />

## Recall@k (not very useful as the deno could be large)
<img width="1253" alt="image" src="https://github.com/user-attachments/assets/1f9f3f50-5cee-4052-8ffe-45f3fedfe7b6" />

## Precision@k
<img width="975" alt="image" src="https://github.com/user-attachments/assets/d63da339-e3fa-4c28-85f3-00a002c4ffcc" />

## mAP (mean Average Precision)
<img width="1265" alt="image" src="https://github.com/user-attachments/assets/7715d8a6-15fa-4ded-8a17-5116f3b2ff7e" />
However, mAP is designed for binary relevances; in other words, it works well when each item is either relevant or irrelevant. For continuous relevance scores, nDCG is a better choice.

## nDCG
<img width="1265" alt="image" src="https://github.com/user-attachments/assets/77492bd8-bb01-4da6-b215-39e6f9827d0c" />
Its primary shortcoming is that deriving ground truth relevance scores is not always possible. In our case, since the evaluation dataset contains similarity scores, we can use nDCG to measure the performance of the model during the offline evaluation.






