package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoAPP {

	public static void main(String[] args) {
		
		//Read the COnfig file
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		//Retrieve the beans
		Coach theCoach=applicationContext.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach=applicationContext.getBean("tennisCoach",Coach.class);
		
		//check if they are same
		Boolean result=(theCoach==alphaCoach);
		
		//print the results
		System.out.println("\n pointing to the same object:" + result);
		
		System.out.println("\n Memory location to the Coach :" + theCoach);
		
		System.out.println("\n Memory location to the alphaCoach:" + alphaCoach);
		
		applicationContext.close();

	}

}
