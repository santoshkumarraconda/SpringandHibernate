package com.luv2code.hibernate.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployee {
	
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			int employeeId=8;
			
			session= factory.getCurrentSession();
			
			session.beginTransaction();
			
			Employee tempEmployee=session.get(Employee.class,employeeId);
			
			System.out.println(tempEmployee);
			
			session.delete(tempEmployee);
			
			System.out.println(tempEmployee + "Deleted");
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			
			factory.close();
		}
	}

}
