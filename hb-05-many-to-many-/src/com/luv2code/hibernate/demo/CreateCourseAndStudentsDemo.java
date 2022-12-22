package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			//create a course
			Course tempCourse=new Course("Pacman- how to score one million points");
			
			System.out.println("course name is :"+tempCourse);
			
			//saving the course
			System.out.println("\nSaving the course: " + tempCourse);
			session.save(tempCourse);
			System.out.println("saved the course");
			
			//create the students
			Student tempStudent1=new Student("Santosh","Raconda","santosh@gmail.com");
			Student tempStudent2=new Student("Vikram","Suguru","vikram@gmail.com");
			Student tempStudent3=new Student("Kavya","Chapala","kavya@gmail.com");
			
			//adding the student to course
			tempCourse.add(tempStudent1);
			tempCourse.add(tempStudent2);
			tempCourse.add(tempStudent3);
			
			//save the students
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			System.out.println("saved students : " + tempCourse.getStudents());
			
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
