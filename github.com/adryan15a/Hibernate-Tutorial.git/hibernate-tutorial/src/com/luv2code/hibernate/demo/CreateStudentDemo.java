package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;


public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create the student object
			System.out.println("Creating a new student object");
			
			Student student1 = new Student("gigi","muschi","gigi@lovtocode.com");
			
			//start tranzaction
			session.beginTransaction();
			
			//save tranzaction
			System.out.println("Saving the student...");
			session.save(student1);
			
			
			//commit tranzaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
