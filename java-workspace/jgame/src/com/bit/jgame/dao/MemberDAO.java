package com.bit.jgame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.jgame.vo.FileVO;
import com.bit.jgame.vo.MemberVO;
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
			
			sql.append(" INSERT INTO jgame_member(id, password, name) ");
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
	 * 프로필 이미지 파일 입력
	 */
	public void insertFile(FileVO fileVO) {
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" INSERT INTO jgame_profile_img(id, profile_img_ori_name, profile_img_save_name) ");
			sql.append(" VALUES(?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, fileVO.getId());
			pstmt.setString(2, fileVO.getFile_ori_name());
			pstmt.setString(3, fileVO.getFile_save_name());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
	/**
	 *  로그인
	 */
	public MemberVO login(MemberVO memberVO) {
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT m.name name, TO_CHAR(m.reg_date, 'YYYY-MM-DD') reg_date, p.profile_img_save_name as profile_img_save_name ");
			sql.append("   FROM jgame_member m LEFT OUTER JOIN jgame_profile_img p ");
			sql.append("   	 ON m.id = p.id ");
			sql.append("   WHERE m.id = ? AND m.password = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				memberVO.setName(rs.getString("name"));
				String reg_date = rs.getString("reg_date");
				String[] reg_dates = reg_date.split("-");
				memberVO.setReg_date(reg_dates[0] + "년 " + reg_dates[1] + "월 " + reg_dates[2] + "일");
				memberVO.setProfile_img_save_name(rs.getString("profile_img_save_name"));
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
	
	/**
	 * 아이디 중복 확인
	 */
	public boolean checkID(String id) {
		boolean result = false;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT count(*) as num ");
			sql.append("   FROM jgame_member ");
			sql.append("   WHERE id = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = (rs.getInt("num") == 0) ? true : false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return result;
		
	}
	
	/**
	 * 아이디로 프로필 이미지 파일 조회
	 */
	public FileVO selectFileById(String id) {
		FileVO profile_img = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT file_ori_name, file_save_name ");
			sql.append("   FROM mysite_board_file ");
			sql.append("   WHERE id = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String file_ori_name = rs.getString("file_ori_name");
				String file_save_name = rs.getString("file_save_name");
				
				profile_img = new FileVO(id, file_ori_name, file_save_name);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return profile_img;
	}
	
	/**
	 * 개인 정보 수정
	 */
	public void updateUserInfo(MemberVO memberVO) {
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" UPDATE jgame_member ");
			sql.append("    SET password = ?, ");
			sql.append("        name = ? ");
			sql.append("    WHERE id = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, memberVO.getPassword());
			pstmt.setString(2, memberVO.getName());
			pstmt.setString(3, memberVO.getId());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
	/**
	 * 프로필 이미지 파일 삭제
	 */
	public void deleteProfileImg(String file_save_name) {
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" DELETE FROM jgame_profile_img ");
			sql.append("    WHERE profile_img_save_name = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, file_save_name);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
	
}
