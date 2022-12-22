package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config Java class 
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SportsConfig.class);
		
		//get the bean from spring container
		SwimCoach theCoach=applicationContext.getBean("swimCoach",SwimCoach.class);
		
		//call the methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//call our new swm coach methods
		System.out.println("email:"+ theCoach.getEmail());
		
		System.out.println("email:"+ theCoach.getTeam());
		
		//close the context
		applicationContext.close();

	}

}
