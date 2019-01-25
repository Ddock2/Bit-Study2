package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bit.util.JDBCClose;

import board.util.ConnectionFactory;
import board.vo.BoardVO;

public class BoardDAO {
	// 데이터 처리를 위한 보드 객체 저장 리스트
	private List<BoardVO> boardList = new ArrayList<>();
	
	/**
	 * 게시물 등록 기능
	 */
	public int insertBoard(BoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertCnt = 0;
		
		try {
			con = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into super_board(no, title, writer) ");
			sql.append(" values(seq_super_board_no.nextVal, ?, ? ) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			
			insertCnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return insertCnt;
	}
	
	/**
	 * 게시판 수정 기능
	 */
	public int updateBoard(BoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateCnt = 0;
		
		try {
			con = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("update super_board ");
			sql.append("  set title = ? ");
			sql.append("  where no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setInt(2, board.getNo());
			
			updateCnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return updateCnt;
	}
	
	/**
	 * 게시판 삭제 기능
	 */
	public int deleteBoard(BoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int deleteCnt = 0;
		
		try {
			con = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("delete super_board ");
			sql.append("  where no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getNo());
			
			deleteCnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(con, pstmt);
		}
		
		return deleteCnt;
	}
	
	/**
	 *  게시판 번호 조회 기능
	 */
	public BoardVO selectOneBoard(BoardVO board) throws Exception{
		
		Connection con = new ConnectionFactory().getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, ");
		sql.append("  to_char(reg_date, 'yyyy-mm-dd') reg_date ");
		sql.append("  from super_board ");
		sql.append("  where no = ? ");
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setInt(1, board.getNo());
		
		ResultSet rs = pstmt.executeQuery();
		if(!rs.next()) return null;
		
		int no = rs.getInt("no");
		String title = rs.getString("title");
		String writer = rs.getString("writer");
		String regDate = rs.getString("reg_date");
		
		BoardVO vo = new BoardVO(no, title, writer, regDate);
		JDBCClose.close(con, pstmt);
		
		return vo;
	}
	
	/**
	 *  게시판 전체 조회
	 */
	public List<BoardVO> selectBoard() throws Exception{
		boardList.clear();
		
		Connection con = new ConnectionFactory().getConnection();
	
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, ");
		sql.append("  to_char(reg_date, 'yyyy-mm-dd') reg_date ");
		sql.append("  from super_board ");
		sql.append("  order by no asc ");
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String regDate = rs.getString("reg_date");
			BoardVO vo = new BoardVO(no, title, writer, regDate);
			
			boardList.add(vo);
		}
		
		JDBCClose.close(con, pstmt);
		return boardList;
	}
	
}
