package com.bit.mysite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bit.mysite.vo.BoardVO;
import com.bit.mysite.vo.FileVO;
import com.bit.util.ConnectionFactory;
import com.bit.util.JDBCClose;

public class BoardDAO {
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private StringBuilder sql = null;
	
	/**
	 * 게시글 전체 조회
	 */
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT no, title, writer, content, TO_CHAR(reg_date, 'YYYY-MM-DD') reg_date, view_cnt ");
			sql.append("   FROM mysite_board ");
			sql.append("   ORDER BY no DESC ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String reg_date = rs.getString("reg_date");
				int view_cnt = rs.getInt("view_cnt");
				
				BoardVO board = new BoardVO(no, title, writer, content, reg_date, view_cnt);
				
				boardList.add(board);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return boardList;
	}

	/**
	 * 글번호로 게시글 조회
	 */
	public BoardVO selectBoardByNo(int no) {
		BoardVO boardVO = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT title, writer, content, TO_CHAR(reg_date, 'YYYY-MM-DD') reg_date, view_cnt ");
			sql.append("   FROM mysite_board ");
			sql.append("   WHERE no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String reg_date = rs.getString("reg_date");
				int view_cnt = rs.getInt("view_cnt");
				
				boardVO = new BoardVO(no, title, writer, content, reg_date, view_cnt);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return boardVO;
	}
	
	/**
	 * 글번호로 첨부파일 조회
	 */
	public List<FileVO> selectFileByNo(int no) {
		List<FileVO> fileList = new ArrayList<>();
		
		return fileList;
	}
	
	/**
	 * 게시글 작성
	 */
	public boolean write(BoardVO boardVO) {
		boolean result = true;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" INSERT INTO mysite_board(no, title, writer, content) ");
			sql.append("   VALUES(seq_mysite_board_no.nextVal ,?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getWriter());
			pstmt.setString(3, boardVO.getContent());
			
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
	 * 글번호로 게시글 삭제
	 */
	public boolean deleteByNo(BoardVO boardVO) {
		boolean result = true;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" DELETE FROM mysite_board ");
			sql.append("   WHERE no = ? AND writer = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardVO.getNo());
			pstmt.setString(2, boardVO.getWriter());
			
			if(pstmt.executeUpdate() == 0) {
				result = false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			result = false;
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return result;
	}
	
	/**
	 * 게시물 조회수 올리기
	 */
	public void upViewCnt(int no) {
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" UPDATE mysite_board ");
			sql.append("    SET view_cnt = view_cnt + 1 ");
			sql.append("    WHERE no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
}
