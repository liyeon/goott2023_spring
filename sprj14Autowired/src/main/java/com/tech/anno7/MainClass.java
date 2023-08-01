package com.tech.anno7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/tech/anno2/beans.xml");
//		System.out.println("beans.xml 파일 로드");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);
		College college = context.getBean("college",College.class);
		System.out.println("This College object by Spring is : "+college);
		college.test();
	
	}
}