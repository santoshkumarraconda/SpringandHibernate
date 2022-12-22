package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			
			int theId=2;
			
			//Begin transaction
			session.beginTransaction();
			
			//get the object and delete it
			
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			System.out.println("Found Instructor :"+ tempInstructor);
			
			//Delete the instructor by checking whether it is not null
			
			if(tempInstructor!=null)
			{
				System.out.println("Deleting the Instructor "+ tempInstructor);
				//Note:will also delete all the details in instructor_details table bcz of CascaseType.ALL
				session.delete(tempInstructor);
			}		
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done....!!!");
			
		}
		
		finally {
			
			factory.close();
		}

	}

}
