package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		int id=7;
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
			Student tempStudent=new Student("Narender","Gondala","Narender@gmail.com");
			
			//Begin transaction
			session.beginTransaction();
			
			//save the Student java object
			System.out.println("saving Student Java object....!!!");
			
			System.out.println(tempStudent);
			
			session.save(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//my New CODE
			
			//find out the Student's id : primary key
			System.out.println("saved Student. Generated id:" + tempStudent.getId());
			
			//create Session for retrieving data from db
			session=factory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			//retrieve the student bases on the id(primary key)
			System.out.println("\n Getting student with id :" + tempStudent.getId());
			
			Student myStudent=session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete :" + myStudent);
			
			//Commit the transaction
			session.getTransaction().commit();
			

			//my New CODE for generating the id
			
			//find out the Student's id : primary key
			System.out.println("saved Student. Generated id:" + id);
			
			//create Session for retrieving data from db
			session=factory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			//retrieve the student bases on the id(primary key)
			System.out.println("\n Getting student with id :" + id);
			
			Student myStud=session.get(Student.class, id);
			
			System.out.println("Get Complete :" + myStud);
			
			//Commit the transaction
			session.getTransaction().commit();
			System.out.println("Done....!!!");
			
		}
		
		finally {
			
			factory.close();
		}

	}

}
