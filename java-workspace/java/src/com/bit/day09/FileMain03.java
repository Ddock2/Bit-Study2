package com.bit.day09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMain03 {
	
	public static void main(String[] args) {
		write();
		read();
	}
	
	
	public static void write() {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("iotest/write.txt");
			dos = new DataOutputStream(fos);
			
			int num = 97;
			fos.write(num);			// byte타입으로 1byte 출력, 97 -> a
			dos.writeInt(num);		// 정수타입으로 4byte 출력,  숫자 97이 아니라 4byte 정수형태
			dos.writeDouble(3.14);
//			dos.writeChar('A');
			
			// 파일 데이터를 작성한 사람만 알고 있다
			// 작성 방식을 알고 있어야 Input이 가능하다
			
			System.out.println("저장 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(dos != null)
					dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void read() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("iotest/write.txt");
			dis = new DataInputStream(fis);
			
			System.out.println("file read...");
			int c = fis.read();
			System.out.println(c);
			
			int i = dis.readInt();
			double d = dis.readDouble();
			char ch = dis.readChar();
			
			// 파일의 끝을 넘어가서 읽으려고 하면 EOFException 발생
			
			System.out.printf("정수 : %d \n실수 : %f \n문자 : %c", i, d, ch);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(dis != null)
					dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
