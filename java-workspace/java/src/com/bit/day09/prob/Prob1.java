package com.bit.day09.prob;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bit.day09.prob.Member;
import com.bit.util.FileClose;

// Member

/*
	Q. 8일차 + 파일 입출력을 이용한 Member객체 문서화 하여 유지
 */

public class Prob1 {
	
	public static void main(String[] args) {
		Program p = new Program();
		p.process();
	}
	
}

class Program {
	private List<Member> mList = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	
	public void process() {
		read();
		boolean escape = true;
		while(escape) {
			switch(menu()) {
				case 1: signUp(); break;
				case 2: changePW(); break;
				case 3: deleteMember(); break;
				case 4: viewMemberList(); break;
				case 0:
					write();
					System.out.println("종료");
					escape = false;
					break;
				default: System.out.println("!!! 잘못된 선택 !!!");
			}
		}
	}
	
	private int menu() {
		System.out.println("******** 메뉴 선택 ********");
		
		return inputInt("[1]:가입 [2]:비밀번호변경 [3]:탈퇴 [4]:목록 [0]:종료");
	}
	// 이전 회원정보 읽기
	private void read() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("iotest/MemberObject.txt");
			ois = new ObjectInputStream(fis);
			
			int memberNum = ois.readInt();
			
			for(int i=0; i<memberNum; i++) {				
				mList.add((Member)ois.readObject());
			}
			
			System.out.println("회원정보 불러옴");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			FileClose.close(fis, ois);
		}
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
	
	// 탈퇴
	private void deleteMember() {
		String id = inputString("- ID 입력 -");
		Member member = checkId(id);
		String pw;
		
		if(member == null) {
			System.out.println("!!! 존재하지 않는 ID !!!");
			return;
		}
		
		pw = inputString("- 비밀번호 입력 -");
		if(!member.getPw().equals(pw)) {
			System.out.println("!!! 비밀번호 불일치 !!!");
			return;
		}
		mList.remove(member);
		System.out.println("회원 탈퇴 완료");
	}
	
	// 회원 목록 조회
	private void viewMemberList() {
		for(Member m : mList) {
			System.out.println(m);
		}
		System.out.println();
	}
	
	// 종료시 회원정보 문서화
	private void write() {		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("iotest/MemberObject.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeInt(mList.size());
			
			for(Member m : mList) {
				oos.writeObject(m);
			}
			
			System.out.println("회원정보 저장완료");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			FileClose.close(fos, oos);
		}
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
