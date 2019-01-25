package board.ui;

import java.util.Scanner;

import board.BoardServiceFactory;
import board.service.BoardService;

public abstract class BaseUI implements IBoardUI{
	private Scanner sc;
	protected BoardService service;
	
	public BaseUI() {
		sc = new Scanner(System.in);
		service = BoardServiceFactory.getInstance();
	}
	
	protected int scanInt(String msg) {
		System.out.print(msg);
		return Integer.parseInt(sc.nextLine());
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
}
