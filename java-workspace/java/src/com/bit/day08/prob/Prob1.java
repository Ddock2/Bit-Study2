package com.bit.day08.prob;

import java.util.ArrayList;
import java.util.List;

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
		List<Member> mList = new ArrayList<>();
		mList.add(new Member("aaa", "1111"));
		mList.add(new Member("bbb", "2222"));
		mList.add(new Member("ccc", "3333"));
		
		System.out.println("회원 목록 (ID, PASSWORD)");
		for(Member info : mList) {
			System.out.println("ID : " + info.getId()
								+ ", PASSWORD : " + info.getPw());
		}
	}
	
}
