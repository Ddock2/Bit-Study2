package com.bit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bit.util.ConnectionFactory;
import com.bit.util.JDBCClose;

public class UpdateMain {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩");
			
			con = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE super_board ");
			sql.append("  SET title = ?, ");
			sql.append("      writer = ? ");
			sql.append("  WHERE no = ? ");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("수정할 글 번호 입력 : ");
			int no = Integer.parseInt(sc.nextLine());

			System.out.print("수정할 제목 입력 : ");
			String title = sc.nextLine();
			
			System.out.print("수정할 이름 입력 : ");
			String writer = sc.nextLine();
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, title);
			pstmt.setString(2,  writer);
			pstmt.setInt(3, no);
			
			int rCnt = pstmt.executeUpdate();
			System.out.println("총 " + rCnt + "개의 행이 수정되었습니다.");
			
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
}
