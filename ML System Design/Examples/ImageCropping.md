# Image Cropping
Cropping using saliency
A better way to crop is to focus on “salient” image regions. A region having high saliency means that a person is likely to look at it when freely viewing the image. Academics have studied and measured saliency by using eye trackers, which record the pixels people fixated with their eyes. In general, people tend to pay more attention to faces, text, animals, but also other objects and regions of high contrast. This data can be used to train neural networks and other algorithms to predict what people might want to look at.
The basic idea is to use these predictions to center a crop around the most interesting region.
