package com.luv2code.hibernate.homework;

import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteEmployee {

	public static void main(String[] args) {
		//create sessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
	
	try {
		
		int target = 5;
	
		//start transaction
		session.beginTransaction();
		
		//get object
		System.out.println("Retreving object");
		Employee e5 = session.get(Employee.class,target);
		
		//delete object
		System.out.println("Deleting target");
		//session.delete(e5);
		
		//OR!!
		
		session.createQuery("delete from Employee where id=5").executeUpdate();
		
		//commit transaction
		session.getTransaction().commit();
		
		System.out.println("Done!");
		}finally {
			factory.close();
		}
	}
}
