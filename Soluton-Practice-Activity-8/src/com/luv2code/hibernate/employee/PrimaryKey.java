package com.luv2code.hibernate.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.luv2code.hibernate.demo.entity.Employee;

public class PrimaryKey {
	
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Employee.class).
									buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			Employee employee=new Employee("Gauri","Likhe","Capgemini");
			
			session.beginTransaction();
			
			session.save(employee);
			
			session.getTransaction().commit();
			
			//My New code to read the data entered above
			
			session=factory.getCurrentSession();
			
			session.beginTransaction();
			
			Employee tempEmployee=session.get(Employee.class, employee.getId());
			
			System.out.println("Get employee" + tempEmployee);
			
			session.getTransaction().commit();
			
			System.out.println("Done !!!!");
			
		}
		
		finally {
			
			factory.close();
		}
		
	}

}
