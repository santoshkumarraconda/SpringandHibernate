package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		//retrieve bean from the spring container
		CricketCoach theCoach=applicationContext.getBean("c",CricketCoach.class);
		
		//call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//call our new methods to get the literal values
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		
		
		//close the context
		applicationContext.close();
	}

}
