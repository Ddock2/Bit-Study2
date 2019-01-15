package com.bit.day07;

import java.io.FileReader;
//import java.io.*; // java.io 이후에 있는 모든 클래스를 포함

/*
 * 예외 처리 구문
 * try~catch
 * 
 * try {
 * 		// 예외가 발생할 수 있는 구문
 * } catch() {
 * 		// 예외가 발생하면 실행할 구문
 * }
 */

public class ExceptionMain {
	
	public static void main(String[] args) {
		
//		System.out.println(10/0); // unchecked exception
		// 무조건 예외 발생하는 구문인데, try~catch 없이도 가능
		try {
			System.out.println(10/0);
		}catch(ArithmeticException ae) {
			ae.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader("abc.txt");	// checked exception
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// try~catch~finally
		/*
		 * try {
		 * }catch() {
		 * } finally {
		 * 	// try 영역에 진입하면 무조건 실행되는 영역
		 */
		
		try {
			System.out.println(1);
			System.out.println(2/0);
			System.out.println(3);
		}catch(Exception e) {
			System.out.println(4);
		}finally {
			System.out.println(5);
		}
		System.out.println(6);
		
		// multi catch
		try {
			String str = "abc";
			System.out.println(str.charAt(1));
			
			String[] strArr = {"a"};
			System.out.println(strArr[1]);
			
			FileReader fr = new FileReader("abc.txt");
			fr.close();
		}/*catch(ArrayIndexOutOfBoundsException aie) {
			aie.printStackTrace();
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}*/catch(Exception e) {	// 묵시적 형변환
			e.printStackTrace();
		}
	}
	
}
