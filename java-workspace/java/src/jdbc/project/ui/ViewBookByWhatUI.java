package jdbc.project.ui;

import java.util.ArrayList;

import jdbc.project.vo.BookVO;

public class ViewBookByWhatUI extends SuperClassUI implements InterfaceUI{
	private ArrayList<BookVO> bookList = null;

	@Override
	public void process() throws Exception {
		int mod = 0;
		
		while(true) {
			System.out.println("-----------------------------------------");
			System.out.println("             [4.도서 검색]");
			System.out.println("-----------------------------------------");
			System.out.println("1.ISBN으로 검색"
							 + "\n2.제목으로 검색"
							 + "\n0.뒤로");
			
			mod = sh.scanInt("원하는 동작을 선택하세요 : ");
			System.out.println();
			if(mod == 1) {
				viewBookByIsbn();
				break;
			}else if(mod == 2){
				viewBookByTitle();
				break;
			}else if(mod == 0) {
				break;
			}else {
				System.out.println("잘못된 입력입니다");
			}
		}
	}
	
	// ISBN으로 도서 검색
	private void viewBookByIsbn() {
		String isbn = sh.scanStr("찾는 책의 ISBN을 입력 : ");
		bookList = bs.viewBookByIsbn(isbn);
		
		printBookList(bookList);
	}
	
	// 제목으로 도서 검색
	private void viewBookByTitle() {
		String title = sh.scanStr("찾는 책의 제목을 입력 : ");
		bookList = bs.viewBookByTitle(title);
		
		printBookList(bookList);
	}
	
	// 도서 리스트 출력
	private void printBookList(ArrayList<BookVO> bookList) {
		System.out.println("-----------------------------------------");
		System.out.println("             [검색 결과(" + (bookList!=null?bookList.size():0) + ")]");
		System.out.println("-----------------------------------------");
		System.out.println("ISBN\t제목\t저자\t가격\t대여 여부");
		System.out.println("-----------------------------------------");
		for(BookVO book : bookList) {
			System.out.println(book);
		}
		if(bookList.isEmpty())
			System.out.println("검색한 책이 존재하지 않습니다...");
	}
}