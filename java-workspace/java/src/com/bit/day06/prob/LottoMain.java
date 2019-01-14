package com.bit.day06.prob;

import java.util.Scanner;

public class LottoMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LotteryTicket ticket = new LotteryTicket();
		new LuckyMan().buyTicket(sc, ticket);
		
		LotteryMachine lm = new LotteryMachine();
		int[] winNums = new int[7];
		
		for(int i=0; i<winNums.length; i++) {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.print((i+1) + "번째 공은 ");
			winNums[i] = lm.pickBall();
		}
		new Ascending().ascending(winNums);
		printWinnerNumber(winNums);
		printResult(ticket.getSelectedNums(), winNums);
		
		sc.close();
	}
	
	
	public static void printWinnerNumber(int[] winNums) {
		System.out.println("------------------");
		System.out.println("* Winner Number *");
		for(int no : winNums) {
			System.out.print(no + " ");
		}
		System.out.println();
		System.out.println("------------------");
	}
	
	public static void printResult(int[] selNums, int[] winNums) {
		int sameNums = 0;
		
		for(int sn : selNums) {
			for(int wn : winNums) {
				if(sn == wn)
					sameNums++;
			}
		}
		switch(sameNums) {
			case 7:
				System.out.println("1등!!!!!");
				break;
			case 6:
				System.out.println("2등!!!");
				break;
			case 5:
				System.out.println("3등!");
				break;
			case 4:
				System.out.println("4등");
				break;
			case 3:
				System.out.println("5등..");
				break;
			default : 
				System.out.println("꽝......");
		}
	}
}

class LuckyMan {
	public void buyTicket(Scanner sc, LotteryTicket ticket) {
		int no;
		
		for(int i=0; i<7; i++) {
			System.out.print((i+1) + "번째 번호 선택 : ");
			no = sc.nextInt();
			if(no<0 || no>50) {
				i--;
				System.out.println("1-50사이의 번호만 입력하세요");
			}else {
				int check = i;
				for(int j=0; j<check; j++) {
					if(ticket.getSelectedNums()[j] == no) {
						i--;
						System.out.println("이미 선택한 번호입니다");
						break;
					}
				}
				if(check == i) {
					ticket.setSelectedNo(i, no);
				}
			}
		}
		ticket.ticketInfo();
	}
}