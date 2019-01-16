package com.bit.day08.prob;

// Prob1

public class Member {
	private String id;
	private String pw;
	
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + "]";
	}
	
}
