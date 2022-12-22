package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public List<Account> findAccounts(Boolean tripwire){
		
		if(tripwire)
		{
			throw new RuntimeException("No soup for u");
		}
		
		List<Account> myAccount=new ArrayList<>();
		
		Account temp1=new Account("Santosh","Gold");
		Account temp2=new Account("vikram","platinum");
		Account temp3=new Account("uday","silver");
		
		myAccount.add(temp1);
		myAccount.add(temp2);
		myAccount.add(temp3);
		
		return myAccount;
		
	}
	
	
	public void addAccount(Account theAccount,Boolean vipFlag)
	{
		System.out.println(getClass() +": Doing my Db work : Adding an Account");
	}
	
	public boolean doWork()
	{
		System.out.println(getClass() +": Doing my  work : ");
		return false;
	}
	
	//addding getters and setters for the fields
	
	public String getName() {
		System.out.println(getClass() +": in getName ");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() +": in setName ");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() +": in GetServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() +": in SetServiceCode ");
		this.serviceCode = serviceCode;
	}
}
