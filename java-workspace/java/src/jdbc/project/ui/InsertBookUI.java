package jdbc.project.ui;

import jdbc.project.vo.BookVO;

public class InsertBookUI extends SuperClassUI implements InterfaceUI{
	
	@Override
	public void process() throws Exception {
		BookVO vo = null;
		
		System.out.println("-----------------------------------------");
		System.out.println("             [1.도서 추가]");
		System.out.println("-----------------------------------------");
		String isbn = sh.scanStr("추가할 도서의 ISBN을 입력하세요 : ");
		String title = sh.scanStr("추가할 도서의 제목을 입력하세요 : ");
		String author = sh.scanStr("추가할 도서의 저자를 입력하세요 : ");
		int price = sh.scanInt("추가할 도서의 가격을 입력하세요: ");
		
		vo = new BookVO(isbn, title, author, price);
		
		if(bs.insertBook(vo)) {
			System.out.println("-- 도서 추가 성공 --");
		}else {
			System.out.println("-- 도서 추가 실패 --");
		}
	}
	
}
