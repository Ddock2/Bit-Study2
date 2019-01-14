package com.bit.day06.prob;

public class LotteryTicket {
	private int[] selectedNums;
	
	public LotteryTicket() {
		selectedNums = new int[7];
	}
	
	public void setSelectedNo(int seq, int no) {
		selectedNums[seq] = no;
		if(seq == 6) {
			new Ascending().ascending(selectedNums);
		}
	}
	
	public int[] getSelectedNums() {
		return selectedNums;
	}
	
	public void ticketInfo() {
		System.out.println("------------------");
		System.out.println("** Lotto Ticket **");
		for(int no : selectedNums) {
			System.out.print(no + " ");
		}
		System.out.println();
		System.out.println("------------------");		
	}
}
