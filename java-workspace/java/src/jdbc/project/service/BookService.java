package jdbc.project.service;

import java.util.ArrayList;

import jdbc.project.dao.BookDAO;
import jdbc.project.vo.BookVO;

public class BookService {
	
	private BookDAO dao = new BookDAO();
	
	/**
	 * 도서 추가
	 */
	public boolean insertBook(BookVO vo) {
		long lIsbn = 0;
		lIsbn = isbnToLong(vo.getIsbn());
		
		if(vo.getIsbn().isEmpty() || vo.getTitle().isEmpty()) {
			System.out.println("ISBN과 제목은 필수 입력사항입니다");
			return false;
		}
		
		if(!dao.viewBookByIsbn(lIsbn).isEmpty()) {
			System.out.println("이미 등록된 책입니다");
			return false;
		}
		switch(vo.getPrice()) {
		case -1:
			vo.setPrice(0);
			break;
		case -2:
			System.out.println("잘못된 가격정보 입력");
			return false;
		}
		
		if(lIsbn == -1 || dao.insertBook(vo, lIsbn) == 0)
			return false;
		
		return true;
	}
	
	/**
	 * 도서 삭제
	 */
	public boolean deleteBook(String isbn) {
		long lIsbn = 0;
		lIsbn = isbnToLong(isbn);
		
		if(lIsbn == -1 || dao.deleteBook(lIsbn) == 0) {
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 도서 목록
	 */
	public ArrayList<BookVO> viewBookAll() {
		ArrayList<BookVO> bookList = dao.viewBookAll();
		dao.daoDataClear();
		return bookList;
	}
	
	/**
	 * ISBN으로 도서 검색
	 */
	public ArrayList<BookVO> viewBookByIsbn(String isbn) {
		long lIsbn = 0;
		lIsbn = isbnToLong(isbn);
		
		ArrayList<BookVO> bookList = dao.viewBookByIsbn(lIsbn);
		dao.daoDataClear();
		
		return bookList;
	}
	
	/**
	 * 제목으로 도서 검색
	 */
	public ArrayList<BookVO> viewBookByTitle(String title) {
		ArrayList<BookVO> bookList = dao.viewBookByTitle(title);
		dao.daoDataClear();
		
		return bookList;
	}
	
	/**
	 * ISBN으로 도서 대출
	 */
	public boolean rentBook(String isbn) {
		long lIsbn = 0;
		lIsbn = isbnToLong(isbn);
		
		if(lIsbn == -1 || dao.rentBook(lIsbn) == 0 )
			return false;
		
		return true;
	}
	
	/**
	 * ISBN으로 도서 반납
	 */
	public boolean returnBook(String isbn) {
		long lIsbn = 0;
		lIsbn = isbnToLong(isbn);
		
		if(lIsbn == -1 || dao.returnBook(lIsbn) == 0 )
			return false;
		
		return true;
	}
	
	
	// isbn : String -> long
	public long isbnToLong(String isbn) {
		long lIsbn = -1;
		try {
			lIsbn = Long.parseLong(isbn);
		}catch(NumberFormatException e) {
			System.out.println("입력값이 ISBN형식에 맞지 않습니다");
		}
		
		return lIsbn;
	}
}
