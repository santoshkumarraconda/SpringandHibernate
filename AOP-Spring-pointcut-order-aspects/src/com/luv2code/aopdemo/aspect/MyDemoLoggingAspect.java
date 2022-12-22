package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	//this is where we will add all our related advices for logging
	
	//lets start with @before advice
	
	@Before("com.luv2code.aopdemo.aspect.AopPoincutExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(){
		
		System.out.println("\n=====>>> Executing @before advice on method()");
	}

}