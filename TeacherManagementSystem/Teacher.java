package com.youtube.TeacherManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Teacher {
    int id;
    String name;
    String qualification;
    int experience;
    int subject_id;
	Connection con;
	Scanner s;
	public Teacher(Connection con, Scanner s) {
		super();
		this.con = con;
		this.s = s;
	}
	
	public void addTeacher() throws SQLException {
		System.out.println("Enter Teacher id");
		id=s.nextInt();
		s.nextLine();
		System.out.println("Enter Teacher name");
		name=s.nextLine();
		System.out.println("Enter Teacher qualification");
		qualification=s.nextLine();
		System.out.println("Enter Teacher experience");
		experience=s.nextInt();
		System.out.println("Enter Teacher Subject id");
		subject_id=s.nextInt();
		String query="Insert into teacher values(?,?,?,?,?)";
		PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, id);
		p.setString(2, name);
		p.setString(3, qualification);
		p.setInt(4, experience);
		p.setInt(5, subject_id);
		p.executeUpdate();
		System.out.println("Successfully Added Teacher");
	}

	public void viewTeacher() throws SQLException {
		String query="select * from teacher";
		PreparedStatement p=con.prepareStatement(query);
		ResultSet r=p.executeQuery();
		while(r.next()) {
			System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4)+" "+r.getInt(5));
		}
		
	}
	
	public void updateTeacher() throws SQLException {
		String query="Update teacher set name=?, qualification=?,experience=?,subject_id=? where id=?";
		PreparedStatement p=con.prepareStatement(query);
		System.out.println("Enter Teacher id");
		id=s.nextInt();
		s.nextLine();
		System.out.println("Enter Teacher name");
		name=s.nextLine();
		System.out.println("Enter Teacher qualification");
		qualification=s.nextLine();
		System.out.println("Enter Teacher experience");
		experience=s.nextInt();
		System.out.println("Enter Teacher Subject id");
		subject_id=s.nextInt();
		p.setString(1, name);
		p.setString(2, qualification);
		p.setInt(3, experience);
		p.setInt(4, subject_id);
		p.setInt(5, id);
		
		p.executeUpdate();
		System.out.println("Successfully Updated Teacher");
	}
	
	public void deleteTeacher() throws SQLException {
		String query="delete from teacher where id=?";
		PreparedStatement p=con.prepareStatement(query);
		System.out.println("Enter Teacher id");
		id=s.nextInt();
		
		p.setInt(1, id);
		p.executeUpdate();
		System.out.println("Successfully Deleted Teacher");
	}
	
	
	
}
