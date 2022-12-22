package com.luv2code.springdemo;

public class Baseballcoch implements Coach{
	
	//define a private field for dependency
	private FortuneService fortuneService;
	
	//define A CONSTRUCTOR for dependency injection
	public Baseballcoch(FortuneService thefortuneService)
	{
		fortuneService=thefortuneService;
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "spend atleast 30 min on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
