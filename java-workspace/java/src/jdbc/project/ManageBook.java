package jdbc.project;

import jdbc.project.ui.SelectRunUI;
import jdbc.project.util.ScanHelper;

public class ManageBook {
	
	private ScanHelper sh = null;
	private int mod;
	private SelectRunUI sr = null;
	
	
	
	public ManageBook() {
		sh = new ScanHelper();
		mod = 0;
		sr = new SelectRunUI();
	}



	public void process() {
		
		while(true) {
			System.out.println("-----------------------------------------");
			System.out.println("             [도서 관리 프로그램]");
			System.out.println("-----------------------------------------");
			System.out.println("1.도서 추가"
							 + "\n2.도서 삭제"
						 	 + "\n3.도서 목록"
							 + "\n4.도서 검색"
							 + "\n5.도서 대여"
							 + "\n0.종료");
			
			mod = sh.scanInt("원하는 동작을 선택하세요 : ");
			System.out.println();
			
			switch(mod) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:sr.process(mod); break;
				case 0: break;
				default: System.out.println("잘못된 입력입니다");
			}
			
			if(mod==0) break;
		}
		
		System.out.println("[도서 관리 프로그램]이 종료되었습니다");
	}
	
}
