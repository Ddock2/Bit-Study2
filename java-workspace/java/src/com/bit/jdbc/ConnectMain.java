package com.bit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

// JDBC 연결 테스트

public class ConnectMain {
	
	public static void main(String[] args) {
		
		Connection con = null;
		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 사용자 정보
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "hr";
			
			con = DriverManager.getConnection(url,  user, password);
			
			System.out.println("연결 성공!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
