package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory		
		SessionFactory factory=new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Student.class).
									buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {
			
			//create a student object
			System.out.println("Creating new Student Java object....!!!");
			Student tempStudent=new Student("santosh","kumar","santosh@gmail.com");
			
			//Begin transaction
			session.beginTransaction();
			
			//save the Student java object
			System.out.println("saving Student Java object....!!!");
			session.save(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done....!!!");
			
		}
		
		finally {
			
			factory.close();
		}

	}

}
