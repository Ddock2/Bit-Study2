package com.bit.day08.generic;

public class DArray<datatype> {
	private Object[] buffer;	// 저장소
	private int capacity;	// 저장소의 크기
	private int usage;		// 보관 개수
	
	public DArray(int capacity) {
		this.capacity = capacity;
		buffer = new Object[capacity];
		usage = 0;
	}
	
	public boolean isFull() {
		return capacity == usage;
	}
	
	public boolean add(datatype value) {
		if(isFull()) {
			Object[] temp = buffer;								// 현재 공간의 주소를 임시 저장
			buffer = new Object[++capacity];					// 증가된 크기만큼 새로운 배열 생성
			System.arraycopy(temp, 0, buffer, 0, usage);	// 임시로 담아둔 temp를 복사
		}
		buffer[usage++] = value;
		return true;
	}
	
	// 배열 정보 출력
	public void arrInfo() {
		String str = String.format("저장소 크기 : %d, 보관 개수 : %d", capacity, usage);
		System.out.println(str);
		for(int i=0; i<usage; i++) {
			System.out.print(buffer[i] + " ");
		}
		System.out.println();
	}
	
}

