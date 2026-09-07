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