##### Database
What is a transaction?
Why do we need transactions?
Explain ACID.
What exactly does atomicity guarantee?
What exactly does consistency mean?
What does isolation mean?
What does durability mean?
What happens when you ROLLBACK?
What happens when you COMMIT?
What is autocommit?
Can multiple transactions run at the same time?
Does BEGIN prevent other transactions from accessing the database?
Does using a transaction automatically prevent race conditions?
What's the difference between a transaction and a query?
Why do long-running transactions cause problems?
Why are transactions important for something like a bank transfer?
Why can't PostgreSQL produce dirty reads?
Why can Read Committed have non-repeatable reads?
Why does Repeatable Read prevent non-repeatable reads?
What's the difference between a statement snapshot and transaction snapshot?
Why can Repeatable Read still have write skew?
What does Serializable guarantee?
Why can Serializable transactions need retries?
Why wouldn't you automatically use Serializable everywhere?
What's the difference between isolation and locking?
What's PostgreSQL's default isolation level?
What is a B+ Tree, and why do databases commonly use it for indexes instead of a Binary Search Tree?
Why can both a BST and B+ Tree have O(log n) search complexity, but a B+ Tree typically requires fewer disk/page I/Os?
What happens when a B+ Tree leaf or internal node becomes full? What happens when the root becomes full?
What is the difference between a PostgreSQL heap table and a MySQL InnoDB clustered index?
In PostgreSQL, what is a TID, and how does an index use it to find the actual row?
What is a composite index, and why does the order of columns matter?
Given an index on (last_name, first_name), which queries can efficiently use it and why can't first_name alone generally use it efficiently?
What is a covering index, and how can it enable an Index-Only Scan?
What are the trade-offs of using a covering index?
Why do indexes make reads faster but potentially make INSERT, UPDATE, and DELETE slower?
What is a B+ Tree page split, and why can frequent page splits hurt write performance?
If you have a table with millions of rows and a query that frequently filters by user_id and returns name and age, how would you design the index and why?
Why do we need sharding?
Replication vs sharding?
Vertical vs horizontal partitioning?
Partitioning vs sharding?
What makes a good shard key?
Why is high cardinality important?
Why is even distribution important?
Why does query locality matter?
Why can user_id be a good shard key?
Give an example of a bad shard key.
What is a hot shard?
Can data be evenly distributed but traffic be uneven?
How would you handle a viral post?
When would caching solve a hotspot?
How can read replicas help?
Why is hash(key) % N difficult to scale?
What happens when you add a new shard?
How would you migrate data without downtime?
How do you handle writes happening during migration?
How do you verify migration correctness?
What problem does consistent hashing solve?
How does the hash ring work?
What is a virtual node?
Why do virtual nodes improve distribution?
How much data moves when a node is added?

Database Mastery Test — Concurrency, Isolation & MVCC
Part 1 — Fundamentals
What problem does database concurrency solve? Why don't we simply execute every transaction sequentially?
What is a transaction, and what does each letter in ACID mean?

Suppose two transactions execute simultaneously:

SELECT balance FROM accounts WHERE id = 1;
UPDATE accounts SET balance = balance - 100 WHERE id = 1;

What kinds of problems can happen if concurrency isn't handled correctly?

What's the difference between:
concurrency
parallelism
isolation?
Part 2 — Concurrency Anomalies

For each scenario, identify the anomaly and explain why it happens.

Dirty Read

T1:

UPDATE balance = 500

T2:

SELECT balance → 500

T1 then rolls back.

What did T2 observe?

Non-repeatable Read

T1: SELECT balance → 100
T2: UPDATE balance → 200
T2: COMMIT
T1: SELECT balance → 200

What anomaly occurred?

Phantom Read

T1: SELECT * FROM users WHERE age > 18
T2: INSERT user(age=25)
T2: COMMIT
T1: SELECT * FROM users WHERE age > 18

Why can the second query return an additional row?

Lost Update

T1: READ balance = 100
T2: READ balance = 100

T1: WRITE 150
T2: WRITE 120

What happened to T1's update?

Write Skew

Two doctors are on-call:

Alice = on_call
Bob   = on_call

Rule:

At least one doctor must remain on-call.

T1 sees Bob is on-call and turns Alice off.

T2 sees Alice is on-call and turns Bob off.

Both commit.

Why can this violate the invariant?

What's the difference between lost update and write skew?
Part 3 — Isolation Levels
Explain the four commonly discussed isolation levels:
Read Uncommitted
Read Committed
Repeatable Read
Serializable
What anomaly does Read Committed prevent?
What anomalies can still happen under Read Committed?
What is the key difference between:

Read Committed snapshot

and

Repeatable Read snapshot?

Consider:
Initial balance = 100

T1:
BEGIN
UPDATE balance = 200
COMMIT

T2:
BEGIN
SELECT balance

Under Read Committed, what can T2 see?

Now suppose T2 started before T1 committed:
T2:
BEGIN

T1:
UPDATE balance = 200
COMMIT

T2:
SELECT balance

Under PostgreSQL Repeatable Read, what can T2 see?

Why?

PostgreSQL's READ UNCOMMITTED exists as a SQL isolation level. Does PostgreSQL actually allow dirty reads?
Does PostgreSQL Repeatable Read allow ordinary phantom reads?
Can write skew still happen under PostgreSQL Repeatable Read?
What does Serializable guarantee?
Part 4 — MVCC
What is MVCC, and why do databases use it?
Imagine:
balance = 100

T1 updates it:

balance = 200

Under MVCC, does the database conceptually just destroy the old value?

Explain.

What's the difference between:

row version

and

snapshot?

Is a snapshot a physical copy of the entire database?
Why does MVCC allow a normal SELECT to read while another transaction is updating the same row?
Suppose:
Old version: balance = 100
New version: balance = 200

Transaction T2 started before the update.

How does MVCC determine which version T2 can see?

What's the relationship between MVCC and isolation levels?

Are they the same thing?

Why does PostgreSQL need VACUUM in an MVCC system?
What happens to old row versions that are no longer needed?
Part 5 — Locks
Does a normal PostgreSQL:
SELECT *
FROM accounts
WHERE id = 1;

acquire a lock that prevents another transaction from updating the row?

What does:
SELECT *
FROM accounts
WHERE id = 1
FOR UPDATE;

do differently?

Suppose:
T1:
SELECT ... FOR UPDATE → account 1

T2:
SELECT ... FOR UPDATE → account 1

What happens to T2?

Why can two transactions normally read the same row simultaneously but two transactions can't freely update the same row simultaneously?
What's the difference between:
row lock
table lock?
When would you use SELECT ... FOR UPDATE?
Part 6 — Race Conditions
You have:
seats.available = 1

Two users try to book the final seat simultaneously.

Naive implementation:

SELECT available
if available > 0:
    UPDATE available = available - 1

Explain the race condition.

Give three different ways to solve the seat-booking problem.
Why is this safer?
UPDATE seats
SET available = available - 1
WHERE id = 1
  AND available > 0;
What should the application check after executing that query?
Part 7 — Optimistic vs Pessimistic Locking
Explain the difference between:

optimistic locking

and

pessimistic locking.

When would you prefer optimistic locking?
When would you prefer pessimistic locking?
Explain this pattern:
UPDATE products
SET stock = stock - 1,
    version = version + 1
WHERE id = 10
  AND version = 5;

Why is version = 5 important?

What happens if the UPDATE affects 0 rows?
Does optimistic locking prevent conflicts, or does it detect them?
Part 8 — Deadlocks
What is a deadlock?
Explain this situation:
T1:
lock A
wait for B

T2:
lock B
wait for A

Why can't either transaction continue?

How can you prevent deadlocks through application design?
What does PostgreSQL do when it detects a deadlock?
Why is this dangerous?
Transaction A:
UPDATE user 1
UPDATE user 2

Transaction B:
UPDATE user 2
UPDATE user 1
How would you redesign the above to reduce the deadlock risk?
Part 9 — Scenario Questions ⭐

These are more important than memorizing definitions.

52. Bank Transfer

You have:

Alice = $100
Bob   = $100

Transfer $50:

Alice -= 50
Bob   += 50

Two transfers can happen concurrently.

How would you guarantee that money isn't lost?

53. Inventory

You have:

stock = 1

100 users click Buy simultaneously.

Design a database-level solution that guarantees:

Stock never becomes negative.

54. Doctor On-Call

You have:

Alice = on_call
Bob   = on_call

Invariant:

At least one must remain on-call.

Two transactions can independently turn themselves off.

Which isolation/locking strategy would you consider and why?

55. Ticket Booking

Two users try to purchase the same seat.

Would you use:

FOR UPDATE

or:

optimistic locking

or:

Serializable

Explain your choice and what trade-off you're making.

56. Long Transaction

Suppose a transaction runs for:

30 minutes

in a PostgreSQL MVCC database.

Why could this be problematic?

Think about:

old row versions
VACUUM
storage
transaction snapshots
Part 10 — Interview-Level Questions ⭐⭐⭐
Why doesn't PostgreSQL need to block readers whenever a row is being updated?
MVCC vs locking — why does PostgreSQL need both?
Why isn't MVCC alone enough to prevent all race conditions?
Why can Repeatable Read still allow write skew?
Why can Serializable transactions fail even though the database guarantees serializable behavior?
What is a serialization failure, and what should the application do when it receives one?
Compare:
FOR UPDATE
vs
Serializable
If you have a single-row invariant:
stock > 0

what would you use?

If you have a complex multi-row invariant:
At least one doctor must remain on-call

what would you consider?

If conflicts are extremely rare and you want high concurrency, which approach might be attractive?
If conflicts are extremely frequent, why might optimistic locking perform poorly?