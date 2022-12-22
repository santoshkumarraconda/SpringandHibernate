package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint)
	{
		String method=theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n====>>>> executing @After(Finally) on method:" + method);
		
		System.out.println("Executed after finally adivce");
	}
	
	
	//this is where we will add all our related advices for logging
	//after throwing advice
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
					throwing="theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint,Throwable theExc)
	{
		//print out the method which method we are advicing on
		String method=theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n====>>>> executing @AfterThrowing on method:" + method);
		
		//log the exception
		System.out.println("\n ====> The exception is :::" + theExc);
	}
	
	//After returning advice
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
					returning="result")
	public void afterReturningAdvice(JoinPoint theJoinPoint,List<Account> result)
	{
		
		//MethodSignature method=(MethodSignature)theJoinPoint.getSignature();
		String method=theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n====>>>> executing After returning on :" + method);
		
		System.out.println("\n====>>>> result is :" + result);
		
		//lets post process the data..lets modify it
		
		covertAccountNamesToUpperCase(result);
		
		System.out.println("\n====>>>> result is :" + result);
	}
	
	private void covertAccountNamesToUpperCase(List<Account> result) {

		for(Account tempAccount : result) {
			
			String upperName=tempAccount.getName().toUpperCase();
			
			System.out.println(upperName);
			
			tempAccount.setName(upperName);
		}
		
	}	

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