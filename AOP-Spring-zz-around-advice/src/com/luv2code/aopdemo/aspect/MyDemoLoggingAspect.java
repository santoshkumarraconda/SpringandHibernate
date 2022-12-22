package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	//Around advice
	@Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object arroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
	{
		//print out the method
		String method=theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>>> executing @Around on method:" + method);
		
		//begin the time stamp
		long begin=System.currentTimeMillis();
		
		//execute the method
		Object result=theProceedingJoinPoint.proceed();
		
		//emd the time stamp
		long end=System.currentTimeMillis();
		
		//calculate the duration
		long duration=end-begin;
		
		System.out.println("\n ====> Duration is :::" + duration/1000.0 + "seconds");
		
		return result;
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