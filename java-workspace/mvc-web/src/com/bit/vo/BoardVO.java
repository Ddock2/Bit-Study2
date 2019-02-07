package com.bit.vo;

public class BoardVO {
	private String title;
	private String writer;
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(String title, String writer) {
		super();
		this.title = title;
		this.writer = writer;
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
	
	@Override
	public String toString() {
		return "BoardVO [title=" + title + ", writer=" + writer + "]";
	}
	
}
