package com.youtube.StudentManagement;
import java.sql.*;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
       Class.forName("org.postgresql.Driver");
       String url="jdbc:postgresql://localhost:5432/school";
       String user="postgres";
       String password="code";
       Connection con=DriverManager.getConnection(url,user,password);
       Scanner s=new Scanner(System.in);
       while(true) {
    	   System.out.println("===========================");
    	   System.out.println("1.View Students");
    	   System.out.println("2.Add Student");
    	   System.out.println("3.Update Student");
    	   System.out.println("4.Delete Student");
    	   System.out.println("5.Exit");
    	   System.out.println("===========================");
    	   System.out.println("ENTER YOUR CHOICE");
    	   int n=s.nextInt();
    	   Student stu=new Student(con);
    	   switch(n) {
    	   case 1: //view students
    		      stu.viewStudents();
    		      break;
    	   case 2: //add student
    		      stu.addStudent();
    		      stu.viewStudents();
    		      break;
    	   case 3:
    		      stu.updateStudent();
    		      stu.viewStudents();
    		      break;
    	   case 4:
    		      stu.deleteStudent();
    		      stu.viewStudents();
 		          break;	      
    	   case 5: 
    		      return;	      
 		   default:System.out.println("Enter valid chioce"); 
    	   }
       }
       
    }
}
