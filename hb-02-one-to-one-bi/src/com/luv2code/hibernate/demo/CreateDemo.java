package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory		
		SessionFactory factory=new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Instructor.class).
									addAnnotatedClass(InstructorDetail.class).
									buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {
			
			//create the objects
			/*Instructor tempInstructor=new Instructor("Santoshkumar","Raconda","santosh@gmail.com");
			InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com","Basketball");
			*/
			Instructor tempInstructor=new Instructor("Vikram","suguru","Vikram@gmail.com");
			InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com","gamer");
			
			//associate the objects together
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//Begin transaction
			session.beginTransaction();
			
			//save the instructor
			System.out.println("Saving the Instructor : " + tempInstructor);
			session.save(tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done....!!!");
			
		}
		
		finally {
			
			factory.close();
		}

	}

}
