package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

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
			
			
			//Begin transaction
			session.beginTransaction();

			//get the instructor details
			int id=1;
			
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class, id);
			
			//print the instructor details
			System.out.println("tempInstructorDetail:" + tempInstructorDetail);
			
			//print the associated instructor details
			System.out.println("the associated instructor:" + tempInstructorDetail.getInstructor());
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done....!!!");
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		finally {
			
			//closing the session
			session.close();
			
			factory.close();
		}

	}

}
