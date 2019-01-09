package com.bit.day03.dynamic;

public class IntDArray {
	
	private int[] buffer;	// 저장소
	private int capacity;	// 저장소의 크기
	private int usage;		// 보관 개수
	
	public IntDArray(int capacity) {
		this.capacity = capacity;
		buffer = new int[capacity];
		usage = 0;
	}
	
	public boolean isFull() {
		return capacity == usage;
	}
	
	public boolean add(int value) {
		// Q. 동적 배열 만들기
		// 	데이터가 꽉 찼을 때 더이상 추가되지 않음
		//	수정을 통해, 데이터가 꽉 차있는 상태라도 데이터가 들어갈 수 있도록
		//	동적으로 저장 공간을 늘리는 동적 배열을 만드시오
		if(isFull()) {
			int[] temp = buffer;
			buffer = new int[++capacity];
			System.arraycopy(temp, 0, buffer, 0, capacity-1);
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
