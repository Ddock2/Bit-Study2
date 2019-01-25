package board;

import board.ui.BoardUI;

public class Program {
	
	public static void main(String[] args) {
		BoardUI ui = new BoardUI();
		try {
			ui.process();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
