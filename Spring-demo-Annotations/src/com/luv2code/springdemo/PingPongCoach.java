package com.luv2code.springdemo;

public class PingPongCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public PingPongCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	/*public PingPongCoach() {
		System.out.println(">> PingPongCoachinside default constructor");
	}*/

	@Override
	public String getDailyWorkout() {
		
		return "welcome to PingPongCoach";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
