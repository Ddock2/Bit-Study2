package com.bit.day02.exam;

import java.util.Scanner;

public class PowerOfTwo {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      
      System.out.print("승수 : ");
      int pow = sc.nextInt();
      
      // 2 제곱값을 구하는 while 반복문을 작성하시오
      int result = 1;
      int temp = pow;
      
      while(temp != 0) {
    	  result *= 2;
    	  temp--;
      }
      
      System.out.printf("2의 %d승은 %d입니다", pow, result);
      
      sc.close();

   }
}