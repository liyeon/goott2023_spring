package com.tech.sprj09.aspect;

import java.util.Properties;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.tech.sprj09.controller.BController;

/*
 * Aspect : 공통관심사(황단관심사)
 * 	메소드를 횡단하는 관심사
 * - 핵심 비즈니스 로직과는 상관 없는 공통 관심사를 따로 작성한다.
 * 
 * ### 횡단 관심사(crosscutting concerns)

메소드를 횡단하면서 관심사가 있는것 <- 횡단 관심사(crosscutting concerns)
init.xml에 무언가 설정만으로 작업을 할 수 있다. 

횡단관심사를 따로 클래스를 만들어두고 적용 시킬 수 있다.
 * 
 */
@Aspect // aspect 역할을 할 수 있도록 필요한 어노테이션
@Component // component scan을 통해서 bean이 되기 위한 어노테이션
public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(BController.class);

	@Around("execution(* com.tech.sprj09.controller.*.*(..))")
	public Object loggerAround(ProceedingJoinPoint jointpoint) throws Throwable {
		long beforeTimeMillis = System.currentTimeMillis(); // 이시점에서 시간을 가져온다.
		System.out.println("[BoardController] start :" + jointpoint.getSignature().getDeclaringTypeName() + "."
				+ jointpoint.getSignature().getName());
		// 핵심 기능
		Object result = jointpoint.proceed();// aop가 적용된 메소드 수행하기
		// aop가 적용된 메소드 수행 된 이후에 해야 할 작업
		long afterTimeMillis = System.currentTimeMillis();
		System.out.println("[BoardController] end :" + jointpoint.getSignature().getDeclaringTypeName() + "."
				+ jointpoint.getSignature().getName());
		System.out.println("경과시간 : " + (afterTimeMillis - beforeTimeMillis));
		logger.info("loggggggg:" + jointpoint.getSignature().getName() + "  :  "
				+ jointpoint.getSignature().getDeclaringTypeName());
		System.out.println("===============================================");
		return result;
	}

//  ============ tx set ===============================
	@Autowired
	private DataSourceTransactionManager transactionManager;
	private final static String BASE_DEFAULT_POITCUT = "execution(* com.tech.sprj09.controller.*.*(..))";

//   private final PlatformTransactionManager transactionManager;

	@Bean
	public TransactionInterceptor txAdvice() {
		TransactionInterceptor txAdvice = new TransactionInterceptor();
		Properties txAttributes = new Properties();

		DefaultTransactionAttribute defaultAttribute = new DefaultTransactionAttribute();
		String attributesDefinition = defaultAttribute.toString();

		txAttributes.setProperty("*", attributesDefinition);

		txAdvice.setTransactionAttributes(txAttributes);
		txAdvice.setTransactionManager(transactionManager);
		return txAdvice;
	}

	@Bean
	public DefaultPointcutAdvisor txAdviceAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(BASE_DEFAULT_POITCUT);
		return new DefaultPointcutAdvisor(pointcut, txAdvice());
	}
}