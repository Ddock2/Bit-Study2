package com.bit.board.db;

/*
	CREATE TABLE J_BOARD (
		no			NUMBER(6)		PRIMARY KEY,
		title		VARCHAR2(200)	NOT NULL,
		writer		VARCHAR2(40)	NOT NULL,
		content		VARCHAR2(4000),
		view_cnt	NUMBER(6)		DEFAULT 0,
		reg_date	DATE			DEFAULT SYSDATE
	);
	
	CREATE SEQUENCE seq_j_board_no;
 */

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String content;
	private int view_cnt;
	private String reg_date;
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(int no, String title, String writer, String content, int view_cnt, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.view_cnt = view_cnt;
		this.reg_date = reg_date;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", view_cnt="
				+ view_cnt + ", reg_date=" + reg_date + "]";
	}
	
}
