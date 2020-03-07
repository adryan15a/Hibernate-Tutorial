package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user="root";
		String pass="inculise9840";
		
		try {
			System.out.println("Connecting to DB"+jdbcUrl);
			
			Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection successful!!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
