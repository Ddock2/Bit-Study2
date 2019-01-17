package com.bit.day09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// file copy

public class FileMain02 {
	
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// file path (파일 경로)
			//	->기본 경로는 자신의 프로젝트 경로
			// 절대 경로 : 해당 파일이 가지는 고유한 경로
			// 상대 경로 : 기준으로부터 시작하는 파일 경로
			fis = new FileInputStream("iotest/good.png");	// file path
			fos = new FileOutputStream("iotest/good2.png");
			
			int data = -1;
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			System.out.println("복사 완료");
		}catch(FileNotFoundException fnfe){
			System.out.println("error : " + fnfe);
		}catch(IOException ex) {
			System.out.println("error : " + ex);
		}
		finally {
		
			try {
				if(fis != null) {
					fis.close();
				}
				if(fos != null) {
					fos.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
