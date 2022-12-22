package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load the spring config file
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("/beanScope-applicationContext.xml");
		
		//retrive the beans from container
		
		Coach theCoach=applicationContext.getBean("t",Coach.class);		
		
		Coach alphaCoach=applicationContext.getBean("t",Coach.class);

		//compare the coach and alphacoach		
		boolean result=(theCoach==alphaCoach);
		System.out.println("\npointing to the same object:" + result);
		
		System.out.println("\n memory location of theCoach:" + theCoach);
		
		System.out.println("\n memory location of alphaCoach:" + alphaCoach);
		
		applicationContext.close();
	}

}
