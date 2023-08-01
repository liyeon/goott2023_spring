package com.tech.anno3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollegeConfig {
	// bean 등록
	@Bean(name="col")
//	@Bean
	public College college() {
		return new College();
	}
}//class