package com.bit.mysite.vo;

/*
	CREATE TABLE mysite_member(
		id			VARCHAR2(20)	PRIMARY KEY,
		password	VARCHAR2(20)	NOT NULL,
		name		VARCHAR2(20)	NOT NULL,
		reg_date	DATE			DEFAULT SYSDATE
	);
 */

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String reg_date;
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public MemberVO(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public MemberVO(String id, String password, String name, String reg_date) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.reg_date = reg_date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", reg_date=" + reg_date + "]";
	}
}
