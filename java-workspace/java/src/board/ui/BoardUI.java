package board.ui;

import board.BoardUIMapping;

/*
 * 리플렉션 (Reflection)
 *   : 프로그램을 실행할때 어떤 것을 실행하느냐에 따라 각각 다르게 만들어진다.
 *     동적인 방식-> 실행할 때 마다 해당 객체가 동적으로 생성.
 *   
 *  대표 메소드
 *    getDeclaredFields() : 필드 리스트를 가져온다.
 *    getDeclaredMethods() : 메소드 리스트를 가져온다.
 *    
 */

// 사용자 화면 처리
public class BoardUI extends BaseUI{
	
	String[] key = {"exit", "select", "selectOne", "insert", "update", "delete"};
	
	@Override
	public void process() throws Exception {
		// 유저 인터페이스 맵핑
		BoardUIMapping mapping = new BoardUIMapping();
		// key가 insert라면, insertUI의 인스턴스 주소 값을 알고 있다.
		
		
		while(true) {
			int type = menu();
			if(type >= key.length) {
				System.out.println("잘못된 번호를 선택하셨습니다.");
				continue;
			}
			IBoardUI ui = mapping.getBoardUI(key[type]);
			if(ui != null)
				ui.process();
		}
		
	}
	
	private int menu() {
		System.out.println("-------------------------------------------");
		System.out.println("         처음 만나는 게시판 프로그램 (JDBC)          ");
		System.out.println("-------------------------------------------");
		System.out.println("1. 전체 게시글 조회");
		System.out.println("2. 글 번호 조회");
		System.out.println("3. 새 글 등록");
		System.out.println("4. 글 수정");
		System.out.println("5. 글 삭제");
		System.out.println("0. 프로그램 종료");
		
		int type = scanInt("메뉴 중 처리할 항목을 선택 : ");
		
		return type;
	}
}
