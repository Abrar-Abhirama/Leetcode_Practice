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