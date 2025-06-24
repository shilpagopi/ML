# Nearest Neighbour
* Exact nearest neighbor: time complexity is O(N×D) where N is the total number of points and D is the point dimension.
* Approximate nearest neighbor (ANN): reduce the time complexity of NN search to sublinear via efficient data structures
Implementations: Faiss (developed by Meta) and ScaNN (developed by Google)

<img width="721" alt="image" src="https://github.com/user-attachments/assets/8df0a63e-a5fc-457b-8267-3a9931e97f4b" />

## Categories of ANN Algorithms
<img width="740" alt="image" src="https://github.com/user-attachments/assets/3c6b7340-b547-4ee7-95ca-7f02ca7ed609" />
<img width="717" alt="image" src="https://github.com/user-attachments/assets/0a04c616-ee4f-46c7-811b-fc9bbcade1ae" />
<img width="870" alt="image" src="https://github.com/user-attachments/assets/0fc87fdc-43d8-4218-81ed-eb43c5e50574" />
<img width="727" alt="image" src="https://github.com/user-attachments/assets/34d45ab9-f11a-48d9-b8f1-eef48117a9b9" />
<img width="724" alt="image" src="https://github.com/user-attachments/assets/e71dfff4-06b5-44f3-97d3-443b8ddc0f1b" />
<img width="724" alt="image" src="https://github.com/user-attachments/assets/ea76f17a-c9fb-4c9d-95fd-826a5de5ec67" />

<img width="723" alt="image" src="https://github.com/user-attachments/assets/841d3a0e-9ff0-4550-b8d8-3037b8a743dd" />

For dynamically changing(only new addition, not for updates) indices like those in social media post recommendation systems, HNSW (Hierarchical Navigable Small World) is the leading ANN algorithm due to its efficient incremental update capabilities, high recall, and speed. For practical deployment, leveraging a vector database (like Milvus) that implements and manages HNSW at scale is the recommended approach.

### HNSW (Heirarchical Mavigable Small World)
<img width="749" alt="image" src="https://github.com/user-attachments/assets/e4cc607d-fdb7-4124-a3a0-0268f8e83ce9" />
<img width="749" alt="image" src="https://github.com/user-attachments/assets/d2255727-c2bc-497d-885b-1b00ad476f59" />
<img width="747" alt="image" src="https://github.com/user-attachments/assets/f1494bce-09d4-43f8-9fb8-e95395d19aa1" />
<img width="732" alt="image" src="https://github.com/user-attachments/assets/d9897b34-f1c6-4de2-b24e-03956e7d54c8" />
