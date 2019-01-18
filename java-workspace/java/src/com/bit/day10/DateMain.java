package com.bit.day10;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMain {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date now = new Date();
//		System.out.println(now);
		printDate(now);
		
		// 년, 월(0-11), 일
		Date d1 = new Date(2000, 8, 1); // deprecated -> 없어질 예정, 쓰지마라
		printDate(d1);
		
		// 년, 월(0-11), 일, 시간, 분
		Date d2 = new Date(2000, 8, 1, 12, 30);
		printDate(d2);
		
		// 년, 월(0-11), 일, 시간, 분, 초
		Date d3 = new Date(2000, 8, 1, 12, 30, 30);
		printDate(d3);
		
		// 1970년 1월 1일 00:00:00 부터 밀리세컨드 값
		long milliseconds = 24L * 60 * 60 * 1000 * 365 * 50;
		Date d4 = new Date(milliseconds);
		printDate(d4);
		printDate2(d4);
	}
	
	private static void printDate(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(sdf.format(d));
	}
	
	@SuppressWarnings("deprecation")
	private static void printDate2(Date d) {
		int year = d.getYear();
		int month = d.getMonth();
		int date = d.getDate();
		int hours = d.getHours();
		int minutes = d.getMinutes();
		int seconds = d.getSeconds();
		
		System.out.println((year+1900) + "년 "
							+ (month+1) + "월 "
							+ date + "일 "
							+ hours + ":"
							+ minutes + ":"
							+ seconds);
	}
}
