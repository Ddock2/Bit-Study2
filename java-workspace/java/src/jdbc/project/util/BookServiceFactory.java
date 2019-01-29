package jdbc.project.util;

import jdbc.project.service.BookService;

public class BookServiceFactory {
	
	static BookService bs = null;
	
	public BookService getBookService() {
		if(bs == null)
			bs = new BookService();
		
		return bs;
	}
	
}
