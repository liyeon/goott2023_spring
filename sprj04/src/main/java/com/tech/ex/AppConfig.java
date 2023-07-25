package com.tech.ex;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// xml config를 대신하는 어노테이션
// config 어노테이션을 사용하려면 CGLIB 가 필요하다.
@Configuration
public class AppConfig {
//	빈등록
	@Bean
	public Student student1() {
		Student student = new Student("홍길동", "20");
		student.setGradeNum("5학년");
		student.setClassNum("computer");
		ArrayList<String> hobbys=new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("수영2");
		student.setHobbys(hobbys);
		
		HashMap<String, String> maps=new HashMap<String, String>();
		maps.put("1", "김밥");
		maps.put("2", "김밥2");
		student.setMaps(maps);
		return student;
	}
	
	@Bean
	public Student student2() {
		Student student = new Student("홍길동2", "21");
		student.setGradeNum("6학년");
		student.setClassNum("computerAA");
		return student;
	}
	
	@Bean
	public StudentInfo studentInfo() {
		StudentInfo studentInfo = new StudentInfo(this.student1());
		return studentInfo;
	}
}