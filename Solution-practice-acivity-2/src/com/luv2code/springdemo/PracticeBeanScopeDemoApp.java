package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeBeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
				
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myGolfCoach", Coach.class);
		
		Coach alphaCoach=context.getBean("myGolfCoach",Coach.class);
		
		//add boolean to check whether the beans are same
		
		Boolean result=(theCoach==alphaCoach);
		
		System.out.println("\n pointing to same object =" + result);
		
		System.out.println("\n pointing to memory  location of theCoach" + theCoach);
		
		System.out.println("\n pointing to memory location of alphaCoach" + alphaCoach + "\n");
		
		// close the context
		context.close();
	}

}







