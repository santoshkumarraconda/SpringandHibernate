 package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;


public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		//read the spring cofiguration class
		AnnotationConfigApplicationContext annotationConfigApplicationContext=
											new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the container
		AccountDAO theAccountDAO=annotationConfigApplicationContext.getBean("accountDAO",AccountDAO.class);
		
		
		List<Account> theAccount=null;
				
			try {
				Boolean tripwire=false;
				theAccount= theAccountDAO.findAccounts(tripwire);	
		
			}catch(Exception exc){
				System.out.println("\n\nMain program ... Caught exception:::::::" + exc);
			}
			
		System.out.println("\n \n Main program : After Returning Demo App");
		
		System.out.println("------");
		
		System.out.println(theAccount);
		
		System.out.println("\n");
		
		//close the context
		annotationConfigApplicationContext.close();

	}

}
