# Feature Engineering

## Features
* User search history: Map each search query into an embedding vector and average.
* Video watch time/day/context/devicetype
* Explicit user interaction: Likes, comments, Negative feedback (do not recommend), Hide posts, Show fewer, Subscribe/Unsubscribe
* User location
* Content language
* Content Duration
* Content delivered by existing subscriptions
* Existing subscriptions embedding
* For hastags, use simpler embedding models (no need of transformers as there is hardly any context or length sentences)
* Content age to capture freshness: Use buckets (or log?) 0: less than 1 hour, 1 : between 1 to 5 hours, 2: between 5 to 24 hours, 3: between 1-7 days, 4: between 7-30 days, 5: more than a month
* Explicit user mentions
* User-author affinities: Like/click/comment/share rate, Length of friendship, Close friends and family
