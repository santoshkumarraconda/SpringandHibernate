package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we will add all our related advices for logging
	
	//lets start with @before advice
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice(){
		
		System.out.println("\n=====>>> Executing @before advice on method()");
	}

	@Before("forDaoPackage()")
	public void performApiAnalytics(){
		
		System.out.println("\n=====>>> Performing API analytics");
	}

}