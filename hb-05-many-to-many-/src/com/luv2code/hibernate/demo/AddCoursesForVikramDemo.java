package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForVikramDemo {

	public static void main(String[] args) {
		
		//create session factory		
		SessionFactory factory=new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Instructor.class).
									addAnnotatedClass(InstructorDetail.class).
									addAnnotatedClass(Course.class).
									addAnnotatedClass(Review.class).
									addAnnotatedClass(Student.class).
									buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {

			//Begin transaction
			session.beginTransaction();
			
			//get the student vikram from the databases
			int id=2;
			
			Student tempStudent=session.get(Student.class, id);
			System.out.println("\nStudent name is :: " + tempStudent);
			
			System.out.println("Vikram courses are :" + tempStudent.getCourses());
			
			//create more courses
			Course tempCourse1=new Course("Rubics cube - how to fast the cube");
			Course tempCourse2=new Course("Atari 2600 - Game development"); 
			
			//add student to courses
			tempCourse1.add(tempStudent);
			tempCourse2.add(tempStudent);
			
			//save the course		
			System.out.println("\nHey i am saving the courses");
			
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
