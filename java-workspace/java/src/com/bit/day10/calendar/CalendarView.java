package com.bit.day10.calendar;

import java.util.Scanner;

public class CalendarView {
	private Scanner s = new Scanner(System.in);
	
	public void process() {
		int year;
		int month;
		
		CalendarUtil util = new CalendarUtil();
		
		while(true) {
			int key = getInput("조회할 항목 선택 -> [1]특정 연도 조회  [2]특정 월 조회  [3]종료");
			
			switch(key) {
			case 1 :
				year = getInput("연도를 입력 : ");
				util.showDayByYear(year);
				break;
			case 2: 
				year = getInput("연도를 입력 : ");
				month = getInput("월을 입력 : ");
				util.showDayByMonth(year, month);
				break;
			case 3: 
				System.out.println("종료");
				System.exit(0);
				break;
			default:
				System.out.println("잘못된 입력");
			}
		}
	}
	
	private int getInput(String msg) {
		System.out.println(msg);
		int num = s.nextInt();
		s.nextLine();
		return num;
	}
}
