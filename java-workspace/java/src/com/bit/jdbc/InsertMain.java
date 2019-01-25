package com.bit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bit.util.JDBCClose;

public class InsertMain {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1단계 : 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩...");
			
			// 2단계 : 연결 객체 얻기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 확인 : " + con);
			
			// 3단계 : sql 생성
			String sql = "";
			sql += "INSERT INTO super_board(no, title, writer) ";
			sql += "  VALUES (seq_super_board_no.nextVal, ?, ?) ";  // ? : 입력받은 값을 쿼리로 채움
			
			Scanner sc = new Scanner(System.in);
			System.out.print("제목 입력 : ");
			String title = sc.nextLine();
			System.out.print("이름 입력 : ");
			String writer = sc.nextLine();
			
			// 4단계 : statement 객체로 질의 생성 및 수행
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);			// ? 에 입력 값 set
			pstmt.setString(2, writer);
			
			// 5단계 : SQL 실행
			int rCnt = pstmt.executeUpdate();
			System.out.println("총 " + rCnt + "개의 행이 추가되었습니다.");
			
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
}
