package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;	
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	//Creating Field D.I
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
		
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach:inside the default constructor");		
	}
	
	//@postConstruct Annotaion for defining init method
	
	@PostConstruct
	public void doMyStartUpStuff()
	{
		System.out.println(">>Tennis Coach: inside doMyStartpStuff ");
	}
	
	//@PreDestroy Annotaion for defining destroy method
	
		@PreDestroy
		public void doMyCleanUpStuff()
		{
			System.out.println(">>Tennis Coach: inside doMyCleanUpStuff ");
		}
	
	//@Qualifier using with constructor D.I
	/*
	@Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {

        System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
        
        fortuneService = theFortuneService;
    }
	*/
	
	//Creating Custom method for D.I
	/*
	 @Autowired
		public void doSomeCrazyStuff(FortuneService fortuneService) {
			System.out.println(">> TennisCoach:inside the doSomeCrazyStuff method");
			this.fortuneService = fortuneService;
		}
	 	*/
		
	//Creating setter method for D.I
	/*
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">> TennisCoach:inside the Setter method");
		this.fortuneService = fortuneService;
	}
	*/

	//Constructor D.I
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	
	@Override
	public String getDailyWorkout() {
		
		return "Prcatice  backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
