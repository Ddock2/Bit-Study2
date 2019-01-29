CREATE TABLE super_board(
    no          NUMBER(6)       PRIMARY KEY,
    title       VARCHAR2(100)   NOT NULL,
    writer      VARCHAR2(100)   NOT NULL,
    reg_date    DATE DEFAULT SYSDATE
);

CREATE SEQUENCE seq_super_board_no;

CREATE TABLE book_table(
    isbn        NUMBER(13)      PRIMARY KEY,
    title       VARCHAR2(100)   NOT NULL,
    author      VARCHAR2(100),
    price       NUMBER(6),
    usable      NUMBER(1)       DEFAULT 1
);

select * from book_table;
delete from book_table;