package com.youtube.TeacherManagementSystem;

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
        int n,m;
        Scanner s=new Scanner(System.in);
        Teacher t=new Teacher(con,s);
        Schedule st=new Schedule(con,s);
        while(true) {
        	System.out.println("1.Teacher Management");
        	System.out.println("2.Schedule Management");
        	System.out.println("3.Exit");
        	System.out.println("Enter your chioce");
        	m=s.nextInt();
        switch(m) {
               case 1:
                     while(true) {
				        	System.out.println("===========================");
				        	System.out.println("1.Add Teacher");
				        	System.out.println("2.View Teacher");
				        	System.out.println("3.Update Teacher");
				        	System.out.println("4.Delete Teacher");
				        	System.out.println("5.Exit");
				        	System.out.println("===========================");
				        	System.out.println("Enter your chioce");
				        	n=s.nextInt();
				        	
				        	switch(n) {
				        	case 1: t.addTeacher(); t.viewTeacher(); break;
				        	case 2: t.viewTeacher(); break;
				        	case 3: t.updateTeacher(); t.viewTeacher(); break;
        	                case 4: t.deleteTeacher(); t.viewTeacher(); break;
				        	case 5: break;         
				        	}
				        	if(n==5) break;
             }
             break;
		        case 2: 
		        	while(true) {
		            	System.out.println("===========================");
		            	System.out.println("1.Add Schedule");
		            	System.out.println("2.View Schedule");
		            	System.out.println("3.Update Schedule");
		            	System.out.println("4.Delete Schedule");
		            	System.out.println("5.Details Schedule");
		            	System.out.println("6.Exit");
		            	System.out.println("===========================");
		            	System.out.println("Enter your chioce");
		            	n=s.nextInt();
		            	switch(n) {
		            	case 1: st.addSchedule(); st.viewSchedule(); break;
		            	case 2: st.viewSchedule(); break;
		            	case 3: st.updateSchedule(); st.viewSchedule(); break;
		            	case 4: st.deleteSchedule(); st.viewSchedule(); break;
		            	case 5: st.detailsofSchedule(); break;
		            	case 6: break;         
		            	}
		            	if(n==6) break;
		            }
		        	break;
                case 3:
                	System.out.println("Exiting..."); 
                    s.close(); 
                    System.exit(0);
    }
    }
       }
}
