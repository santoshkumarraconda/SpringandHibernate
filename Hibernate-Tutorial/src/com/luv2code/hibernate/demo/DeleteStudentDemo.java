package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory		
		SessionFactory factory=new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Student.class).
									buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {
			
			int studentId=4;
			
			//create Session for retrieving data from db
			session=factory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			//retrieve the student bases on the id(primary key)
			System.out.println("\n Getting student with id :" + studentId);
			
			Student myStudent=session.get(Student.class, studentId);
		
			//System.out.println("Deleting student");
		
			//deleting the Student
			//session.delete(myStudent);
			
			//using the alternate aproach delete student id=7
			System.out.println("using the alternate aproach delete student id=7");
			session.createQuery("delete from Student where id=7").executeUpdate();
			
			//Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Student Deleted Done...!!!!");
	
			System.out.println("\n\n Done...!!!!");
			
		}
		
		finally {
			
			factory.close();
		}

	}

}
