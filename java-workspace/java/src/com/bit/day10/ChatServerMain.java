package com.bit.day10;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServerMain {
	// main도 실행 흐름오로서 main 쓰레드
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(10000);
			System.out.println("열려라 참깨");
			
			while(true) {
				Socket client = server.accept();
				Echo echoThread = new Echo(client);
				echoThread.start();
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

// Thread : 실행 흐름
// 접속한 클라이언트들 마다 새로운 실행 흐름을 제공(멀티 쓰레드)
class Echo extends Thread {
	private Socket socket;
	
	public Echo(Socket socket) {
		this.socket = socket;
	}
	
	// run()을 호출하여 Echo 쓰레드를 실행
	@Override
	public void run() {
		try {
			InetAddress client = socket.getInetAddress();
			System.out.println("System : [" + client + "] 님 등장!");
			
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String msg = null;
			while(true) {
				Set<String> msgSet = new HashSet<String>();
				msg = br.readLine();
				msgSet.add(msg);
				
				if(msg == null) {
					System.out.println("[" + client.getHostAddress() + "] 님 도망!");
					socket.close();
					break;
				}
				
				for(String s : msgSet) {
					System.out.println("[" + client.getHostAddress() + "] : " + s);
				}
				pw.println(msg);
				pw.flush();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}