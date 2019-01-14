package com.bit.day06.prob;

public class Ascending {
	public void ascending(int[] selectedNums) {
		int temp;
		
		for(int i=0; i<selectedNums.length; i++) {
			for(int j=i+1; j<selectedNums.length; j++) {
				if(selectedNums[i] > selectedNums[j]) {
					temp = selectedNums[i];
					selectedNums[i] = selectedNums[j];
					selectedNums[j] = temp;
				}
			}
		}
	}
}
