package com.bit.aop;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	// AOP 예제의 비지니스 로직
	// 순수 비지니스 로직만 존재
	// 제 3자가 바라보는 형태로 AOP가 적용됐는지 안됐는지 여부가, 본 입장에서는 판단이 어렵다
	//	*관점(관심) 지향이란 밖에서 바라보는 제 3자의 입장
	public ProductVO find(String name) {
		System.out.println(name + " finding...");
		/*
		if(true) {
			throw new RuntimeException("My Exception");
		}
		*/
		
		return new ProductVO(name);
	}
	
}
