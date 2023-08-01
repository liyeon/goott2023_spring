package com.tech.anno8;

import org.springframework.stereotype.Component;


//바로 빈으로 등록하기
@Component
public class MathTeacher implements Teacher {

	@Override
	public void teach() {
		System.out.println("안성하세요 수학선생님");
		System.out.println("제 이름은 리연입니다.");
	}

}
