package com.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

// Connection 객체들을 미리 만들어 놓고 돌려막기
public class ConnectionPool {
	// 연결할 수 있는 최대 자원을 5개로 한정
	private static final int INIT_COUNT = 5;
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	
	// 사용가능한 Connection 객체들
	private static ArrayList<Connection> freeList = new ArrayList<>();
	// 사용중인 Connection 객체들
	private static ArrayList<Connection> usedList = new ArrayList<>();
	
	// freeList 담기는 Connection 객체들은 static 멤버, 어디서든 동일 주소를 참조한다.
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			for(int i=0; i<INIT_COUNT; i++) {
				freeList.add(DriverManager.getConnection(URL, "c##bit", "bit"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		// 사용가능한 Connection이 없으면 예외발생
		if(freeList.isEmpty()) {
			throw new Exception("사용 가능한 Connection이 남지 않았습니다.");
		}
		
		Connection con = freeList.remove(0);
		usedList.add(con);
		
		System.out.println("free Connection : " + freeList.size());
		System.out.println("used Connection : " + usedList.size());
		
		return con;
	}
	
	public static void close(Connection con) {
		usedList.remove(con);
		freeList.add(con);
	}
}
