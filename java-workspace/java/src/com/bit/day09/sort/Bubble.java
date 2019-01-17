package com.bit.day09.sort;

/*
	버블 정렬
		: 인접한 두 원소를 비교하여 정렬
		시간복잡도 : O(n^2)
 */

public class Bubble {
	public void sort(int[] data) {
		for(int i = data.length; i > 1; i--) {		// 정렬할 범위 축소
			for(int j=1; j<i; j++) {
				if(data[j-1] > data[j]) {
					Sort.swap(data, j-1, j);
					Sort.info(data);
				}
			}
		}
	}
}
