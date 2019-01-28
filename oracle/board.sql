CREATE TABLE super_board(
    no          NUMBER(6)       PRIMARY KEY,
    title       VARCHAR2(100)   NOT NULL,
    writer      VARCHAR2(100)   NOT NULL,
    reg_date    DATE DEFAULT SYSDATE
);

CREATE SEQUENCE seq_super_board_no;