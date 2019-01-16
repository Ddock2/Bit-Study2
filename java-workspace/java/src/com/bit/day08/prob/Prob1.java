package com.bit.day08.prob;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Member

/*
	Q. 회원가입 및 비밀번호 변경 프로그램
		회원정보를 관리하는 Member 클래스를 정의
		회원가입은 ID와 PASSWORD를 입력 받고,
		비밀번호 변경은 일치하는 ID와 PASSWORD에 한해,
		변경이 가능하도록 하시오
		
		컬렉션 사용
 */

public class Prob1 {
	
	public static void main(String[] args) {
//		List<Member> mList = new ArrayList<>();
//		mList.add(new Member("aaa", "1111"));
//		mList.add(new Member("bbb", "2222"));
//		mList.add(new Member("ccc", "3333"));
//		
//		System.out.println("회원 목록 (ID, PASSWORD)");
//		for(Member info : mList) {
//			System.out.println(info);
//		}
		Program p = new Program();
		p.process();
	}
	
}

class Program {
	List<Member> mList = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	
	public void process() {
		boolean escape = true;
		while(escape) {
			switch(menu()) {
				case 1: signUp(); break;
				case 2: changePW(); break;
				case 0:
					System.out.println("종료");
					escape = false;
					break;
				default: System.out.println("!!! 잘못된 선택 !!!");
			}
		}
	}
	
	private int menu() {
		System.out.println("******** 메뉴 선택 ********");
		
		return inputInt("[1]:가입 [2]:비밀번호변경 [0]:종료");
	}
	
	// 가입
	private void signUp() {
		String id = inputString("- 사용할 ID 정하기 -");
		
		if(checkId(id) == null) {
			String pw = inputString("- 비밀번호 정하기 -");
			Member member = new Member(id, pw);
			mList.add(member);
			return;
		}
		System.out.println("!!! 가입불가 이미 사용중인 ID !!!");
	}
	
	// 비밀번호 변경
	private void changePW() {
		String id = inputString("- ID 입력 -");
		Member member = checkId(id);
		String pw;
		
		if(member == null) {
			System.out.println("!!! 존재하지 않는 ID !!!");
			return;
		}
		
		pw = inputString("- 이전 비밀번호 입력 -");
		if(!member.getPw().equals(pw)) {
			System.out.println("!!! 비밀번호 불일치 !!!");
			return;
		}
		
		pw = inputString("- 새로 사용할 비밀번호 입력 -");
		member.setPw(pw);
		System.out.println("비밀번호 변경 완료");
	}
	
	/**
	 * 입력받은 아이디와 동일한 Member객체 반환<br>
	 * 없을 시 null 반환
	 * @param id
	 * @return Member member
	 */
	private Member checkId(String id) {
		for(Member m : mList) {
			if(m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}
	
	private int inputInt(String msg) {
		System.out.println(msg);
		int i = s.nextInt();
		s.nextLine();
		return i;
	}
	
	private String inputString(String msg) {
		System.out.println(msg);
		return s.nextLine();
	}
}
