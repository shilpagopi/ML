# ML Metrics
## Mean reciprocal rank (MRR)
<img width="1253" alt="image" src="https://github.com/user-attachments/assets/ad9eaa12-1afd-4466-ace9-090185000461" />

## Recall@k (not very useful as the deno could be large)
<img width="1253" alt="image" src="https://github.com/user-attachments/assets/1f9f3f50-5cee-4052-8ffe-45f3fedfe7b6" />

## Precision@k
<img width="975" alt="image" src="https://github.com/user-attachments/assets/d63da339-e3fa-4c28-85f3-00a002c4ffcc" />

## mAP (mean Average Precision)
<img width="1265" alt="image" src="https://github.com/user-attachments/assets/7715d8a6-15fa-4ded-8a17-5116f3b2ff7e" />
However, mAP is designed for binary relevances; in other words, it works well when each item is either relevant or irrelevant. For continuous relevance scores, nDCG is a better choice. mAP is non differentiable.

<img width="697" alt="image" src="https://github.com/user-attachments/assets/88d56fb0-1f7d-44ba-b3be-31c5db30f585" />

## Hit@K
Fraction of sessions where at least one relevant item appears in the top K

## Coverage
Proportion of catalog shown over a time window—critical for cold-start sellers and long-tail content

## nDCG
<img width="1265" alt="image" src="https://github.com/user-attachments/assets/77492bd8-bb01-4da6-b215-39e6f9827d0c" />
Its primary shortcoming is that deriving ground truth relevance scores is not always possible. In our case, since the evaluation dataset contains similarity scores, we can use nDCG to measure the performance of the model during the offline evaluation. rel_i is higher for top ranks.

<img width="1251" alt="image" src="https://github.com/user-attachments/assets/d148af36-329a-431f-b570-00efdfe473cc" />

<img width="1293" alt="image" src="https://github.com/user-attachments/assets/bae067e8-32ff-4194-a80b-9d99474ee2fa" />
NDCG values range from 0 to 1. nDCG is non differentiable.

# Image Related Metrics
## IOU (Intersection over Union)
For object detection bounding boxes
  
## CLIP Score:
* Intuition: "How well does the generated image match the text prompt?"
* Higher scores indicate better text-image alignment: Based on how close the image and text embeddings are in a shared space

# For Gen-AI Specific Metrics: Go to https://github.com/shilpagopi/ML/blob/master/Recap/LLM.md

## ML Metrics for Learning to Rank Approaches
<img width="737" alt="image" src="https://github.com/user-attachments/assets/d0a45988-b28e-4798-af97-7777cf1e028f" />
<img width="737" alt="image" src="https://github.com/user-attachments/assets/2023731c-e51a-494b-85db-6c11d570fd0d" />
<img width="737" alt="image" src="https://github.com/user-attachments/assets/12b896fa-2d0d-4ca5-bd11-e7090947a7be" />
<img width="737" alt="image" src="https://github.com/user-attachments/assets/3bc009f5-6c98-44d0-9c35-9a575be87213" />

#### Lambda MART (for indirectly optimizing nDCG)
How it works in GBDT:
LambdaMART uses these λi values as the "gradients" for each document. The Gradient Boosting Decision Tree (GBDT) algorithm then builds decision trees that predict these lambdas. In essence, it learns a function that, when applied to a document's features, outputs a value that "pushes" the document in the direction that improves the overall NDCG or MAP.

<img width="737" alt="image" src="https://github.com/user-attachments/assets/c51d0b70-ce04-4d30-9870-daf4e983f913" />
<img width="737" alt="image" src="https://github.com/user-attachments/assets/1c18043b-32d5-4822-b808-7735d9b06a4d" />






