package com.bit.day10;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerMain {
	
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			// 서버 소켓 생성 시 포트 넘버 전달
			server = new ServerSocket(10000);
			System.out.println("어플리케이션 서버 구동 중...");
			
			Socket client = server.accept();	// 클라이언트 접속 대기
			String msg = "어서옵쇼";				// server -> client
			
			OutputStream os = client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(msg);
			dos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(server != null)
					server.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
