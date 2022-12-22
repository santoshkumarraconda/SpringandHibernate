package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//Load the spring configuration files
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		//retrieve the spring container
		Coach theCoach=context.getBean("b",Coach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//lets call our new methods for the fortunes
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
