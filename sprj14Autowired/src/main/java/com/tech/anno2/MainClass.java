package com.tech.anno2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/tech/anno2/beans.xml");
		System.out.println("beans.xml 파일 로드");
		College college = context.getBean("college",College.class);
		System.out.println("This College object by Spring is : "+college);
	}
}