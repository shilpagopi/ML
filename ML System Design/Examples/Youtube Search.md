# Youtube Search
### Diagrams
<img width="800" alt="image" src="https://github.com/user-attachments/assets/8f0293c3-0d30-47fb-a24a-48b3aa5cd395" />

### Model
* Fusion Ranker: The fusing layer can be implemented in two ways, the easiest of which is to re-rank videos based on the weighted sum of their predicted relevance scores. A more complex approach is to adopt an additional model to re-rank the videos, which is more expensive because it requires model training. Additionally, it's slower at serving. As a result, we use the former approach.
* use Elasticsearch for indexing titles, manual tags, and auto-generated tags.
