package jdbc.project.ui;

public class DeleteBookUI extends SuperClassUI implements InterfaceUI{

	@Override
	public void process() throws Exception {
		System.out.println("-----------------------------------------");
		System.out.println("             [2.도서 삭제]");
		System.out.println("-----------------------------------------");
		String isbn = sh.scanStr("삭제할 책의 ISBN 입력 : ");
		
		if(bs.deleteBook(isbn)) {
			System.out.println("-- 도서 삭제 성공 --");
		}else {
			System.out.println("-- 도서 삭제 실패 --");
		}
	}

}
