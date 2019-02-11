package com.bit.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bit.util.ConnectionFactory;
import com.bit.util.JDBCClose;

public class BoardDAO {
	// TODO 게시판 등록, 조회, 수정, 조회수, 파일 업로드, 파일 정보
	
	/**
	 * 게시글 등록 시 사용할 번호
	 */
	public int selectNo() {
		Connection con = null;
		PreparedStatement pstmt = null;
		int no = 0;
		
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" SELECT seq_j_board_no.nextVal FROM dual ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			no = rs.getInt(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return no;
	}
	
	/**
	 * 게시글 저장
	 */
	public void insert(BoardVO boardVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" INSERT INTO j_board(no, title, writer, content) ");
			sql.append(" VALUES(?, ?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setInt(index++, boardVO.getNo());
			pstmt.setString(index++, boardVO.getTitle());
			pstmt.setString(index++, boardVO.getWriter());
			pstmt.setString(index++, boardVO.getContent());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		
	}

	/**
	 * 첨부파일 저장
	 */
	public void insertFile(FileVO fileVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" INSERT INTO j_board_file(no, board_no, file_ori_name, file_save_name, file_size) ");
			sql.append(" VALUES(seq_j_board_file_no.nextVal, ?, ?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, fileVO.getBoard_no());
			pstmt.setString(2, fileVO.getFile_ori_name());
			pstmt.setString(3, fileVO.getFile_save_name());
			pstmt.setInt(4, fileVO.getFile_size());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
	/**
	 * 전체 게시글 조회
	 */
	public List<BoardVO> selectAllBoard(){
		List<BoardVO> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" SELECT no, title, writer, content, view_cnt, reg_date ");
			sql.append("   FROM j_board ");
			sql.append("   ORDER BY no DESC ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setView_cnt(rs.getInt("view_cnt"));
				board.setReg_date(rs.getString("reg_date"));
				
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return list;
	}
	
	/**
	 *  글번호로 게시글 조회
	 */
	public BoardVO selectByNo(int no){
		BoardVO board = new BoardVO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" SELECT no, title, writer, content, view_cnt, reg_date ");
			sql.append("   FROM j_board ");
			sql.append("   WHERE no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setView_cnt(rs.getInt("view_cnt"));
				board.setReg_date(rs.getString("reg_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return board;
	}
	
	/**
	 *  글번호로 첨부파일명 조회
	 */
	public List<FileVO> selectFileByNo(int board_no){
		List<FileVO> files = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" SELECT no, file_ori_name, file_save_name, file_size ");
			sql.append("   FROM j_board_file ");
			sql.append("   WHERE board_no = ? ");
			sql.append("   ORDER BY no ASC ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, board_no);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				FileVO file = new FileVO();
				file.setNo(rs.getInt("no"));
				file.setFile_ori_name(rs.getString("file_ori_name"));
				file.setFile_save_name(rs.getString("file_save_name"));
				file.setFile_size(rs.getInt("file_size"));
				
				files.add(file);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return files;
	}
}
