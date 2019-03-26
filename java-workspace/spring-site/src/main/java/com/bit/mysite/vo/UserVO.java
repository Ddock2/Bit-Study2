package com.bit.mysite.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/*
	[테이블 생성]
	CREATE TABLE users (
		no			NUMBER(6)		PRIMARY KEY,
		name		VARCHAR2(40)	NOT NULL,
		email		VARCHAR2(80)	NOT NULL,
		password	VARCHAR2(20)	NOT NULL,
		gender		VARCHAR2(10)
	);
	
	[시퀀스 생성]
	CREATE SEQUENCE user_seq;
 */
/*
 	Hibernate 유효성 검사
	 	@NotEmpty	: 비어있는가
	 	@Email		: 이메일 형식
	 	@URL		: URL 형식
	 	@Length		: 문자열 길이 제한 (min, max)
	 	@Range		: 숫자 범위 제한 (min, max)
*/

public class UserVO {
	private Long no;
	
	@NotEmpty
	@Length(min=2, max=5)
	private String name;
	
	@NotEmpty
	@Email
//	@Pattern(regexp="^[0-9a-zA-Z](-_\\.]?[0-9a-zA-Z-])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z] {2, 3}$")
	private String email;
	
	@NotEmpty
	@Pattern(regexp="^[0-9]+$")
	private String password;
	private String gender;
	
	public UserVO() {
		super();
	}
	public UserVO(Long no, String name, String email, String password, String gender) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "UserVO [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + "]";
	}
	
}
