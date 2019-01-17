package com.bit.day09;

import java.io.FileInputStream;
import java.io.FileReader;

public class FileMain04 {
	
	public static void main(String[] args) {
		FileReader fr = null;
		FileInputStream fis = null;
		
		try {
			fr = new FileReader("iotest/hello.txt");
			
			int data = -1;
			int count = 0;
			while((data = fr.read()) != -1) {
				System.out.print((char)data);
				count++;
			}
			System.out.println();
			System.out.println("읽은 횟수 : " + count);
			
			fis = new FileInputStream("iotest/hello.txt");
			count = 0;
			while((data = fis.read()) != -1) {
				System.out.print((char)data);
				count++;
			}
			System.out.println();
			System.out.println("읽은 횟수 : " + count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				if(fr != null) {
					fr.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
