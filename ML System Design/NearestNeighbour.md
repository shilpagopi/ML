# Nearest Neighbour
* Exact nearest neighbor: time complexity is O(N×D) where N is the total number of points and D is the point dimension.
* Approximate nearest neighbor (ANN): reduce the time complexity of NN search to sublinear via efficient data structures
  * Tree-based ANN  :R-trees, Kd-trees, and Annoy (Approximate Nearest Neighbor Oh Yeah)
  * Locality-sensitive hashing (LSH)-based ANN
    <img width="870" alt="image" src="https://github.com/user-attachments/assets/0fc87fdc-43d8-4218-81ed-eb43c5e50574" />
  * Clustering-based ANN
  * Implementations: Faiss (developed by Meta) and ScaNN (developed by Google)

<img width="721" alt="image" src="https://github.com/user-attachments/assets/8df0a63e-a5fc-457b-8267-3a9931e97f4b" />

