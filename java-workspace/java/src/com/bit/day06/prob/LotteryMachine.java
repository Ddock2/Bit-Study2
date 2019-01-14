package com.bit.day06.prob;

import java.util.Random;

public class LotteryMachine {
	private LotteryBall[] balls;
	private Random rand;
	
	public LotteryMachine() {
		balls = new LotteryBall[50];
		for(int i=0; i<50; i++) {
			balls[i] = new LotteryBall(i+1);
		}
		rand = new Random();
	}
	
	public int pickBall() {
		int ballNo;
		int tempNo;
				
		do {
			tempNo = rand.nextInt(50);
		}while(balls[tempNo] == null);
		ballNo = balls[tempNo].getBallNo();
		balls[tempNo] = null;
		
		System.out.println(ballNo + "번공");
		
		return ballNo;
	}
}
