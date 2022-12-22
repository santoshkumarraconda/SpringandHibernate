package com.luv2code.hibernate.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class UpdateEmployee {
	
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			int empid=1;
			
			session=factory.getCurrentSession();
			
			session.beginTransaction();
			
			Employee employee=session.get(Employee.class, empid);
			
			employee.setFirstName("Tinku");
			
			session.getTransaction().commit();
			
			//new Code
			
			session=factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("update Employee set company='Top Java Coders'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		finally {
			
			factory.close();
		}
								
	}

}
