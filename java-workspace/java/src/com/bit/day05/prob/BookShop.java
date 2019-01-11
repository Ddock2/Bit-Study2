package com.bit.day05.prob;

import java.util.Scanner;

// Prob2
// Book

public class BookShop {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] titles = {"트와일라잇", "뉴문", "이클립스", "브레이킹던", "아리랑", "젊은그들", "아프니까 청춘이다", "귀천", "태백산맥", "풀하우스"};
		String[] authors = {"스테파니메이어", "스테파니메이어", "스테파니메이어", "스테파니메이어", "조정래", "김동인", "김난도", "천상병", "조정래", "원수연"};
		Book[] books = new Book[10];
		
		for(int i=0; i<10; i++) {
			books[i] = new Book(i+1, titles[i], authors[i]);
		}
		
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요 : ");
		int bookNo = sc.nextInt();
		books[bookNo-1].rent();
		
		System.out.println("*****도서 정보 출력하기*****");
		for(Book b : books) {
			b.print();
		}
		
		sc.close();
	}
	
}
