package com.tech.aop3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//어노테이션으로 aop 설정하기
@Aspect
public class LogAop {

	/*
	 * Aspectj문법sample
	 * 
	 * @Pointcut("execution(public void get*(..))")//public void 인 모든 get메소드
	 * 
	 * @Pointcut("execution(com.tech.ex.*.*())")//com.tech.ex패키지 안에 파라메터가 없는 모든 메소드
	 * 
	 * @Pointcut("execution(com.tech.ex..*.*())")//com.tech.ex패키지 &com.tech.ex하위패키지에 파라메터가 없는 모든 메소드
	 * 
	 * @Pointcut("execution(com.tech.ex.Worker.*())")//com.tech.ex.Worker 안의 모든 메소드
	 * 
	 * @Pointcut("within(com.tech.ex.*)")//com.tech.ex패키지의 모든 메소드
	 * 
	 * @Pointcut("within(com.tech.ex..*)")//com.tech.ex패키지및 하위패키지 모든 메소드
	 * 
	 * @Pointcut("within(com.tech.ex.Worker)")//Worker의 모든메소드
	 * // ker로 끝나는 모든 bean 객체에 적용하겠다.
		@Pointcut("bean(*ker)")//bean이 ker로 끝나는
	 */
	
	@Pointcut("execution(public void get*(..))")//public void 인 모든 get메소드
	public void pointcutMethod() {}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureStr = joinPoint.getSignature().toLongString();
		System.out.println(signatureStr + " 시작");

		// 공통기능
		System.out.println("핵심 기능 전에 실행되는 공통기능 : " + System.currentTimeMillis());

		try {
			// 핵심 기능
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			// 공통기능
			System.out.println("핵심 기능 후에 실행되는 공통기능 : " + System.currentTimeMillis());
			System.out.println(signatureStr + " 끝");
		} // try~finally
	}// loggerAop
	
	@Before("within(com.tech.aop3.*)")
	public void beforeAdvice() {
		System.out.println("Before Advice!");
	}
	
	@After("within(com.tech.aop3.*)")
	public void afterAdvice() {
		System.out.println("After Advice!");
	}
}// class