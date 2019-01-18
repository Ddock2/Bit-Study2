package com.bit.day10;

import java.util.Calendar;

public class CalenderMain {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		printDate(calendar);
		
		calendar.set(1971, 12, 18);
		calendar.add(Calendar.DATE, -1000);
		printDate(calendar);
		
		calendar = Calendar.getInstance();
		System.out.println(calendar.DAY_OF_WEEK);
	}
	
	public static void printDate(Calendar c) {
		String[] days = {"일", "월", "화", "수", "목", "금", "토"};
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int day = c.get(Calendar.DAY_OF_WEEK);	// 1(일) ~ 7(토)
		
		System.out.println(year + "년 "
							+ (month+1) + "월 "
							+ date + "일 "
							+ days[day-1] + "요일 "
							+ hour + ":"
							+ minute + ":"
							+ second);
	}
	
}
