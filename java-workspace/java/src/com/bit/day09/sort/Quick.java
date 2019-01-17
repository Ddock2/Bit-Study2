package com.bit.day09.sort;

/*
	퀵 정렬
	1. 정렬할 데이터 중 하나를 pivot 선정
	2. pivot을 기준으로 pivot보다 작은 값은 왼쪽, 큰 값은 오른쪽으로 분할 (오름차순)
	3. 분할된 각각의 리스트를 위의 과정을 반복
 */

public class Quick {
	public void sort(int[] data, int l, int r) {
		int left = l;
		int right = r;
		int pivot = data[(l+r)/2];
		
		do {
			while(data[left] < pivot) {
				left++;
			}
			while(data[right] > pivot) {
				right--;
			}
			if(left <= right) {
				Sort.swap(data, left, right);
				Sort.info(data);
				left++;
				right--;
			}
		}while(left <= right);
		
		if(l<right) {
			sort(data, l, right);
		}
		if(r > left) {
			sort(data, left, r);
		}
	}
}
