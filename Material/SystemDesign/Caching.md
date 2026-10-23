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

1. Client side caching
2. Http cache, web storage, cache control http header
3. no-cache vs no-store
4. Edge Caching (CDN)
5. TTL (Time to live), cache key, cache validation, cacheability 
6. Reserve Proxy Caching, Nginx Response Caching
7. Redis vs Memcached (In-Memory Caching)
8. Cache Aside, Write Through, Write Behind 
9. Cache Aside (race condition, cache isnt invalidated)
10. Least Recently Used (LRU)
11. Least Frequently Used (LFU)
12. First In, First Out (FIFO)
13. TTL/Expiration vs Eviction
14. Thundering Herd Problem (Cache Stampede) 
15. TTL Jitter, Mutex Lock, Proactive Background Refresh
16. Stateless Servers & Scaling Problem / Shared Redis Sessions
17. Sticky Sessions / Sessions affinity 
18. Stateless Authentication with JWT
