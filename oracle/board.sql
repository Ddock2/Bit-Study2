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

------------------------------------------------------------------
CREATE TABLE J_BOARD (
		no			NUMBER(6)		PRIMARY KEY,
		title		VARCHAR2(200)	NOT NULL,
		writer		VARCHAR2(40)	NOT NULL,
		content		VARCHAR2(4000),
		view_cnt	NUMBER(6)		DEFAULT 0,
		reg_date	DATE			DEFAULT SYSDATE
	);
	
CREATE SEQUENCE seq_j_board_no;

CREATE TABLE J_BOARD_FILE (
		no				NUMBER(6),
		board_no		NUMBER(6),
		file_ori_name	VARCHAR2(200),
		file_save_name	VARCHAR2(200),
		file_size		VARCHAR2(512)
	);
	
CREATE SEQUENCE seq_j_board_file_no;

------------------------------------------------------------------

CREATE TABLE mysite_member(
		id			VARCHAR2(20)	PRIMARY KEY,
		password	VARCHAR2(20)	NOT NULL,
		name		VARCHAR2(20)	NOT NULL,
		reg_date	DATE			DEFAULT SYSDATE
);

CREATE TABLE mysite_board(
		no			NUMBER(6)		PRIMARY KEY,
		title		VARCHAR2(30)	NOT NULL,
		writer		VARCHAR2(20)	NOT NULL,
		content		VARCHAR2(500)	NOT NULL,
		reg_date	DATE			DEFAULT SYSDATE,
		view_cnt	NUMBER(6)		DEFAULT 0
);
CREATE SEQUENCE seq_mysite_board_no;

CREATE TABLE mysite_board_file (
 		no				NUMBER(6)		PRIMARY KEY,
 		board_no		NUMBER(6)		NOT NULL,
 		file_ori_name	VARCHAR2(200)	NOT NULL,
 		file_save_name	VARCHAR2(200)	NOT NULL,
 		file_size		NUMBER(6)		NOT NULL
);
CREATE SEQUENCE seq_mysite_board_file_no;

CREATE TABLE mysite_comment (
		no				NUMBER(6)		PRIMARY KEY,
		board_no		NUMBER(6)		NOT NULL,
		writer			VARCHAR2(20)	NOT NULL,
		content			VARCHAR2(200)	NOT NULL,
		reg_date		DATE			DEFAULT SYSDATE
);
CREATE SEQUENCE seq_mysite_comment_no;

------------------------------------------------------------------

CREATE TABLE jgame_member(
    id          VARCHAR2(20)    PRIMARY KEY,
    password    VARCHAR2(20)    NOT NULL,
    name        VARCHAR2(20)    NOT NULL,
    reg_date    DATE            DEFAULT SYSDATE
);

CREATE TABLE jgame_profile_img(
    id                      VARCHAR2(20)    PRIMARY KEY,
    profile_img_save_name   VARCHAR2(200)   NOT NULL,
    profile_img_ori_name    VARCHAR2(200)   NOT NULL,
    CONSTRAINT jgame_profile_img_id_fk
        FOREIGN KEY(id)
        REFERENCES jgame_member(id)
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_jgame_board_no;
CREATE TABLE jgame_board(
    no          NUMBER(6)       PRIMARY KEY,
    title       VARCHAR2(30)    NOT NULL,
    writer      VARCHAR2(20)    NOT NULL,
    content     VARCHAR2(500)   NOT NULL,
    reg_date    DATE            DEFAULT SYSDATE,
    view_cnt    NUMBER(6)       DEFAULT 0
);

CREATE SEQUENCE seq_jgame_comment_no;
CREATE TABLE jgame_comment(
    no          NUMBER(6)       PRIMARY KEY,
    board_no    NUMBER(6)       NOT NULL,
    writer      VARCHAR2(20)    NOT NULL,
    content     VARCHAR2(200)   NOT NULL,
    reg_date    DATE            DEFAULT SYSDATE,
    CONSTRAINT jgame_comment_board_no_fk
        FOREIGN KEY(board_no)
        REFERENCES jgame_board(no)
        ON DELETE CASCADE
);

CREATE SEQUENCE seq_jgame_ranking_no;
CREATE TABLE jgame_ranking(
    no          NUMBER(6)       PRIMARY KEY,
    id          VARCHAR2(20)    NOT NULL,
    item        VARCHAR2(20)    NOT NULL,
    reg_date    DATE            DEFAULT SYSDATE,
    CONSTRAINT jgame_ranking_no_fk
        FOREIGN KEY(id)
        REFERENCES jgame_member(id)
        ON DELETE CASCADE
);