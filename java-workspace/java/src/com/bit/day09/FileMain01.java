package com.bit.day09;

import java.io.InputStream;
import java.io.InputStreamReader;

/*
	1. 스트림을 연다
	2. 작업을 수행
	3. 스트림을 닫는다
 */

public class FileMain01 {
	
	public static void main(String[] args) {
	/*
		// 1
		InputStream is = System.in;
		
		// 2
		System.out.println("입력하쇼");
		byte[] bytes = new byte[20];	// 문자 하나하나를 저장할 배열
		
		try {
			while(true) {
				if(is.read(bytes) == -1) {	// -1 : EOF(End Of File)
					break;
				}
				
				for(byte b : bytes) {
					System.out.print((char)b);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 3
			if(is != null) {
				try {
					is.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	*/
		// 한글을 입력받기 위해,
		// 문자 스트림을 바꾸기 위한 필터 클래스
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		
		System.out.println("입력하쇼");
		try {
			while(true) {
				int c = isr.read();
				if(c == -1) { break; }
				System.out.print((char) c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(isr != null) {
					isr.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				if(is != null) {
					is.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
