package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			//option 2: Hibernate Query with HQL
			
			//get the instructor from DB
			int id=1;
			
			Query<Instructor> query= session.createQuery("select i from Instructor i " 
															+ "JOIN FETCH i.courses " 
																+ "where i.id=:theInstructorId",
																Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId", id);
			
			//execute the query and get instructor
			Instructor tempInstructor=query.getSingleResult();
			
			System.out.println("Luv2Code : Instructor :" + tempInstructor);
			
			//get courses for the instructor
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			session.close();
			
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
