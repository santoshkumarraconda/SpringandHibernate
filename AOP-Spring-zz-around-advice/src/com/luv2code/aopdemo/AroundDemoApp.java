 package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;


public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read the spring cofiguration class
		AnnotationConfigApplicationContext annotationConfigApplicationContext=
											new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the container
		TrafficFortuneService  theFortuneService=annotationConfigApplicationContext.getBean
													("trafficFortuneService",TrafficFortuneService.class);
	
		System.out.println("\n \n Main program : Around Demo App");
		
		System.out.println("calling get Fortune");
		
		String data=theFortuneService.getFortune();
		
		System.out.println("\n My fortune is" + data);
		
		System.out.println("Finished");
		
		//close the context
		annotationConfigApplicationContext.close();

	}

}
