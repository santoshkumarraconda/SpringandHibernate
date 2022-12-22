package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount,Boolean vipFlag)
	{
		System.out.println(getClass() +": Doing my Db work : Adding an Account");
	}
	
	public boolean doWork()
	{
		System.out.println(getClass() +": Doing my  work : ");
		return false;
	}
}
