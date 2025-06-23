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
