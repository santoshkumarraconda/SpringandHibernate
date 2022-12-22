package com.luv2code.hibernate.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating a new employee object...!!!");
			Employee employee1=new Employee("Kavya","Chapala","Apple");
			Employee employee2=new Employee("Vikram","Suguru","DXC");
			Employee employee3=new Employee("Abhishek","Bhag","Cognizant");
			Employee employee4=new Employee("Narender","Gondala","Accenture");
			
			session.beginTransaction();
			
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			session.save(employee4);
			
			session.getTransaction().commit();
			
			System.out.println("Done..!!!!");
			
		} finally {
		
			factory.close();
		}

	}

}
