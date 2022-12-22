package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we will add all our related advices for logging
	
	//lets start with @before advice
	
//	@Before("execution(public void add*())")
	@Before("execution( * com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice(){
		
		System.out.println("\n=====>>> Executing @before advice on addAccount()");
	}

}