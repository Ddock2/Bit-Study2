package com.bit.jgame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bit.jgame.vo.BoardVO;
import com.bit.jgame.vo.CommentVO;
import com.bit.jgame.vo.FileVO;
import com.bit.util.ConnectionFactory;
import com.bit.util.JDBCClose;

public class BoardDAO {
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private StringBuilder sql = null;
	
	//--------------------------------SELECT--------------------------------
	/**
	 * 글 입력시 사용할 글번호 조회
	 */
	public int getBoardNo() {
		int no = 0;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT seq_mysite_board_no.nextVal FROM dual ");
			
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
	 * 페이지로 게시글 리스트 조회
	 */
	public List<BoardVO> selectBoardListByPage(int page) {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT * ");
			sql.append("   FROM ( ");
			sql.append(" 		SELECT rownum r, no, title, writer, content, TO_CHAR(reg_date, 'YYYY-MM-DD') reg_date, view_cnt ");
			sql.append(" 		  FROM mysite_board ");
			sql.append(" 		  ORDER BY no DESC ");
			sql.append(" 		) ");
			sql.append("   WHERE r > ? AND r <= ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, (page-1)*10);
			pstmt.setInt(2, page*10);
			
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
	 * 게시글 검색 조회
	 */
	public List<BoardVO> selectBoardListByKeyword(String searchType, String keyword, int page) {
		List<BoardVO> boardList = new ArrayList<>();
		keyword = "%" + keyword + "%";
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT * ");
			sql.append("   FROM ( ");
			sql.append(" 		SELECT rownum r, no, title, writer, content, TO_CHAR(reg_date, 'YYYY-MM-DD') reg_date, view_cnt ");
			sql.append(" 		  FROM mysite_board ");
			if(searchType.equals("title+content")) {
				sql.append(" 	  WHERE title LIKE ? OR content LIKE ? ");
			}else {
				sql.append(" 	  WHERE " + searchType + " LIKE ? ");
			}
			sql.append(" 		  ORDER BY no DESC ");
			sql.append(" 		) ");
			sql.append("   WHERE r > ? AND r <= ? ");
			
			int index = 1;
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(index++, keyword);
			if(searchType.equals("title+content"))
				pstmt.setString(index++, keyword);
			pstmt.setInt(index++, (page-1)*10);
			pstmt.setInt(index++, page*10);
			
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
	 * 전체 게시판 마지막 페이지 조회
	 */
	public int selectBoardLastPage(int boardCntInOnePage) {
		int lastPage = 1;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT COUNT(*) FROM mysite_board ");
			
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
	
	/**
	 * 검색 시 게시판 마지막 페이지 조회
	 */
	public int selectBoardLastPageWithKeyword(String searchType, String keyword, int boardCntInOnePage) {
		int lastPage = 1;
		
		keyword = "%" + keyword + "%";
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT COUNT(*) ");
			sql.append("   FROM mysite_board ");
			if(searchType.equals("title+content")) {
				sql.append(" WHERE title LIKE ? OR content LIKE ? ");
			}else {
				sql.append(" WHERE " + searchType + " LIKE ? ");
			}
			sql.append("   ORDER BY no DESC ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, keyword);
			if(searchType.equals("title+content"))
				pstmt.setString(2, keyword);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				lastPage = rs.getInt(1);
				lastPage = (lastPage % boardCntInOnePage == 0) ? lastPage/boardCntInOnePage : (lastPage/boardCntInOnePage + 1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			lastPage = 1;
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return lastPage;
	}
	
	/**
	 * 글번호로 첨부파일 조회
	 */
	public List<FileVO> selectFileByBoardNo(int board_no) {
		List<FileVO> fileList = new ArrayList<>();
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT file_ori_name, file_save_name, file_size ");
			sql.append("   FROM mysite_board_file ");
			sql.append("   WHERE board_no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, board_no);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String file_ori_name = rs.getString("file_ori_name");
				String file_save_name = rs.getString("file_save_name");
				int file_size = rs.getInt("file_size");
				
				FileVO file = new FileVO(board_no, file_ori_name, file_save_name, file_size);
				
				fileList.add(file);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return fileList;
	}
	
	/**
	 * 게시글 번호로 댓글 조회
	 */
	public List<CommentVO> selectCommentByBoardNo(int board_no) {
		List<CommentVO> commentList = new ArrayList<>();
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" SELECT writer, content, TO_CHAR(reg_date, 'YYYY/MM/DD HH24:MI:SS') reg_date ");
			sql.append("   FROM mysite_comment ");
			sql.append("   WHERE board_no = ? ");
			sql.append("   ORDER BY no desc ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, board_no);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String reg_date = rs.getString("reg_date");
				
				CommentVO comment = new CommentVO(writer, content, reg_date);
				
				commentList.add(comment);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return commentList;
	}
	
	
	//--------------------------------INSERT--------------------------------
	/**
	 * 게시글 작성
	 */
	public boolean write(BoardVO boardVO) {
		boolean result = true;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" INSERT INTO mysite_board(no, title, writer, content) ");
			sql.append("   VALUES(? ,?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardVO.getNo());
			pstmt.setString(2, boardVO.getTitle());
			pstmt.setString(3, boardVO.getWriter());
			pstmt.setString(4, boardVO.getContent());
			
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
	 * 첨부파일 정보 입력
	 */
	public void insertFile(FileVO fileVO) {
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" INSERT INTO mysite_board_file(no, board_no, file_ori_name, file_save_name, file_size) ");
			sql.append(" VALUES(seq_mysite_board_file_no.nextVal, ?, ?, ?, ?) ");
			
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
	
	public boolean insertComment(CommentVO comment) {
		boolean result = true;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" INSERT INTO mysite_comment(no, board_no, writer, content) ");
			sql.append("   VALUES(seq_mysite_comment_no.nextVal ,?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, comment.getBoard_no());
			pstmt.setString(2, comment.getWriter());
			pstmt.setString(3, comment.getContent());
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			result = false;
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return result;
	}
	
	//--------------------------------DELETE--------------------------------
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
	 * 첨부파일 정보 삭제
	 */
	public void deleteFileByBoardNo(int boardNo) {
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" DELETE FROM mysite_board_file ");
			sql.append("   WHERE board_no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
	/**
	 * 게시글 번호로 댓글 삭제
	 */
	public void deleteCommentByBoardNo(int boardNo) {
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append(" DELETE FROM mysite_comment ");
			sql.append("   WHERE board_no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, boardNo);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}

	//--------------------------------UPDATE--------------------------------
	/**
	 * 게시물 조회수 올리기
	 */
	public void upViewCnt(int no, String id) {
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" UPDATE mysite_board ");
			sql.append("    SET view_cnt = view_cnt + 1 ");
			if(!id.equals("")) {
				sql.append("WHERE no = ? AND writer != ? ");
			}else {
				sql.append("WHERE no = ? " );
			}
				
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			if(!id.equals(""))
				pstmt.setString(2, id);
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
	}
	
	/**
	 * 게시글 수정
	 */
	public boolean updateBoard(BoardVO boardVO) {
		boolean result = true;
		
		try {
			con = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append(" UPDATE mysite_board ");
			sql.append("    SET title = ?, content = ? ");
			sql.append("    WHERE no = ? ");
				
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getContent());
			pstmt.setInt(3, boardVO.getNo());
			
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
