package com.bit.day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMain05 {
	
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			// 기반 스트림
			fr = new FileReader("./src/com/bit/day09/FileMain01.java");
			fw = new FileWriter("iotest/FileMain01.java.txt");
			
			// 보조 스트림
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			/*
			String line = null;
			int index = 0;
			while((line = br.readLine()) != null) {
				System.out.print(++index);
				System.out.print(":");
				System.out.print(line);
				System.out.print("\n");	//String line 자체는 개행을 가지고 있지 않다.
			}
			*/
			long sTime = System.nanoTime();
			long eTime = 0;
			while(true) {
			// 필터 클래스 장착하지 않은 경우
				int data = fr.read();
				if(data == -1) break;
				fw.write(data);
				fw.flush();
				eTime = System.nanoTime();
				System.out.println("버퍼x 소요시간 : "+ (eTime - sTime) + "ns");

				sTime = System.nanoTime();
			// 필터 클래스 장착한 경우
				String line = br.readLine();
				if(line == null) break;
				bw.write(line + "\r\n");
				eTime = System.nanoTime();
				System.out.println("버퍼o 소요시간 : "+ (eTime - sTime) + "ns");
			}
			bw.flush();
			
			System.out.println("복사 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
