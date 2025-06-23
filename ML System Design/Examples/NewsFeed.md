# NewsFeed
### Features
* Content delivered by existing subscriptions
* Existing subscriptions embedding
* For hastags, use simpler embedding models (no need of transformers as there is hardly any context or length sentences)
* Content age to capture freshness: Use buckets (or log?) 0: less than 1 hour, 1 : between 1 to 5 hours, 2: between 5 to 24 hours, 3: between 1-7 days, 4: between 7-30 days, 5: more than a month
* Explicit user mentions
* User-author affinities: Like/click/comment/share rate, Length of friendship, Close friends and family
* Especially for passive users: Dwell-time: the time a user spends on a post.
* Especially for passive users: Skip: say a user spends less than t seconds (e.g., 0.5 seconds)
  
### Diagrams
<img width="683" alt="image" src="https://github.com/user-attachments/assets/fd85c0e8-705d-4d4d-960a-5de294e60edd" />
Why not independent DNNs: 
* Expensive to train, compute-intensive and time-consuming
* Abundant overlap between features
* Not enough training data for less frequent reactions

<img width="780" alt="image" src="https://github.com/user-attachments/assets/5da2469f-164d-49ad-a423-de61cdf85073" />

<img width="777" alt="image" src="https://github.com/user-attachments/assets/0672ab1e-a77d-4032-9025-9166c8708c74" />
