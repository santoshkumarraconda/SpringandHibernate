 package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;


public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		
		Logger myLogger= Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
		
		//read the spring cofiguration class
		AnnotationConfigApplicationContext annotationConfigApplicationContext=
											new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from the container
		TrafficFortuneService  theFortuneService=annotationConfigApplicationContext.getBean
													("trafficFortuneService",TrafficFortuneService.class);
	
		myLogger.info("\n \n Main program : Around Demo App");
		
		myLogger.info("calling get Fortune");
		
		boolean tripWire=true;
		String data=theFortuneService.getFortune(tripWire);
		
		myLogger.info("\n My fortune is" + data);
		
		myLogger.info("Finished");
		
		//close the context
		annotationConfigApplicationContext.close();

	}

}
