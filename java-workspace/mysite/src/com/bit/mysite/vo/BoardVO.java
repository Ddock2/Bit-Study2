package com.bit.mysite.vo;

/*
	CREATE TABLE mysite_board(
		no			NUMBER(6)		PRIMARY KEY,
		title		VARCHAR2(30)	NOT NULL,
		writer		VARCHAR2(20)	NOT NULL,
		content		VARCHAR2(500)	NOT NULL,
		reg_date	DATE			DEFAULT SYSDATE,
		view_cnt	NUMBER(6)		DEFAULT 0
	);
	
	CREATE SEQUENCE seq_mysite_board_no;
 */

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String content;
	private String reg_date;
	private int view_cnt;
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(int no, String title, String writer, String content) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public BoardVO(int no, String title, String writer, String content, String reg_date, int view_cnt) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.reg_date = reg_date;
		this.view_cnt = view_cnt;
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
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", reg_date="
				+ reg_date + ", view_cnt=" + view_cnt + "]";
	}
	
}
