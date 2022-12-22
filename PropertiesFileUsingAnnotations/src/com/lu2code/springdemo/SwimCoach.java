package com.lu2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
	
	@Autowired
	private FortuneService fortuneService;

	@Value("${email}")
	private String email;
	
	@Value("${team}")
	private String team;
	
	@Value("${batch}")
	private String batch;

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	public String getTeam() {
		return team;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}
	
	public String getBatch() {
		return batch;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
