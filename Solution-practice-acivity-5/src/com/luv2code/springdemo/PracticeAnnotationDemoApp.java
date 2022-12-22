package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeAnnotationDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		Coach theCoach=applicationContext.getBean("pingPongCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		applicationContext.close();
	}
}
