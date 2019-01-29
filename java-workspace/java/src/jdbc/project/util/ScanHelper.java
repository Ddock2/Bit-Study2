package jdbc.project.util;

import java.util.Scanner;

public class ScanHelper {
	private Scanner sc = new Scanner(System.in);
	
	public String scanStr(String msg) {
		System.out.print(msg);
		String input = sc.nextLine();
		
		return input;
	}
	
	public int scanInt(String msg) {
		System.out.print(msg);
		int input = -1;
		String str = sc.nextLine();
		
		if(str.equals(""))
			return input;
		
		try {
			input = Integer.parseInt(str);
		}catch(NumberFormatException e) {
			System.out.println("숫자만 입력하세요");
			input = -2;
		}
		
		return input;
	}
	
}
