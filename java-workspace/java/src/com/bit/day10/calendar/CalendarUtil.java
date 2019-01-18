package com.bit.day10.calendar;

import java.util.Calendar;

public class CalendarUtil {
	// 특정 연도 조회
	public void showDayByYear(int year) {
		for(int month = 1; month <=12; month++) {
			showDayByMonth(year, month);
		}
	}
	
	//특정 월 조회
	public void showDayByMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		
		c.set(year,  month -1, 1);
		
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int week = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(year + "년 " + month +"월");
		showDay(lastDay, week);
	}
	
	public void showDay(int lastDay, int week) {
		System.out.println("----------------------------------------------------");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("----------------------------------------------------");
		
		int lineCnt = 0;
		for(int i=1; i<week; i++) {
			System.out.print("\t");
			lineCnt++;
		}
		for(int day=1; day<=lastDay; day++) {
			System.out.print(day + "\t");
			if(++lineCnt % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println();
	}
}
