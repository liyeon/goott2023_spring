package com.tech.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("================================");
		Student student1=ctx.getBean("student1",Student.class);
		System.out.println(student1.getName());
		System.out.println(student1.getAge());
		System.out.println(student1.getGradeNum());
		System.out.println(student1.getClassNum());
		System.out.println(student1.getHobbys());
		System.out.println(student1.getMaps());
		System.out.println(student1.getMaps().get("1"));
		
		StudentInfo studentInfo=ctx.getBean("studentInfo",StudentInfo.class);
		
		studentInfo.getStudentIfno();
	}
}