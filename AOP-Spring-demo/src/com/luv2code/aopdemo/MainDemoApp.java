package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read the spring cofiguration class
		AnnotationConfigApplicationContext annotationConfigApplicationContext=
											new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the container
		AccountDAO theAccountDAO=annotationConfigApplicationContext.getBean("accountDAO",AccountDAO.class);
		
		MembershipDAO membershipDAO=annotationConfigApplicationContext.getBean("membershipDAO",MembershipDAO.class);
		
		//call the business method
		Account myAccount=new Account();
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();
		
		System.out.println("\n\nLets run this again");
		
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
		
		//close the context
		annotationConfigApplicationContext.close();

	}

}
