package com.bit.day05.prob;

// Prob2
// BookShop

public class Book {
	int bookNo;
	String title;
	String author;
	int stateCode;
	
	public Book() {
		stateCode = 1;
	}
	
	public Book(int bookNo, String title, String author) {
		this();
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
	}
	
	public void rent() {
		if(stateCode==1) {
			stateCode = 0;
			System.out.println(title + "이(가) 대여 됐습니다.");
		} else {
			System.out.println(title + "은(는) 이미 대여중 입니다.");
		}
	}
	
	public void print() {
		System.out.printf("책 제목:%s, 작가:%s, 대여 유무:%s\n", title, author, stateCode==1?"재고있음":"대여중");
	}

	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
