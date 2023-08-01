package com.tech.anno6;

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
	public void setPrincipal(Principal principal) {
		this.principal = principal;
		System.out.println("setPrincipal 메소드를 지나친다면");
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
		System.out.println("setTeacher 메소드를 지나친다면");
	}
	
}//class