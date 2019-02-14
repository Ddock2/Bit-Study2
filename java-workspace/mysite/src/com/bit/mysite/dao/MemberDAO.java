package com.bit.mysite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.mysite.vo.MemberVO;
import com.bit.util.ConnectionFactory;
import com.bit.util.JDBCClose;

public class MemberDAO {
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private StringBuilder sql = null;
	
	/**
	 * 회원 가입
	 */
	public boolean join(MemberVO memberVO) {
		boolean result = true;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" INSERT INTO mysite_member(id, password, name) ");
			sql.append("   VALUES(?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			pstmt.setString(3, memberVO.getName());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return result;
	}
	
	/**
	 *  로그인
	 */
	public MemberVO login(MemberVO memberVO) {
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT name, TO_CHAR(reg_date, 'YYYY-MM-DD') reg_date ");
			sql.append("   FROM mysite_member ");
			sql.append("   WHERE id = ? AND password = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				memberVO.setName(rs.getString("name"));
				String reg_date = rs.getString("reg_date");
				String[] reg_dates = reg_date.split("-");
				memberVO.setReg_date(reg_dates[0] + "년 " + reg_dates[1] + "월 " + reg_dates[2] + "일");
			}else {
				memberVO = null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return memberVO;
	}
	
	
	
}
