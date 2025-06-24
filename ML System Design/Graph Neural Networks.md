# Graph Neural Networks
##### Why are GNNs Necessary?
* Arbitrary Size and Complex Topology
* No Fixed Order: No inherent order. Permuting the order of nodes should not change the graph's properties or the model's output (permutation invariance/equivariance).
* Local Connectivity: Information in graphs is often local, determined by immediate neighbors. CNNs use fixed filters, which don't generalize to arbitrary graph structures.
GNNs address these challenges by extending the principles of deep learning to capture both the features of individual nodes/edges and the structural relationships within the graph.

<img width="761" alt="image" src="https://github.com/user-attachments/assets/63ca8b3e-1663-432a-a96b-a670123e1c11" />

## Types of GNNs
<img width="761" alt="image" src="https://github.com/user-attachments/assets/5d4d9062-bad3-4a12-ac49-3025b24a1610" />
<img width="761" alt="image" src="https://github.com/user-attachments/assets/8d6d0743-21b8-4f80-b524-1b9fa072fbf4" />

## Implementation
<img width="735" alt="image" src="https://github.com/user-attachments/assets/24d7f817-107a-489a-a6bd-e8fe9523a42e" />
<img width="735" alt="image" src="https://github.com/user-attachments/assets/3de54825-9916-4470-8799-08641f6404a1" />
<img width="735" alt="image" src="https://github.com/user-attachments/assets/eab3a67d-f911-4e9a-8683-c0bfc159df62" />
Key Idea: The attention mechanism learns how much importance to assign to each neighbor when aggregating information. This allows the model to focus on more relevant neighbors, potentially improving performance on tasks where neighbor importance varies. Multi-head attention is often used to stabilize the learning process.

<img width="735" alt="image" src="https://github.com/user-attachments/assets/41e19cd7-1847-4149-903f-26fef8fb5293" />
<img width="735" alt="image" src="https://github.com/user-attachments/assets/43d6b0a0-5d4c-43ab-a537-af9083a0484d" />
<img width="735" alt="image" src="https://github.com/user-attachments/assets/6694b87b-9587-48b0-bc05-28006a941b6b" />
<img width="735" alt="image" src="https://github.com/user-attachments/assets/dcbac6d0-52fa-40cc-b2aa-8194dd39f5bf" />
<img width="735" alt="image" src="https://github.com/user-attachments/assets/d23740b6-7935-422f-ad98-c00329ce69a9" />









