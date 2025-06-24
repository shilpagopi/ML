# Google Street View Blurring System
### Model
Object detection system

predict location of each object in image: regression to location (x, y)
predict class of each bounding box (dog, cat): multi-class classification
One-stage network: use single network, bounding boxes and object classes are generated simultaneously.

Two-stage networks (R-CNN, Fast R-CNN, Faster-RCNN): two components running sequentially, slower but accurate

Region proposal network (RPN): scan image and process candidate regions likely to be objects
Classifier: process each region and classify into object class

Post processing: Non-maximum suppression (NMS): To select most appropriate bounding boxes, keep highly confident bounding box and remove overlapping bounding box.

### Metrics
regression loss with MSE: bounding boxes of objects predicted should have high overlap with ground truth bounding box, how aligned they are.
classification loss with cross-entropy: how accurate the predicted probs are for each detected object.

Intersection over union (IOU): overlap between two bounding boxes
Precision = correct / total detections
Average precision: summarize model overall precision for specific object class (human face).
Mean average precision (mAP): overall precision for all object classes (human face, cat face).
