package com.bit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.util.JDBCClose;

/*
 	[테이블 생성]
 	CREATE TABLE super_board(
 		no			NUMBER(6) PRIMARY KEY,
 		title		VARCHAR(200) NOT NULL,
 		writer		VARCHAR(40) NOT NULL,
 		reg_date	DATE DEFAULT SYSDATE
 	);
 	
 	[시퀀스 생성]
 	CREATE SEQUENCE seq_super_board_no;
 */

public class SelectMain {
	
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
			
			con = DriverManager.getConnection(url,  user, password);
			System.out.println("연결 확인 : " + con);
			
			// 3단계 : SQL 생성
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, ");
			sql.append("	   to_char(reg_date, 'yyyy-mm-dd') reg_date ");
			sql.append("  from super_board ");
			
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			// ResultSet (결과 셋)
			// executeQuery의 결과를 기억하기 위한 클래스
			//   next() 메소드를 활용하여 값을 가져온다
			//   만약, 데이터가 없다면 false 반환
			
			while(rs.next()) {		// 받아온 결과가 존재시 루프
				// 컬럼의 ALIAS 이름으로 받아라
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				
				System.out.println("------------------------");
				System.out.println("글번호 : " + no);
				System.out.println("글제목 : " + title);
				System.out.println("작성자 : " + writer);
				System.out.println("등록일 : " + regDate);
				System.out.println("------------------------");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
}
