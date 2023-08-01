package com.tech.anno4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollegeConfig {
	@Bean
	public Principal principalBean() {
		return new Principal();
	}
	// bean 등록
	@Bean(name="col")
//	@Bean
	public College college() {
		return new College(principalBean());
	}
}//class