package com.tech.sprj09.aspect;

import java.util.Properties;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.tech.sprj09.controller.BController;

import lombok.RequiredArgsConstructor;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(BController.class);
	@Around("execution(* com.tech.sprj09.controller.*.*(..))")
	public Object loggerAround(ProceedingJoinPoint jointpoint) throws Throwable{
		long beforeTimeMillis=System.currentTimeMillis();
		System.out.println("[BoardController] start :"
				+jointpoint.getSignature().getDeclaringTypeName()+"."
				+jointpoint.getSignature().getName());
		Object result=jointpoint.proceed();
		long afterTimeMillis=System.currentTimeMillis();
		System.out.println("[BoardController] end :"
				+jointpoint.getSignature().getDeclaringTypeName()+"."
				+jointpoint.getSignature().getName());
		System.out.println("경과시간 : "+(afterTimeMillis-beforeTimeMillis));
		logger.info("loggggggg:"+jointpoint.getSignature().getName()+"  :  "
		+jointpoint.getSignature().getDeclaringTypeName());
		System.out.println("===============================================");
		return result;
	}
	
//	============ tx set ===============================
    @Autowired
    private DataSourceTransactionManager transactionManager;
    private final static String BASE_DEFAULT_POITCUT = "execution(* com.tech.sprj09.controller.*.*(..))";


	
//    private final PlatformTransactionManager transactionManager;

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
