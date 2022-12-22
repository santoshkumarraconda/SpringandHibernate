package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		//create session factory		
		SessionFactory factory=new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Instructor.class).
									addAnnotatedClass(InstructorDetail.class).
									addAnnotatedClass(Course.class).
									buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {

			//Begin transaction
			session.beginTransaction();
			
			//get the instructor from DB
			int id=1;
			
			Instructor tempInstructor=session.get(Instructor.class, id);
			
			System.out.println("Luv2Code : Instructor :" + tempInstructor);
			
			//get courses for the instructor
			System.out.println("Luv2Code : Courses:" + tempInstructor.getCourses());
			
			//commit the transaction
			session.getTransaction().commit();
			
			session.close();
			
			//option 1 : calling getter method while the session is open
			System.out.println("Luv2Code: Hey the session is now closed!!");
			
			System.out.println("Luv2Code : Courses:" + tempInstructor.getCourses());
			
			System.out.println("Luv2Code : Done....!!!");
			
		}
		
		finally {
			//add cleanup code
			session.close();
			
			factory.close();
		}

	}

}
