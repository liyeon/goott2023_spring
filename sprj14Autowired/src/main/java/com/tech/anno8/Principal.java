package com.tech.anno8;

import org.springframework.stereotype.Component;

//바로 빈으로 등록하기
@Component
public class Principal {
	public void principalInfo() {
		System.out.println("hi i am your principal");
		System.out.println("내이름은김삼순");
	}
}