package com.bit.day09.sort;

/*
	삽입 정렬
		원소 배열의 요소를 이미 정렬된 배열과 비교하여.
		자신의 위치에 삽입하는 정렬
 */

public class Insert {
	public void sort(int[] data) {
//		for(int i =0; i<data.length; i++) {
//			for(int j=i; j>0; j--) {
//				if(data[j-1] > data[j]) {
//					Sort.swap(data, j-1, j);
//					Sort.info(data);
//				}else {
//					break;
//				}
//			}
//		}
		
		for(int i=1; i<data.length; i++) {
			int temp = data[i];
			int sub = i - 1;
			while((sub>=0) && (data[sub])>temp) {
				data[sub + 1] = data[sub];
				sub--;
			}
			data[sub + 1] = temp;
			Sort.info(data);
		}
	}
}
