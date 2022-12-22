package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			//create some courses
			Course tempCourse1=new Course("Maths");
			Course tempCourse2=new Course("Science");
			
			//add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			//save the courses			
			session.save(tempCourse1);
			session.save(tempCourse2);			
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done....!!!");
			
		}
		
		finally {
			//add cleanup code
			session.close();
			
			factory.close();
		}

	}

}
