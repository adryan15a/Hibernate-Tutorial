package com.luv2code.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;


public class ReadStudentDemo {

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
			
			Student student1 = new Student("daffy","duck","daffy@lovtocode.com");
			
			//start tranzaction
			session.beginTransaction();
			
			//save tranzaction
			System.out.println("Saving the student...");
			System.out.println(student1);
			session.save(student1);
			
			
			//commit tranzaction
			session.getTransaction().commit();
			
			
			//My new code
			
			//find out the student`s` id: primary key
			System.out.println("saved student. Generated id: "+ student1.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting studnet with id: " + student1.getId());
			
			Student myStudent = session.get(Student.class, student1.getId());
			
			System.out.println("Get complete: "+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
