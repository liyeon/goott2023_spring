package com.tech.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLocation = "classpath:applicationCtx.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		MyCalculator myCalculator = ctx.getBean("myCalculation", MyCalculator.class);
		myCalculator.add();
		myCalculator.sub();
		myCalculator.multi();
		myCalculator.div();
	}//main
}//class