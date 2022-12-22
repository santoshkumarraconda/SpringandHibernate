package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//Create an array of Strings
	
	private String[] data= {
			"Beware of wolf in sheep clothing",
			"Diligence is mother of good luch",
			"The Journey is the reward"
			};

	//Create a random number generator
	
	private Random myRandom=new Random();
	
	@Override
	public String getFortune() {
		
		int index=myRandom.nextInt(data.length);
		System.out.println(index);
		String theFortune=data[index];
		return theFortune;
	}

}
