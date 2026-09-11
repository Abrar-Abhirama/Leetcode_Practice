1. redis (the tool) = cache (the concept)
2. CPU/RAM -> Cache -> SSD -> Postgres -> Disk
3. Cache Hit vs Cache Miss
4. Cache Hit Rate
5. TTL (Time To Live)
6. Enviction
7. Basically Key -> Value
8. Cache-Aside
9. Hot Key 
10. Hot Key can still be a problem when overloaded
11. Cache Expiration / Cache Stampede / Thundering Herd
12. good cache candidate
    - High read frequency 
    - expensive to retrieve 
    - acceptable to be slightly stale
13. Stale Data
14. Cache Invalidation
15. Techniques
    - Randomized TTL
    - Background Refresh
16. Cache Failure & Scalling
17. Redis Cluster
18. request coalescing / distributed locking
