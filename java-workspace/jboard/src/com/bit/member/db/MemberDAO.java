package com.bit.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bit.util.ConnectionFactory;
import com.bit.util.JDBCClose;

public class MemberDAO {
	
	/**
	 * 전체 회원 조회
	 */
	public List<MemberVO> selectAllMember(){
		Connection con = null;
		PreparedStatement pstmt = null;
		List<MemberVO> list = new ArrayList<>();
		
		try {
			con = new ConnectionFactory().getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT id, name, password, tel1, tel2, tel3 ");
			sql.append("        , type, reg_date ");
			sql.append("   FROM j_member ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setTel1(rs.getString("tel1"));
				member.setTel2(rs.getString("tel2"));
				member.setTel3(rs.getString("tel3"));
				member.setType(rs.getString("type"));
				member.setReg_date(rs.getString("reg_date"));
				
				list.add(member);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return list;
	}
	
	/**
	 * 아이디로 조회
	 */
	public MemberVO selectById(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		MemberVO member = new MemberVO();
		
		try {
			con = new ConnectionFactory().getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT name, password, tel1, tel2, tel3 ");
			sql.append("        , email_id, email_domain, post ");
			sql.append("        , basic_addr , detail_addr, type, reg_date ");
			sql.append("   FROM j_member ");
			sql.append("   WHERE id = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setId(id);
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setTel1(rs.getString("tel1"));
				member.setTel2(rs.getString("tel2"));
				member.setTel3(rs.getString("tel3"));
				member.setEmail_id(rs.getString("email_id"));
				member.setEmail_domain(rs.getString("email_domain"));
				member.setPost(rs.getString("post"));
				member.setBasic_addr(rs.getString("basic_addr"));
				member.setDetail_addr(rs.getString("detail_addr"));
				member.setType(rs.getString("type"));
				member.setReg_date(rs.getString("reg_date"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return member;
	}
}
