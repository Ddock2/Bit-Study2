CREATE TABLE book_table(
    isbn        NUMBER(13)      PRIMARY KEY,
    title       VARCHAR2(100)   NOT NULL,
    author      VARCHAR2(100),
    price       NUMBER(6),
    usable      NUMBER(1)       DEFAULT 1
);