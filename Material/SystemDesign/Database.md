1. Transaction
2. ACID
    -Atomicity
    -Consistentcy
    -Isolation / conccurency
    -Durability
3. AutoCommit
4. Savepoints
5. Transaction vs query
6. session/connection
7. Anomalies
    - Dirty Read
    - Non-Repeatable Read
    - Phantom Read
    - Write Skew
    - (not original anomalies) lost update
8. 4 Level Isolation : weakest to stronget
    - Read Uncommited
    - Read commited
    - repeatble read
    - serializable
9. Isolation (the transaction see) vs Locking (modify/access concurrently)
10. Choose the weakest isolation level that still guarantees the correctness requirement
11. MVCC
12. Lock in Postgres
13. deadlock
14. Pessimistic vs Optimistic Locking
15. Race COndition

                CONCURRENCY
                    │
        ┌───────────┴───────────┐
        ↓                       ↓
       MVCC                   LOCKS
        │                       │
 multiple versions        coordinate conflicts
        │                       │
        ↓                       ↓
    SNAPSHOTS              FOR UPDATE
        │
        ↓
ISOLATION LEVELS
 │
 ├── Read Committed
 ├── Repeatable Read
 └── Serializable
 

16. B+ Tree Anatomy
17. PostgreSQL Heap Table & Indexes
18. Composite Indexes & Left-Most Prefix Rule
19. Covering indexes / Index - only scan
20. Write Penalties
21. Page splits
22. N + 1 Problem
23. Lazy Loading -> Eager Loading (JOIN) / Batching
24. Join vs Batching
25. Data Loader
26. N + 1 vs Slow Query
27. Explain, Explain Analyze
28. Index, Seq Scan, Bitmap Heat Scan
29. Sharding
30. Vertical Scaling
31. Horizonal Scaling
32. Cross-Shard queries
33. Scatter-gather (shard key)
34. Transaction Mechanism
    - two phase commit
    - distributed transactions
    - sagas
    - compensating transactions
35. Typical Scaling Journey
    - simple
    - optimize 
    - cache
    - read replica
    - vertical Scaling
    - Sharding
36. Vertical vs Horizontal Partitioning
37. High Cardinality, Even Distribution, query locality, stability, avoid hotspot (sharding)
38. Compound Shard Keys
39. Transaction locality
40. Range, Hash, Directory sharding
41. Data Skew vs Traffic Skew
42. hotspot -> distributed counters
43. ReSharding
44. High Level Zero Downtime migration
45. Consistent Hashing
46. Virtual Nodes