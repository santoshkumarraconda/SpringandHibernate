package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	
	private String country;
	
	private  LinkedHashMap<String , String> countryOptions;
	
	private String favouriteLanguage;
	
	private String[] operatingSystem;
	
	public Student()
	{
		//populate country options : used ISO country code
		countryOptions=new LinkedHashMap<>();
		
		countryOptions.put("In", "India");
		countryOptions.put("USA", "America");
		countryOptions.put("AUS", "Australia");
		countryOptions.put("DE", "Germany");
		countryOptions.put("FR", "France");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	

	
	
	
}
