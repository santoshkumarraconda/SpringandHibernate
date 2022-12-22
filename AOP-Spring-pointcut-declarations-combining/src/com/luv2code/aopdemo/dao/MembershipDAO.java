package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public Boolean addSillyMember()
	{
		System.out.println(getClass() +": adding an account in the membership DAO");
		
		return true;
	}

	public void goToSleep()
	{
		System.out.println(getClass() +": am going to sleep now");

	}
}
