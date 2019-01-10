package com.bit.day04.Prob;

/*
 	prob1
 		
 */

public class Prob1 {
	
	public static void main(String[] args) {
		Member m = new Member();
		
		m.setId("아이디");
		m.setName("이름");
		m.setPoint(22);
		
		System.out.println(m.toString());
	}
	
}

class Member {
	private String id;
	private String name;
	private int point;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", point=" + point + "]";
	}
	
	
}