# Visual Search
### Scoping
* Search matching images and rank them
* Allow cropping
* Feedback? Click data
* Low latency

OOS:
* videos
* Like/share/save results (These actions can help label training data.)

### Business Metrics
Click-through Rates

### ML Problem Formulation
* System’s IO: one image, ranked list of images
* Problem Type: ranking problem
* Architecture: Nearest Neighbour (Exact or Approximate) and Ranking Service
* Metrics: Mean reciprocal rank (MRR), Recall@k, Precision@k, Mean average precision (mAP), Normalized discounted cumulative gain (nDCG)

### Data
Images - metadata?
Users - metadata?
User-image interactions - click feedback

Data Labeling: 
* Use human judgment
* Use interactions such as user clicks as a proxy for similarity
* Artificially create a similar image from the query image, known as self-supervision

Storage: 
* Use object storage for raw data
* Optimization: vector quantization

### Preprocessor
* Resizing: Models usually require fixed image sizes (e.g., 224×224)
* Scaling: Scale pixel values of the image to the range of 0 and 1
* Z-score normalization: Scale pixel values to have a mean of 0 and variance of 1
* Consistent : Ensuring images have a consistent color mode (e.g., RGB or CMYK)
  
### Postprocessor
This service incorporates business-level logic and policies. For example, it filters inappropriate results, ensures we don’t include private images, removes duplicates or nearduplicate results, and enforces other similar logic before displaying the final results to the user.

### Model
* RESNet or ViT
* contrastive training

### Diagram
<img width="1458" alt="image" src="https://github.com/user-attachments/assets/48bd27c9-871a-40d6-9a85-49fcda6d94f9" />



  
