package com.bit.jgame.vo;

/*
	CREATE TABLE jgame_comment (
		no						NUMBER(6)		PRIMARY KEY,
		board_no		NUMBER(6)		NOT NULL,
		writer					VARCHAR2(20)	NOT NULL,
		content					VARCHAR2(200)	NOT NULL,
		reg_date				DATE			DEFAULT SYSDATE
	);
	
	CREATE SEQUENCE seq_jgame_comment_no;
*/

public class CommentVO {
	private int no;
	private int board_no;
	private String writer;
	private String content;
	private String reg_date;
	
	public CommentVO() {
		super();
	}
	
	public CommentVO(int board_no, String writer, String content) {
		super();
		this.board_no = board_no;
		this.writer = writer;
		this.content = content;
	}

	public CommentVO(String writer, String content, String reg_date) {
		super();
		this.writer = writer;
		this.content = content;
		this.reg_date = reg_date;
	}

	public CommentVO(int no, int board_no, String writer, String content, String reg_date) {
		super();
		this.no = no;
		this.board_no = board_no;
		this.writer = writer;
		this.content = content;
		this.reg_date = reg_date;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "CommentVO [no=" + no + ", board_no=" + board_no + ", writer=" + writer + ", content=" + content
				+ ", reg_date=" + reg_date + "]";
	}
	
}
