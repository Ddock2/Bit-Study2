package com.bit.day09.sort;

/*
 	선택 정렬
 	1. 정렬할 데이터 중 가장 작은(큰) 데이터를 찾는다
 	2. 가장 작은(큰) 값을 찾았다면 맨 앞의 요소와 스왑
 	3. 정렬한 범위를 줄이면서 정렬
 		시간 복잡도 : O(n^2)
 */

public class Select {
	public void sort(int[] data) {
		int max = 0;
		for(int i=data.length; i>1; i--) {
			max = 0;
			for(int j=1; j<i; j++) {
				if(data[max] < data[j]) {
					max = j;
				}
			}
			Sort.swap(data, max, i-1);
			Sort.info(data);
		}
	}
}
