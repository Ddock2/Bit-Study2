package com.bit.jgame.vo;

/*
	CREATE TABLE mysite_member(
		id						VARCHAR2(20)	PRIMARY KEY,
		password				VARCHAR2(20)	NOT NULL,
		name					VARCHAR2(20)	NOT NULL,
		reg_date				DATE			DEFAULT SYSDATE
	);
 */

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String reg_date;
	private String profile_img_save_name;
	
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
	
	public MemberVO(String id, String password, String name, String reg_date, String profile_img_save_name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.reg_date = reg_date;
		this.profile_img_save_name = profile_img_save_name;
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
	public String getProfile_img_save_name() {
		return profile_img_save_name;
	}
	public void setProfile_img_save_name(String profile_img_save_name) {
		this.profile_img_save_name = profile_img_save_name;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", reg_date=" + reg_date
				+ ", profile_img_save_name=" + profile_img_save_name + "]";
	}
	
}
