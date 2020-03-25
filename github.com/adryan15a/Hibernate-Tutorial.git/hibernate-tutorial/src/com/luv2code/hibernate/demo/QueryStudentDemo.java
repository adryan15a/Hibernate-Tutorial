package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start tranzaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			//display the students
			
			displayStudents(theStudent);
			
			//query students: lastName='Doe'
			theStudent = session.createQuery("from Student s where s.lastName='francu'").getResultList();
			
			//display the students
			System.out.println("\n\nStudents who have last name of Francu");
			displayStudents(theStudent);
			
			//query students: lastName = 'francu' OR firstName='rares'
			theStudent = session.createQuery("from Student s where"
					 	+" s.lastName='francu' OR s.firstName='rares'").getResultList();
			
			//display the students
			System.out.println("\n\nStudents who have last name of Francu OR first name Rares");
			displayStudents(theStudent);
			
			//query students where email Like '%luvtocode.com'
			theStudent = session.createQuery("from Student s where s.email LIKE '%foo@gmail'").getResultList();
			
			//display the students
			System.out.println("\n\nStudents who email ends with luvtocode.com");
			displayStudents(theStudent);
			
			//commit tranzaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudent) {
		for(Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

}
