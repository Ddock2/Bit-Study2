package com.bit.login.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.util.ConnectionFactory;
import com.bit.util.JDBCClose;

public class LoginDAO {
	
	// TODO 로그인 (id, password 체크), 세션에 등록할 객체 반환
	
	public LoginVO login(LoginVO loginVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		LoginVO userVO = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" SELECT id, password, name, type ");
			sql.append("   FROM j_member ");
			sql.append("   WHERE id = ? AND password = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userVO = new LoginVO();
				userVO.setId(rs.getString("id"));
				userVO.setPassword(rs.getString("password"));
				userVO.setName(rs.getString("name"));
				userVO.setType(rs.getString("type"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return userVO;
	}
}
