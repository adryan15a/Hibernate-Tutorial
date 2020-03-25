package com.luv2code.hibernate.homework;

import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateEmployee {

	public static void main(String[] args) {
		//create sessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
	
	try {
	
		//create new Employee object
		System.out.println("creating a new Employee");
		//Employee e1 = new Employee("Francu", "Adrian", "Oracle");
		Employee e2 = new Employee("Francu", "Rares", "IBM");
		Employee e3 = new Employee("Francu", "Oana", "Endava");
		Employee e4 = new Employee("Francu", "Natalia", "NASA");
		Employee e5 = new Employee("Viorica", "Dancila", "psd");
		
		//start transaction
		session.beginTransaction();
	
		//save the object
		System.out.println("Saving the objects");
		//session.save(e2);
		//session.save(e3);
		//session.save(e4);
		session.save(e5);
		
		//commit transaction
		session.getTransaction().commit();
		
		System.out.println("Done!");
		}finally {
			factory.close();
		}
	}
}
