package com.tech.aop1;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureStr = joinPoint.getSignature().toLongString();
		System.out.println(signatureStr+" 시작");
		
		// 공통기능
		System.out.println("핵심 기능 전에 실행되는 공통기능 : "+System.currentTimeMillis());
		
		try {
			//핵심 기능
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			//공통기능
			System.out.println("핵심 기능 후에 실행되는 공통기능 : "+System.currentTimeMillis());
			System.out.println(signatureStr+" 끝");
		}//try~finally
	}//loggerAop
}//class