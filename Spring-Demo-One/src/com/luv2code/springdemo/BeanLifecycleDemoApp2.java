package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp2 {

	public static void main(String[] args) {
		
		//load the spring config file
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("/beanLifecycle-applicationContext.xml");
		
		//retrive the beans from container
		Coach theCoach=applicationContext.getBean("t",Coach.class);	
		
		System.out.println(theCoach.getDailyWorkout());
		
		applicationContext.close();
	}

}
