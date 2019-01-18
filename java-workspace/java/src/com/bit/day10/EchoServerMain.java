package com.bit.day10;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 	[Server]
 	Construct
 		ServerSocket(int port)
 	Method
 		Socket accept() :
 			클라이언트의 요청을 받아들인 다음,
 			클라이언트와 연결된 소켓 클래스 객체를 반환
 		void close() :
 			서버 소켓을 닫는다
 */

public class EchoServerMain {

	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			// 서버 소켓 생성 시 포트 넘버 전달
			server = new ServerSocket(10000);
			System.out.println("클라이언트 말좀 해봐");
			
			Socket client = server.accept();	// 클라이언트 접속 대기
			System.out.println("접속 클라이언트의 정보 : [" + client.getInetAddress().getHostAddress() + "]");
			
			// 클라이언트에서 전송한 메세지를 받는 객체 (Input)
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			// 받은 메세지를 클라이언트에 재전송할 객체 (Output)
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);	// 모든 입력을 다 받을 수 있는 것, 동기식에서 모든 예외 처리
			/*
				동기	: 일정 신호를 받았을 때 다음 동작 하는 것
				비동기: 타겟의 상태와 관계없이 일방적인 동작 하는 것
			 */
			
			while(true) {
				String msg = br.readLine();
				System.out.println("받은 메세지 " + msg);
				if(msg == null) {
					System.out.println(client.getInetAddress() + " 연결을 종료합니다.");
					client.close();
					break;
				}
				// 재전송
				pw.println(msg);	// Output
				pw.flush();
			}
			
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
