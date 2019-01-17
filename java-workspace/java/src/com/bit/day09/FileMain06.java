package com.bit.day09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.bit.util.FileClose;

public class FileMain06 {
	
	public static void main(String[] args) {
		write();
		read();
	}
	
	public static void write() {
		Member member = new Member("박신헤", 30, "서울시 서초구");
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("iotest/object.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(member);
			
			System.out.println("저장완료");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			FileClose.close(fos, oos);
		}
	}
	
	public static void read() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("iotest/object.txt");
			ois = new ObjectInputStream(fis);
			
			Member member = (Member)ois.readObject();
			
			System.out.println("읽기 완료");
			System.out.println(member.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			FileClose.close(fis, ois);
		}
	}
	
}

@SuppressWarnings("serial")
class Member implements Serializable{	// Member를 파일에 쓸 수 있도록 직렬화
	private String name;
	private int age;
	private transient String addr;	// 직렬화에서 제외
	
	public Member() {
		super();
	}
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Member [addr=" + addr + ", age=" + age + ", name=" + name + "]";
	}
	
	
}
