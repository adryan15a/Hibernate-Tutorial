package com.luv2code.hibernate.homework;

import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateEmployee {

	public static void main(String[] args) {
		//create sessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
	
	try {
		
		int target = 3;
	
		//start transaction
		session.beginTransaction();
		
		//get object
		System.out.println("Retreving object");
		Employee e3 = session.get(Employee.class,target);
		
		//update object
		e3.setCompany("AMAZON");
		
		//commit transaction
		session.getTransaction().commit();
		
		System.out.println("Done!");
		}finally {
			factory.close();
		}
	}
}
