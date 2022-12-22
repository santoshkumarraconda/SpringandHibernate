package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

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
	
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	//Around advice
	@Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object arroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
	{
		//print out the method
		String method=theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>>> executing @Around on method:" + method);
		
		//begin the time stamp
		long begin=System.currentTimeMillis();
		
		//execute the method
		Object result=theProceedingJoinPoint.proceed();
		
		//emd the time stamp
		long end=System.currentTimeMillis();
		
		//calculate the duration
		long duration=end-begin;
		
		myLogger.info("\n ====> Duration is :::" + duration/1000.0 + "seconds");
		
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
		
		myLogger.info("\n====>>>> executing @AfterThrowing on method:" + method);
		
		//log the exception
		myLogger.info("\n ====> The exception is :::" + theExc);
	}
	
	//After returning advice
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
					returning="result")
	public void afterReturningAdvice(JoinPoint theJoinPoint,List<Account> result)
	{
		
		//MethodSignature method=(MethodSignature)theJoinPoint.getSignature();
		String method=theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n====>>>> executing After returning on :" + method);
		
		myLogger.info("\n====>>>> result is :" + result);
		
		//lets post process the data..lets modify it
		
		covertAccountNamesToUpperCase(result);
		
		myLogger.info("\n====>>>> result is :" + result);
	}
	
	private void covertAccountNamesToUpperCase(List<Account> result) {

		for(Account tempAccount : result) {
			
			String upperName=tempAccount.getName().toUpperCase();
			
			myLogger.info(upperName);
			
			tempAccount.setName(upperName);
		}
		
	}

	//lets start with @before advice
	
	@Before("com.luv2code.aopdemo.aspect.AopPoincutExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
		
		myLogger.info("\n=====>>> Executing @before advice on method()");
		
		//display the method signature
		MethodSignature signature=(MethodSignature)theJoinPoint.getSignature();
		
		myLogger.info("Method signature :"+signature);
		
		//display the method parameters
		
		//get args
		Object args[]=theJoinPoint.getArgs();
		
		//loop args
		for(Object tempargs : args)
		{
			myLogger.info(tempargs.toString());
			
			if(tempargs instanceof Account)
			{
				//downcast and print specific stuff
				Account theAccount=(Account) tempargs;
				
				myLogger.info("Account name :"+ theAccount.getName());
				myLogger.info("Account Level :"+ theAccount.getLevel());
			}
		}
		
		
	}

}