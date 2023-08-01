package com.tech.anno7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//바로 빈으로 등록하기
@Component
public class College {
	private Principal principal;
	private Teacher teacher;
	
	public College() {}
//	public College(Principal principal,Teacher teacher) {
//		this.principal=principal;
//		this.teacher=teacher;
//	}
	public void test() {
		principal.principalInfo();
		teacher.teach();
		System.out.println("testing is call methods");
	}
	// 스프링이 관리하고 있는 객체를 주입(di)받기 위해 붙이는 어노테이션
	// collegeConfig에서 객체를 생성해서 주입 했던걸 autowired를 사용해 자동으로 해결한다.
	@Autowired
	public void setPrincipal(Principal principal) {
		this.principal = principal;
		System.out.println("setPrincipal 메소드를 지나친다면");
	}
	@Autowired
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
		System.out.println("setTeacher 메소드를 지나친다면");
	}
	
}//class