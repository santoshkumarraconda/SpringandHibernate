package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory		
		SessionFactory factory=new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Student.class).
									buildSessionFactory();
		
		//create a session
		Session session=factory.getCurrentSession();
		
		try {
			
			//Begin transaction
			session.beginTransaction();
			
			//query the students
			List<Student> theStudents=session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
			
			//query the students whose lastname is rakonda
			theStudents=session.createQuery("from Student s where s.lastName='Bhag'").getResultList();
			
			//display the students
			System.out.println("\n\n displaying the student whose lastname ends with Bhag");
			displayStudents(theStudents);
			
			//query the student lastname=chap or firstname=kavya
			theStudents=session.createQuery("from Student s where" + " s.firstName='kavya' OR s.lastName='Rakonda'").getResultList();
			
			//display the above query students
			System.out.println("\n\n displaying the student whih contains first name or lastname ");
			displayStudents(theStudents);
			
			//query the students whose emails ends with @gmail.com
			theStudents=session.createQuery("from Student s where" + " s.email like '%@gmai.com'" ).getResultList();
			
			//display the students
			System.out.println("\n\n displaying the student whose emails ends with @gmai.com");
			displayStudents(theStudents);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done....!!!");
			
		}
		
		finally {
			
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
