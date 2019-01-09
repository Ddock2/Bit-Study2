package com.bit.day03.prob;

import java.util.Random;
import java.util.Scanner;

/*
 	1-100까지의 임의의 수를 가진 카드를 한장 숨기고 이 카드의 수를 맞추는 high/low 게임
 	게임 반복하기 위해 y/n이라 묻고 n인 경우 종료
 */

public class Prob5 {
	
	public static void main(String[] args) {
		Random r = new Random();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {			
			int randomNum = r.nextInt(100) + 1;
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			
			int max = 100, min = 1, cnt = 1;
			while(true) {
				System.out.println(min + "-" + max);
				System.out.print(cnt++ + ">>");
				int ans = scanner.nextInt();
				scanner.nextLine();
				
				if(ans>max || ans<min) {
					System.out.println("범위내로 입력해 주세요");
					continue;
				}
				
				if(randomNum == ans) {
					System.out.println("맞았습니다.");
					break;
				}else if(randomNum < ans){
					System.out.println("더 낮게");
					max = ans;
				}else {
					System.out.println("더 높게");
					min = ans;
				}
				
				
			}
			
			System.out.print("다시 하시겠습니까(y/n)>>");
			String answer = scanner.next();
			scanner.nextLine();
			if(answer.equals("n")) {
				break;
			}
		}
		
		scanner.close();
	}
	
}
