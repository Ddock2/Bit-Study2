package jdbc.project.ui;

import java.util.ArrayList;

import jdbc.project.vo.BookVO;

public class RentBookUI extends SuperClassUI implements InterfaceUI{
	
	private BookVO book = null;
	
	@Override
	public void process() throws Exception {
		int mod = 0;
		
		while(true) {
			System.out.println("-----------------------------------------");
			System.out.println("             [5.도서 대여]");
			System.out.println("-----------------------------------------");
			System.out.println("1.도서 대여"
							 + "\n2.도서 반납"
							 + "\n0.뒤로");
			
			mod = sh.scanInt("원하는 동작을 선택하세요 : ");
			System.out.println();
			if(mod == 1) {
				if(rentBook());
					break;
			}else if(mod == 2){
				if(returnBook())
					break;
			}else if(mod == 0) {
				break;
			}else {
				System.out.println("잘못된 입력입니다");
			}
		}
	}
	
	// 도서 대출
	private boolean rentBook() {
		String isbn = sh.scanStr("대여할 도서의 ISBN을 입력 : ");
		ArrayList<BookVO> bookList = bs.viewBookByIsbn(isbn);
		if(bookList.isEmpty()) {
			System.out.println("입력한 ISBN에 해당하는 도서가 없습니다");
			return false;
		}else {
			book = bookList.get(0);
		}
		
		if(book.getUsable() != 1) {
			System.out.println("\"" + book.getTitle() + "\"은 이미 대여중입니다");
			return false;
		}
		
		if(bs.rentBook(isbn)) {
			System.out.println("\"" + book.getTitle() + "\" 대여 성공");
		}else {
			System.out.println("\"" + book.getTitle() + "\" 대여 실패");
		}
		return true;
	}
	
	// 도서 반납
	private boolean returnBook() {
		String isbn = sh.scanStr("반납할 도서의 ISBN을 입력 : ");
		ArrayList<BookVO> bookList = bs.viewBookByIsbn(isbn);
		if(bookList.isEmpty()) {
			System.out.println("입력한 ISBN에 해당하는 도서가 없습니다");
			return false;
		}else {
			book = bookList.get(0);
		}
		
		if(book.getUsable() != 0) {
			System.out.println("\"" + book.getTitle() + "\"은 이미 반납된 책입니다");
			return false;
		}
		
		if(bs.returnBook(isbn)) {
			System.out.println("\"" + book.getTitle() + "\" 반납 성공");
		}else {
			System.out.println("\"" + book.getTitle() + "\" 반납 실패");
		}
		return true;
	}

}
