package com.bit.day10;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class AppClientMain {
	
	public static void main(String[] args) {
		Socket client = null;
		try {
			client = new Socket("192.168.153.2", 10000);
			
			InputStream is = client.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			String msg = dis.readUTF();
			System.out.println("서버에서 보낸 메세지 : " + msg);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(client != null)
					client.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
