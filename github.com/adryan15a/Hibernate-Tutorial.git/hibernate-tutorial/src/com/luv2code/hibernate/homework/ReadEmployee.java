package com.luv2code.hibernate.homework;

import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadEmployee {

	public static void main(String[] args) {
		//create sessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
	
	try {
		
		//start transaction
		session.beginTransaction();
		
		//read all employees
		System.out.println("Snatching all empoyees");
		List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
		
		//show all employees
		showEmployee(theEmployees);
		
		//read an employee by id
		int target = 2;
		System.out.println("Snatching Employee with id = 2");
		Employee theEmployee = session.get(Employee.class,target);
		
		//show employee
		System.out.println(theEmployee);
		
		//commit transaction
		System.out.println("Done!");
		session.getTransaction().commit();
		
		}finally {
			factory.close();
		}
	}

	private static void showEmployee(List<Employee> theEmployees) {
		for(Employee emp : theEmployees) {
			System.out.println("\n"+emp);
		}
	}
}
