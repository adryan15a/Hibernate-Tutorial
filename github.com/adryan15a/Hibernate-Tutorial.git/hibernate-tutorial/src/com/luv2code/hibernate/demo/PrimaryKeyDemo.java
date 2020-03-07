package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				//create a session
				Session session = factory.getCurrentSession();
				
				try {
					
					//create 3 students objects
					System.out.println("Creating 3 student object");
					
					Student student1 = new Student("adrian","francu","adi@lovtocode.com");
					
					Student student2 = new Student("octavian","vaduva","vv@lovtocode.com");
					
					Student student3 = new Student("rares","gabriel","rr@lovtocode.com");
					
					
					
					//start tranzaction
					session.beginTransaction();
					
					//save tranzaction
					System.out.println("Saving the students...");
					session.save(student1);
					session.save(student2);
					session.save(student3);
					
					//commit tranzaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
				}finally {
					factory.close();
				}

	}

}
