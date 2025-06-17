package com.youtube.TeacherManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Schedule {
 Connection con;
 Scanner s;
 int id;
 String subject,date,time;
public Schedule(Connection con, Scanner s) {
	super();
	this.con = con;
	this.s = s;
}

public void viewSchedule() throws Exception {
	String query ="select * from schedule";
	PreparedStatement p=con.prepareStatement(query);
	ResultSet r=p.executeQuery();
	while(r.next()) {
		System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4));
	}
}

public void addSchedule() throws Exception {
	String query ="insert into schedule values(?,?,?,?)";
	PreparedStatement p=con.prepareStatement(query);
	System.out.println("Enter Subject id");
	id=s.nextInt();
	s.nextLine();
	System.out.println("Enter Subject name");
	subject=s.nextLine();
	System.out.println("Enter Date");
	date=s.nextLine();
	System.out.println("Enter Time");
	time=s.nextLine();
	p.setInt(1, id);
	p.setString(2, subject);
	p.setString(3, date);
	p.setString(4, time);
	p.executeUpdate();
	System.out.println("Successfully Added Schedule");
	
}

public void updateSchedule() throws SQLException {
	String query="UPDATE schedule Set subject=?,day=?,time=? where id=?";
	PreparedStatement p=con.prepareStatement(query);
	System.out.println("Enter Subject id");
	id=s.nextInt();
	s.nextLine();
	System.out.println("Enter Subject name");
	subject=s.nextLine();
	System.out.println("Enter Date");
	date=s.nextLine();
	System.out.println("Enter Time");
	time=s.nextLine();
	p.setString(1, subject);
	p.setString(2, date);
	p.setString(3, time);
	p.setInt(4, id);
	p.executeUpdate();
	System.out.println("Successfully Updated Schedule");
	
}

public void deleteSchedule() throws SQLException {
	String query="Delete from schedule where id=?";
	PreparedStatement p=con.prepareStatement(query);
	System.out.println("Enter Subject id");
	id=s.nextInt();
	p.setInt(1, id);
	p.executeUpdate();
	System.out.println("Successfully Deleted Schedule");
}
public void detailsofSchedule() throws SQLException {
	String query="select t.id,t.name,s.subject,s.day,s.time from teacher t inner join schedule s on t.subject_id=s.id";
	PreparedStatement p=con.prepareStatement(query);
	ResultSet r=p.executeQuery();
	while(r.next()) {
		System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4)+" "+r.getString(5));
	}
}
}
