package com.bit.board;

import java.util.Arrays;

/*
	CREATE SEQUENCE seq_m_board_no;
	
	CREATE TABLE m_board(
	    no          NUMBER(6)       PRIMARY KEY,
	    title       VARCHAR2(20)    ,
	    content     VARCHAR2(100)
	);
*/

public class BoardVO {
	private int no;
	private String title;
	private String content;
	private int[] nos;
	
	public BoardVO() {
		super();
	}
	public BoardVO(int no, String title, String content, int[] nos) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.nos = nos;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int[] getNos() {
		return nos;
	}
	public void setNos(int[] nos) {
		this.nos = nos;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", content=" + content + ", nos=" + Arrays.toString(nos)
				+ "]";
	}
}
