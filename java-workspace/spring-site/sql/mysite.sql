-- User Test
CREATE TABLE users (
	no			NUMBER(6)		PRIMARY KEY,
	name		VARCHAR2(40)	NOT NULL,
	email		VARCHAR2(80)	NOT NULL,
	password	VARCHAR2(20)	NOT NULL,
	gender		VARCHAR2(10)
);
CREATE SEQUENCE user_seq
	start with 1
	increment by 1
	maxvalue 999999;

-- Board Test
CREATE TABLE board (
	no			NUMBER(6)		PRIMARY KEY,
	title		VARCHAR2(100)	NOT NULL,
	content		VARCHAR2(500)	NOT NULL,
	reg_date		DATE			DEFAULT SYSDATE,
	hit			NUMBER(6)		NOT NULL,
	group_no		NUMBER(6)		NOT NULL,
	order_no		NUMBER(6)		NOT NULL,
	depth		NUMBER(2)		NOT NULL,
	user_no		NUMBER(6)		NOT NULL
);
CREATE SEQUENCE board_seq
	start with 1
	increment by 1
	maxvalue 999999;
	
-- Galery Test
CREATE TABLE gallery (
	no				NUMBER(6)		PRIMARY KEY,
	org_file_name	VARCHAR2(100)	NOT NULL,
	save_file_name	VARCHAR2(100)	NOT NULL,
	comments		VARCHAR2(100)	NOT NULL,
	file_ext_name	VARCHAR2(100)	NOT NULL,
	file_size		NUMBER(6)		NOT NULL,
	reg_date		DATE			DEFAULT SYSDATE,
	user_no			VARCHAR2(6)		NOT NULL
);
CREATE SEQUENCE gallery_seq
	start with 1
	increment by 1
	maxvalue 999999;