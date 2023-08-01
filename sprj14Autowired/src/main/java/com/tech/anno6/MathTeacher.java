package com.tech.anno6;

public class MathTeacher implements Teacher {

	@Override
	public void teach() {
		System.out.println("안성하세요 수학선생님");
		System.out.println("제 이름은 리연입니다.");
	}

}
