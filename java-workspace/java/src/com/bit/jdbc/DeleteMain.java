package com.bit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.bit.util.ConnectionFactory;
import com.bit.util.JDBCClose;

public class DeleteMain {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩...");
			
			con = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("delete super_board ");
			sql.append("  where no = ? ");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("삭제할 글번호 입력 : ");
			int no = Integer.parseInt(sc.nextLine());
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			int rCnt = pstmt.executeUpdate();
			System.out.println("총 " + rCnt + "개의 행이 삭제되었습니다.");
			
			sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
}
