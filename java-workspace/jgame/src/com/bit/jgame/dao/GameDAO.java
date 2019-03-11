package com.bit.jgame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.jgame.vo.GameVO;
import com.bit.util.ConnectionFactory;
import com.bit.util.JDBCClose;

public class GameDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private StringBuilder sql = null;
	
	/**
	 * 기록 입력시 번호 구하기
	 */
	public int getRankingNo() {
		int no = 0;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT seq_jgame_ranking_no.nextVal FROM dual ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			no = rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return no;
	}
	
	/**
	 * 게임 점수 등록
	 */
	public boolean writeRanking(GameVO gameVO) {
		boolean result = true;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" INSERT INTO jgame_ranking(no, id, item, score) ");
			sql.append("   VALUES(? ,?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, gameVO.getNo());
			pstmt.setString(2, gameVO.getId());
			pstmt.setString(3, gameVO.getItem());
			pstmt.setInt(4, gameVO.getScore());
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			result = false;
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return result;
	}

}
