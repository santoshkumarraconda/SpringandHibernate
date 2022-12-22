package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String email,team;
	
	//no -arg constructor --> Spring internally calls this
	public CricketCoach()
	{
		System.out.println("Cricket Coach: ur inside the no-arg constructor");
	}
	
		//Setter methods for team and email for the coach

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			System.out.println("Cricket Coach: ur inside the setter email method --setEmail");
			this.email = email;
		}

		public String getTeam() {
			return team;
		}

		public void setTeam(String team) {
			System.out.println("Cricket Coach: ur inside the setter Team method --setTeam");
			this.team = team;
		}
		
	//our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach: ur inside the setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		
		return "practice batting for 30 min";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
