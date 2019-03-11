package com.bit.jgame.vo;

/*
 	CREATE SEQUENCE seq_jgame_ranking_no;
 	
	CREATE TABLE jgame_ranking(
	    no          NUMBER(6)       PRIMARY KEY,
	    id          VARCHAR2(20)    NOT NULL,
	    item        VARCHAR2(20)    NOT NULL,
	    score       NUMBER(6)       NOT NULL
	    CONSTRAINT jgame_ranking_no_fk
	        FOREIGN KEY(id)
	        REFERENCES jgame_member(id)
	        ON DELETE CASCADE
	);
 */

public class GameVO {
	private int no;
	private String id;
	private String item;
	private int score;
	
	public GameVO() {
		super();
	}
	public GameVO(int no, String id, String item, int score) {
		super();
		this.no = no;
		this.id = id;
		this.item = item;
		this.score = score;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "GameVO [no=" + no + ", id=" + id + ", item=" + item + ", score=" + score + "]";
	}
	
}
