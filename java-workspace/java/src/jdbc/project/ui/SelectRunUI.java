package jdbc.project.ui;

public class SelectRunUI {
	private InsertBookUI ib = null;
	private DeleteBookUI db = null;
	private ViewBookAllUI vb = null;
	private ViewBookByWhatUI vbw = null;
	private RentBookUI rb = null;
	
	public SelectRunUI() {
		ib = new InsertBookUI();
		db = new DeleteBookUI();
		vb = new ViewBookAllUI();
		vbw = new ViewBookByWhatUI();
		rb = new RentBookUI();
	}
	
	public void process(int mod) {
		try {
			switch(mod) {
				case 1: 		// 도서 추가
					ib.process();
					break;
				case 2: 		// 도서 삭제
					db.process();
					break;
				case 3: 		// 도서 목록
					vb.process();
					break;
				case 4: 		// 도서 ISBN으로 검색
					vbw.process();
					break;
				case 5: 		// 도서 대여
					rb.process();
					break;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println();
		}
	}
	
}
