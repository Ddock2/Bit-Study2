package com.bit.jgame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * 전체 기록 조회
	 */
	public List<GameVO> selectMoleGameRankingList(int page) {
		List<GameVO> recordList = new ArrayList<>();
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT * ");
			sql.append("   FROM ( ");			
			sql.append(" 		SELECT rownum r, s.* ");
			sql.append(" 		  FROM ( ");
			sql.append(" 				SELECT r.no, r.id, r.item, r.score, p.profile_img_save_name ");
			sql.append(" 				  FROM jgame_ranking r LEFT OUTER JOIN jgame_profile_img p ");
			sql.append("					ON r.id = p.id ");
			sql.append(" 				  ORDER BY score DESC ");
			sql.append(" 				) s ");
			sql.append(" 	  ) ");
			sql.append("   WHERE r > ? AND r <= ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, (page-1)*10);
			pstmt.setInt(2, page*10);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("r");
				String id = rs.getString("id");
				String item = rs.getString("item");
				int score = rs.getInt("score");
				String profile_img_save_name = rs.getString("profile_img_save_name");
				if(profile_img_save_name == null) {
					profile_img_save_name = "null-profile-image.png";
				}
				
				GameVO record = new GameVO(no, id, item, score, profile_img_save_name);
				
				recordList.add(record);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return recordList;
	}
	
	/**
	 * 기록 마지막 페이지 조회
	 */
	public int selectRankingLastPage(int boardCntInOnePage) {
		int lastPage = 1;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT COUNT(*) FROM jgame_ranking ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				lastPage = rs.getInt(1);
				lastPage = (lastPage % boardCntInOnePage == 0) ? lastPage/boardCntInOnePage : (lastPage/boardCntInOnePage + 1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			lastPage = 1;
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return lastPage;
	}

}
