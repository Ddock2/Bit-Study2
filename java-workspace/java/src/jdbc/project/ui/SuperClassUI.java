package jdbc.project.ui;

import jdbc.project.service.BookService;
import jdbc.project.util.BookServiceFactory;
import jdbc.project.util.ScanHelper;

public class SuperClassUI {
	protected ScanHelper sh = new ScanHelper();
	protected BookService bs = new BookServiceFactory().getBookService();
}
