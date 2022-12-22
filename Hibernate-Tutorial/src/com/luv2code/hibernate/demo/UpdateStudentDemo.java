package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory		
		SessionFactory factory=new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Student.class).
									buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {
			
			int studentId=5;
			
			//create Session for retrieving data from db
			session=factory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			//retrieve the student bases on the id(primary key)
			System.out.println("\n Getting student with id :" + studentId);
			
			Student myStudent=session.get(Student.class, studentId);
			
			System.out.println("updating student");
			
			myStudent.setFirstName("sainath");
			myStudent.setLastName("sangu");
			myStudent.setEmail("sainath@gmail.com");
			
			//Commit the transaction
			session.getTransaction().commit();
			
			//New Code
			session=factory.getCurrentSession();
			
			session.beginTransaction();
			
			//update email for all students
			System.out.println("update email for all students");
			
			session.createQuery("update Student set email='singles@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("\n\n Done...!!!!");
			
		}
		
		finally {
			
			factory.close();
		}

	}

}
