package jdbc.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.project.util.ConnectionFactory;
import jdbc.project.util.JDBCClose;
import jdbc.project.vo.BookVO;

public class BookDAO {
	
	private ArrayList<BookVO> bookList = new ArrayList<BookVO>();
	
	/**
	 * DAO bookList 초기화
	 */
	public void daoDataClear() {
		bookList = new ArrayList<BookVO>();
	}
	
	/**
	 * 도서 추가
	 */
	public int insertBook(BookVO vo, long isbn) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = new ConnectionFactory().getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO book_table(isbn, title, author, price) ");
			sql.append("	   VALUES(?, ?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, isbn);
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getAuthor());
			pstmt.setInt(4, vo.getPrice());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.closPreparedStatement(pstmt);
			JDBCClose.closeConnection(con);
		}
		
		return result;
	}
	
	/**
	 * 도서 삭제
	 */
	public int deleteBook(long isbn) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = new ConnectionFactory().getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM book_table ");
			sql.append("	   WHERE isbn = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, isbn);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.closPreparedStatement(pstmt);
			JDBCClose.closeConnection(con);
		}
		
		return result;
	}
	
	/**
	 * 도서 목록
	 */
	public ArrayList<BookVO> viewBookAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT isbn, title, author, price, usable ");
			sql.append("  FROM book_table ");
			sql.append("  ORDER BY isbn asc ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int price = rs.getInt("price");
				int usable = rs.getInt("usable");
				BookVO vo = new BookVO(isbn, title, author, price, usable);
				
				bookList.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.closPreparedStatement(pstmt);
			JDBCClose.closeConnection(con);
		}
		
		return bookList;
	}
	
	/**
	 * ISBN으로 도서 검색
	 */
	public ArrayList<BookVO> viewBookByIsbn(long isbn) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT isbn, title, author, price, usable ");
			sql.append("  FROM book_table ");
			sql.append("  WHERE isbn = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setLong(1, isbn);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String isbn2 = rs.getString("isbn");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int price = rs.getInt("price");
				int usable = rs.getInt("usable");
				BookVO vo = new BookVO(isbn2, title, author, price, usable);
				
				bookList.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.closPreparedStatement(pstmt);
			JDBCClose.closeConnection(con);
		}
		
		return bookList;
	}
	
	/**
	 * 제목으로 도서 검색
	 */
	public ArrayList<BookVO> viewBookByTitle(String title) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT isbn, author, price, usable ");
			sql.append("  FROM book_table ");
			sql.append("  WHERE title = ? ");
			sql.append("  ORDER BY isbn asc ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, title);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String isbn = rs.getString("isbn");
				String author = rs.getString("author");
				int price = rs.getInt("price");
				int usable = rs.getInt("usable");
				BookVO vo = new BookVO(isbn, title, author, price, usable);
				
				bookList.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.closPreparedStatement(pstmt);
			JDBCClose.closeConnection(con);
		}
		
		return bookList;
	}
	
	/**
	 * ISBN으로 도서 대출
	 */
	public int rentBook(long isbn) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = new ConnectionFactory().getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE book_table ");
			sql.append("  SET usable = ? ");
			sql.append("  WHERE isbn = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, 0);
			pstmt.setLong(2, isbn);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.closPreparedStatement(pstmt);
			JDBCClose.closeConnection(con);
		}
		
		return result;
	}
	
	/**
	 * ISBN으로 도서 반납
	 */
	public int returnBook(long isbn) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = new ConnectionFactory().getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE book_table ");
			sql.append("  SET usable = ? ");
			sql.append("  WHERE isbn = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, 1);
			pstmt.setLong(2, isbn);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.closPreparedStatement(pstmt);
			JDBCClose.closeConnection(con);
		}
		
		return result;
	}
}
