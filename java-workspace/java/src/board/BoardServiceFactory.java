package board;

import board.service.BoardService;

// 싱글톤 패턴
public class BoardServiceFactory {
	private static BoardService service = null;
	
	// 동기화
	// : 한사람이 접근할 때 다른 사람은 접근하지 못하도록
	public static synchronized BoardService getInstance() {
		if(service == null) {
			service = new BoardService();
			return service;
		}
		return service;
	}
}
