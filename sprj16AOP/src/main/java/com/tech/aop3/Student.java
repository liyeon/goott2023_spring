package com.tech.aop3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
	public void getStudentInfo() {
		System.out.println("=========================");
		System.out.println("이름 : "+getName());
		System.out.println("나이 : "+getAge());
		System.out.println("학년 : "+getGradeNum());
		System.out.println("반 : "+getClassNum());
		System.out.println("=========================");
	}
}