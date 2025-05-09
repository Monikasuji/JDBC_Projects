package com.youtube.StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
   int id;
   String name;
   String Dob;
   String Phone_number;
   Scanner s=new Scanner(System.in);
   
   Connection con;
   
   public Student(Connection con) {
	super();
	this.con = con;
}

public void viewStudents() throws SQLException {
	   Statement st=con.createStatement();
	   ResultSet r=st.executeQuery("select * from student");
	   while(r.next()) {
		   System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4));
	   }
   }


public void addStudent() throws SQLException {
	String query="insert into student values(?,?,?,?)";
	PreparedStatement p= con.prepareStatement(query);
	System.out.println("Enter the Student ID");
	id=s.nextInt();
	s.nextLine();
	System.out.println("Enter the Student NAME");
	name=s.nextLine();
	System.out.println("Enter the Student DOB");
	Dob=s.nextLine();
	System.out.println("Enter the Student PHONE NUMBER");
	Phone_number=s.nextLine();
	p.setInt(1, id);
	p.setString(2, name);
	p.setString(3, Dob);
	p.setString(4, Phone_number);
	p.executeUpdate();
	System.out.println("SUCCESSFULLY ADDED STUDENT");
	System.out.println("----------------------------");
}



public void updateStudent() throws SQLException {

        System.out.println("Enter Student ID to update: ");
        int id = s.nextInt();
        s.nextLine();
        String query="UPDATE student SET name=? WHERE id=?";
        PreparedStatement p= con.prepareStatement(query);
        System.out.println("Enter the student name");
    	name=s.nextLine();
    	p.setString(1, name);
    	p.setInt(2, id);
    	p.executeUpdate();
    	System.out.println("Successfully updated the student name");
    	System.out.println("--------------------------------------");
    }


public void deleteStudent() throws SQLException {
	String query="delete from student where id=?";
	PreparedStatement p= con.prepareStatement(query);
	System.out.println("Enter Student ID to delete: ");
	id=s.nextInt();
	p.setInt(1, id);
	p.executeUpdate();
	System.out.println("Successfully delete the student");
	System.out.println("--------------------------------");
}

}

