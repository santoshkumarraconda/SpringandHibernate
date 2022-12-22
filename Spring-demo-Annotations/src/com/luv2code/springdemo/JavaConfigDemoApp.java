package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config Java class 
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SportsConfig.class);
		
		//get the bean from spring container
		Coach theCoach=applicationContext.getBean("tennisCoach",Coach.class);
		
		//call the methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		applicationContext.close();

	}

}
