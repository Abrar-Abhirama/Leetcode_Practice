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
 