package jdbc.project.ui;

import java.util.ArrayList;

import jdbc.project.vo.BookVO;

public class ViewBookAllUI extends SuperClassUI implements InterfaceUI{

	@Override
	public void process() throws Exception {
		ArrayList<BookVO> bookList = bs.viewBookAll();
		System.out.println("-----------------------------------------");
		System.out.println("             [3.도서 목록(" + (bookList!=null?bookList.size():0) + ")]");
		System.out.println("-----------------------------------------");
		
		System.out.println("-----------------------------------------");
		System.out.println("ISBN\t제목\t저자\t가격\t대여 여부");
		System.out.println("-----------------------------------------");
		for(BookVO book : bookList) {
			System.out.println(book);
		}
		if(bookList.isEmpty())
			System.out.println("현재 책이 존재하지 않습니다...");
	}
	
}
