package com.tech.anno8;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//컴포넌트 경로 지정하기
@ComponentScan(basePackages = "com.tech.anno8")
@Configuration
public class CollegeConfig {
//	@Bean
//	public Teacher mathTeacherBean() {
//		return new MathTeacher();
//	}
//	@Bean
//	public Principal principalBean() {
//		return new Principal();
//	}
//	// bean 등록
//	@Bean(name="col")
////	@Bean
//	public College college() {
////		return new College(principalBean());
//		College college = new College();
//		college.setPrincipal(principalBean());
//		college.setTeacher(mathTeacherBean());
//		return college;
//	}
}//class