package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	//this is where we will add all our related advices for logging
	
	//lets start with @before advice
	
	@Before("com.luv2code.aopdemo.aspect.AopPoincutExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
		
		System.out.println("\n=====>>> Executing @before advice on method()");
		
		//display the method signature
		MethodSignature signature=(MethodSignature)theJoinPoint.getSignature();
		
		System.out.println("Method signature :"+signature);
		
		//display the method parameters
		
		//get args
		Object args[]=theJoinPoint.getArgs();
		
		//loop args
		for(Object tempargs : args)
		{
			System.out.println(tempargs);
			
			if(tempargs instanceof Account)
			{
				//downcast and print specific stuff
				Account theAccount=(Account) tempargs;
				
				System.out.println("Account name :"+ theAccount.getName());
				System.out.println("Account Level :"+ theAccount.getLevel());
			}
		}
		
		
	}

}