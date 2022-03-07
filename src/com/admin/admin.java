package com.admin;

import java.io.DataInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;  

public class admin {
	

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException   
	 {  
		try{
		 Class.forName("com.mysql.cj.jdbc.Driver");

	     // variables
	     final String url = "jdbc:mysql:///mini_project";
	     final String user = "root";
	     final String password = "root";

	     // establish the connection
	     Connection con = DriverManager.getConnection(url, user, password);

	   /*  // display status message
	     if (con == null) {
	        System.out.println("JDBC connection is not established");
	        return;
	     } else
	        System.out.println("Congratulations," + 
	             " JDBC connection is established successfully.\n");
	  */
	     String choice="";
	       
	     Statement stmt = con.createStatement();  
	     Scanner sc = new Scanner(System.in);  
	     System.out.print("Enter the user id : ");  
	     String str1 = sc.next();  
	     System.out.print("Enter the password : ");  
	     String str2 = sc.next(); 
do { 
	   	  ResultSet rs = stmt.executeQuery("select * from admin where Username='" + str1 + "' and Password='" + str2 + "'");  
	   	  int cnt=0; 
	   	if(rs.next())
	   	 {
	   	   cnt=rs.getInt(1);
	   	 }
	   	if(cnt==0)
	   	{	 
	   		System.out.println("Invalid user name or password");  
	   		break;
	   	}
	   	 
	   	  else  
	   	   System.out.println("\\t\\t\\t\\tWELCOME TO CRICKET MATCH");  
	  System.out.println("\nADMIN CHOICE \n1.ADD \n2.DELETE \n3.GENERAL PLAYER AND SCORE BOARD UPDATE \n4.UPDATE TOTAL SCORE \n5.EXIT");
	  //int b=sc.nextInt();
	 
	
	  
	 	 System.out.print("ENTER OPTION : ");
	      int  operation=sc.nextInt();
	      
	      switch (operation)    
	      { 
	      
	      case 1 :
	    	  do {
	          System.out.println("\t\tAdd Options \n1.Add country  \n2.Add player");
	          System.out.print("\nENTER OPTION : ");
	          int  option1=sc.nextInt();
	          switch (option1)    
	          {                                    
	              case 1 :
	            	 
	              System.out.println("\nAdd country");
	              
	              
	              DataInputStream KB1=new DataInputStream(System.in);

		  			//input player id
		  			//System.out.print("Enter Country ID: ");
		  			//String Id=KB1.readLine();
		  			//input player name
		  			System.out.print("Enter Country Name: ");
		  			@SuppressWarnings("deprecation") String Team_Name=KB1.readLine();
		  			
	
					//creating object of PreparedStatement class and passing parameter (?)
		  			PreparedStatement smt=con.prepareStatement("insert into teams (team_name) values(?)");

		  			// set the values
		  			//smt.setString(1, Id);
		  			smt.setString(1, Team_Name);

		  			//to execute update
		  			smt.executeUpdate();
		  			System.out.println("Record Submitted....");
	              break;
	            	  
	              case 2 :
	              System.out.println("\nAdd player");
	              do { 
	     			 System.out.println("\nADD PLAYER DETAILS \n1.India \n2.Australia \n3.England"
	     					             +"\n4.West Indies \n5.South Africa");
	     	          System.out.print("\nENTER OPTION : ");
	     	          int  p1=sc.nextInt();
	     	     
	     	      switch (p1)    
	     	        {   
	     	       case 1:
	     	    	    System.out.println("\nAdd Indian Player Details");
	     	    	    DataInputStream KB20=new DataInputStream(System.in);

	     	              
	     	  			System.out.print("Enter Name: ");
	     	  			@SuppressWarnings("deprecation") String n=KB20.readLine();
	     	  			//input employee Date Of Birth
	     	  			System.out.print("Enter Type: ");
	     	  			@SuppressWarnings("deprecation") String t=KB20.readLine();
	     	  			//input employee city
	     	  			System.out.print("Enter Team_ID: ");
	     	  			@SuppressWarnings("deprecation") String tid=KB20.readLine();
	     	  			System.out.print("Enter Status: ");
	     	  			@SuppressWarnings("deprecation") String sid=KB20.readLine();
	     	  			System.out.print("Enter 4s: ");
	     	  			@SuppressWarnings("deprecation") String m=KB20.readLine();
	     	  			System.out.print("Enter 6s: ");
	     	  			@SuppressWarnings("deprecation") String o=KB20.readLine();
	     	  			System.out.print("Enter Runs: ");
	     	  			@SuppressWarnings("deprecation") String p=KB20.readLine();
	     	  			System.out.print("Enter overs: ");
	     	  			@SuppressWarnings("deprecation") String q=KB20.readLine();
	     	  			System.out.print("Enter run: ");
	     	  			@SuppressWarnings("deprecation") String r=KB20.readLine();
	     	  			System.out.print("Enter maiden: ");
	     	  			@SuppressWarnings("deprecation") String s=KB20.readLine();
	     	  			System.out.print("Enter wickets: ");
	     	  			@SuppressWarnings("deprecation") String st=KB20.readLine();
	     	  		

	     	  			//creating object of PreparedStatement class and passing parameter (?)
	     	  			PreparedStatement stmt1=con.prepareStatement(" insert into indian_players (name,type,team_id,Status,4s,6s,Runs,overs,run,maiden,wickets) values(?,?,?,?,?,?,?,?,?,?,?)");

	     	  			// set the values
	     	  			
	     	  			stmt1.setString(1, n);
	     	  			stmt1.setString(2, t);
	     	  			stmt1.setString(3, tid);
	     	  			stmt1.setString(4, sid);
	     	  			stmt1.setString(5, m);
	     	  			stmt1.setString(6, o);
	     	  			stmt1.setString(7, p);
	     	  			stmt1.setString(8, q);
	     	  			stmt1.setString(9, r);
	     	  			stmt1.setString(10, s);
	     	  			stmt1.setString(11, st);


	     	  			//to execute update
	     	  			stmt1.executeUpdate();
	     	  			System.out.println("Record Submitted....");
	     	              break;
	     	            	  
	     	              case 2 :
	     	            	  System.out.println("\nAdd Australian Player Details");
	     	  	    	    DataInputStream KB21=new DataInputStream(System.in);
	     	  	    	    
	     	  	    		System.out.print("Enter Name: ");
	     		  			@SuppressWarnings("deprecation") String n1=KB21.readLine();
	     		  			//input employee Date Of Birth
	     		  			System.out.print("Enter Type: ");
	     		  			@SuppressWarnings("deprecation") String t1=KB21.readLine();
	     		  			//input employee city
	     		  			System.out.print("Enter Team_ID: ");
	     		  			@SuppressWarnings("deprecation") String tid1=KB21.readLine();
	     		  			System.out.print("Enter Status: ");
	     		  			@SuppressWarnings("deprecation") String sid1=KB21.readLine();
	     		  			System.out.print("Enter 4s: ");
	     		  			@SuppressWarnings("deprecation") String m1=KB21.readLine();
	     		  			System.out.print("Enter 6s: ");
	     		  			@SuppressWarnings("deprecation") String o1=KB21.readLine();
	     		  			System.out.print("Enter Runs: ");
	     		  			@SuppressWarnings("deprecation") String p11=KB21.readLine();
	     		  			System.out.print("Enter overs: ");
	     		  			@SuppressWarnings("deprecation") String q1=KB21.readLine();
	     		  			System.out.print("Enter run: ");
	     		  			@SuppressWarnings("deprecation") String r1=KB21.readLine();
	     		  			System.out.print("Enter maiden: ");
	     		  			@SuppressWarnings("deprecation") String s1=KB21.readLine();
	     		  			System.out.print("Enter wickets: ");
	     		  			@SuppressWarnings("deprecation") String st1=KB21.readLine();
	     		  		

	     		  			//creating object of PreparedStatement class and passing parameter (?)
	     		  			PreparedStatement stmt2=con.prepareStatement(" insert into australian players (name,type,team_id,Status,4s,6s,Runs,overs,run,maiden,wickets) values(?,?,?,?,?,?,?,?,?,?,?)");

	     		  			// set the values
	     		  			
	     		  			stmt2.setString(1, n1);
	     		  			stmt2.setString(2, t1);
	     		  			stmt2.setString(3, tid1);
	     		  			stmt2.setString(4, sid1);
	     		  			stmt2.setString(5, m1);
	     		  			stmt2.setString(6, o1);
	     		  			stmt2.setString(7, p11);
	     		  			stmt2.setString(8, q1);
	     		  			stmt2.setString(9, r1);
	     		  			stmt2.setString(10, s1);
	     		  			stmt2.setString(11, st1);


	     		  			//to execute update
	     		  			stmt2.executeUpdate();
	     		  			System.out.println("Record Submitted....");    
	     	  	 
	     	  	    	 break;
	     	               case 3:
	     	            	   System.out.println("\nAdd England  Player Details");
	     		  	    	    DataInputStream KB22=new DataInputStream(System.in);
	     		  	    	    
	     		  	    		System.out.print("Enter Name: ");
	     			  			@SuppressWarnings("deprecation") String n2=KB22.readLine();
	     			  			//input employee Date Of Birth
	     			  			System.out.print("Enter Type: ");
	     			  			@SuppressWarnings("deprecation") String t2=KB22.readLine();
	     			  			//input employee city
	     			  			System.out.print("Enter Team_ID: ");
	     			  			@SuppressWarnings("deprecation") String tid2=KB22.readLine();
	     			  			System.out.print("Enter Status: ");
	     			  			@SuppressWarnings("deprecation") String sid2=KB22.readLine();
	     			  			System.out.print("Enter 4s: ");
	     			  			@SuppressWarnings("deprecation") String m2=KB22.readLine();
	     			  			System.out.print("Enter 6s: ");
	     			  			@SuppressWarnings("deprecation") String o2=KB22.readLine();
	     			  			System.out.print("Enter Runs: ");
	     			  			@SuppressWarnings("deprecation") String p12=KB22.readLine();
	     			  			System.out.print("Enter overs: ");
	     			  			@SuppressWarnings("deprecation") String q2=KB22.readLine();
	     			  			System.out.print("Enter run: ");
	     			  			@SuppressWarnings("deprecation") String r2=KB22.readLine();
	     			  			System.out.print("Enter maiden: ");
	     			  			@SuppressWarnings("deprecation") String s2=KB22.readLine();
	     			  			System.out.print("Enter wickets: ");
	     			  			@SuppressWarnings("deprecation") String st2=KB22.readLine();
	     			  		

	     			  			//creating object of PreparedStatement class and passing parameter (?)
	     			  			PreparedStatement stmt3=con.prepareStatement(" insert into england players (name,type,team_id,Status,4s,6s,Runs,overs,run,maiden,wickets) values(?,?,?,?,?,?,?,?,?,?,?)");

	     			  			// set the values
	     			  			
	     			  			stmt3.setString(1, n2);
	     			  			stmt3.setString(2, t2);
	     			  			stmt3.setString(3, tid2);
	     			  			stmt3.setString(4, sid2);
	     			  			stmt3.setString(5, m2);
	     			  			stmt3.setString(6, o2);
	     			  			stmt3.setString(7, p12);
	     			  			stmt3.setString(8, q2);
	     			  			stmt3.setString(9, r2);
	     			  			stmt3.setString(10, s2);
	     			  			stmt3.setString(11, st2);


	     			  			//to execute update
	     			  			stmt3.executeUpdate();
	     			  			System.out.println("Record Submitted....");
	     		  	    	    
	     		  	    	    
	     	  		  
	     		  		break;
	     	               case 4:
	     	            	   System.out.println("\nAdd West Indies Player Details");
	     		  	    	    DataInputStream KB23=new DataInputStream(System.in);
	     		  	    	    
	     		  	    		System.out.print("Enter Name: ");
	     			  			@SuppressWarnings("deprecation") String n3=KB23.readLine();
	     			  			//input employee Date Of Birth
	     			  			System.out.print("Enter Type: ");
	     			  			@SuppressWarnings("deprecation") String t3=KB23.readLine();
	     			  			//input employee city
	     			  			System.out.print("Enter Team_ID: ");
	     			  			@SuppressWarnings("deprecation") String tid3=KB23.readLine();
	     			  			System.out.print("Enter Status: ");
	     			  			@SuppressWarnings("deprecation") String sid3=KB23.readLine();
	     			  			System.out.print("Enter 4s: ");
	     			  			@SuppressWarnings("deprecation") String m3=KB23.readLine();
	     			  			System.out.print("Enter 6s: ");
	     			  			@SuppressWarnings("deprecation") String o3=KB23.readLine();
	     			  			System.out.print("Enter Runs: ");
	     			  			@SuppressWarnings("deprecation") String p13=KB23.readLine();
	     			  			System.out.print("Enter overs: ");
	     			  			@SuppressWarnings("deprecation") String q3=KB23.readLine();
	     			  			System.out.print("Enter run: ");
	     			  			@SuppressWarnings("deprecation") String r3=KB23.readLine();
	     			  			System.out.print("Enter maiden: ");
	     			  			@SuppressWarnings("deprecation") String s3=KB23.readLine();
	     			  			System.out.print("Enter wickets: ");
	     			  			@SuppressWarnings("deprecation") String st3=KB23.readLine();
	     			  		

	     			  			//creating object of PreparedStatement class and passing parameter (?)
	     			  			PreparedStatement stmt4=con.prepareStatement(" insert into west indies players (name,type,team_id,Status,4s,6s,Runs,overs,run,maiden,wickets) values(?,?,?,?,?,?,?,?,?,?,?)");

	     			  			// set the values
	     			  			
	     			  			stmt4.setString(1, n3);
	     			  			stmt4.setString(2, t3);
	     			  			stmt4.setString(3, tid3);
	     			  			stmt4.setString(4, sid3);
	     			  			stmt4.setString(5, m3);
	     			  			stmt4.setString(6, o3);
	     			  			stmt4.setString(7, p13);
	     			  			stmt4.setString(8, q3);
	     			  			stmt4.setString(9, r3);
	     			  			stmt4.setString(10, s3);
	     			  			stmt4.setString(11, st3);


	     			  			//to execute update
	     			  			stmt4.executeUpdate();
	     			  			System.out.println("Record Submitted....");
	     		  		 break;
	     	               case 5:
	     	            	   System.out.println("\nAdd South africa Player Details");
	     		  	    	    DataInputStream KB24=new DataInputStream(System.in);
	     		  	    	    
	     		  	    		System.out.print("Enter Name: ");
	     			  			@SuppressWarnings("deprecation") String n4=KB24.readLine();
	     			  			//input employee Date Of Birth
	     			  			System.out.print("Enter Type: ");
	     			  			@SuppressWarnings("deprecation") String t4=KB24.readLine();
	     			  			//input employee city
	     			  			System.out.print("Enter Team_ID: ");
	     			  			@SuppressWarnings("deprecation") String tid4=KB24.readLine();
	     			  			System.out.print("Enter Status: ");
	     			  			@SuppressWarnings("deprecation") String sid4=KB24.readLine();
	     			  			System.out.print("Enter 4s: ");
	     			  			@SuppressWarnings("deprecation") String m4=KB24.readLine();
	     			  			System.out.print("Enter 6s: ");
	     			  			@SuppressWarnings("deprecation") String o4=KB24.readLine();
	     			  			System.out.print("Enter Runs: ");
	     			  			@SuppressWarnings("deprecation") String p14=KB24.readLine();
	     			  			System.out.print("Enter overs: ");
	     			  			@SuppressWarnings("deprecation") String q4=KB24.readLine();
	     			  			System.out.print("Enter run: ");
	     			  			@SuppressWarnings("deprecation") String r4=KB24.readLine();
	     			  			System.out.print("Enter maiden: ");
	     			  			@SuppressWarnings("deprecation") String s4=KB24.readLine();
	     			  			System.out.print("Enter wickets: ");
	     			  			@SuppressWarnings("deprecation") String st4=KB24.readLine();
	     			  		

	     			  			//creating object of PreparedStatement class and passing parameter (?)
	     			  			PreparedStatement stmt5=con.prepareStatement(" insert into south africa players (name,type,team_id,Status,4s,6s,Runs,overs,run,maiden,wickets) values(?,?,?,?,?,?,?,?,?,?,?)");

	     			  			// set the values
	     			  			
	     			  			stmt5.setString(1, n4);
	     			  			stmt5.setString(2, t4);
	     			  			stmt5.setString(3, tid4);
	     			  			stmt5.setString(4, sid4);
	     			  			stmt5.setString(5, m4);
	     			  			stmt5.setString(6, o4);
	     			  			stmt5.setString(7, p14);
	     			  			stmt5.setString(8, q4);
	     			  			stmt5.setString(9, r4);
	     			  			stmt5.setString(10, s4);
	     			  			stmt5.setString(11, st4);


	     			  			//to execute update
	     			  			stmt5.executeUpdate();
	     			  			System.out.println("Record Submitted....");
	     		  			break;
	     	        } System.out.println("Do you want to continue with Adding Player Details .. (y/Y)");
	     		      choice=sc.next();
	             		
	               }while (choice.equalsIgnoreCase("y"));
	              break;
	          }System.out.println("Do you want to continue With add Options.. (y/Y)");
		      choice=sc.next();
        	}while (choice.equalsIgnoreCase("y"));
	    	  break;
	          
	         
	          
	        case 2 :
	        	do {
	              System.out.println("\nDelete Options \n1.Delete Team Name  \n2.Delete player");
	              System.out.print("\nENTER OPTION : ");
	              int  option2=sc.nextInt();
	              switch (option2)    
	              {                                    
	                  case 1 :
	                  System.out.println("\nDelete Team Name");
	                  
	                	DataInputStream KB=new DataInputStream(System.in);

          	    		//input id for delete
          	    		System.out.print("Enter Team ID To Delete : ");
          		    	@SuppressWarnings("deprecation")
          		    	String id8=KB.readLine();
              	
                        String del = "delete from teams where id='"+id8+"'";
                        stmt.executeUpdate(del);
                        String del1 = "ALTER table teams AUTO_INCREMENT =1";
                        stmt.executeLargeUpdate(del1);
                        System.out.println("Record deleted successfully");
	                  break;
	              
	                  case 2 :
	                  System.out.println("\nDelete player");
	                  	                  
	                  do { 
	         			 System.out.println("\n\t\tDelete PLAYER DETAILS \n1.India \n2.Australia \n3.England"
	         					             +"\n4.West Indies \n5.South Africa");
	         	          System.out.print("\nENTER OPTION : ");
	         	          int  p1=sc.nextInt();
	         	     
	         	      switch (p1)    
	         	        {   
	         	       case 1:
	         	    	   System.out.println("\nDelete indian_players");
	                          
	                       	DataInputStream KB7=new DataInputStream(System.in);

	              			//input id for delete
	              			System.out.print("Enter PLAYER ID To Delete : ");
	              			@SuppressWarnings("deprecation")
	              			String id9=KB7.readLine();
	                  	
	                        String del3 = "delete from indian_players where id='"+id9+"'";
	                        stmt.executeUpdate(del3);
	                        String del4 = "ALTER table indian_players AUTO_INCREMENT =1";
	                        stmt.executeLargeUpdate(del4);
	                        System.out.println("Record deleted successfully");
	                      break;
	                      
	         	       case 2:
	         	    	   System.out.println("\nDelete australian_players");
	                          
	                       	DataInputStream BK8=new DataInputStream(System.in);

	              			//input id for delete
	              			System.out.print("Enter PLAYER ID To Delete : ");
	              			@SuppressWarnings("deprecation")
	              			String id91=BK8.readLine();
	                  	
	                        String del31 = "delete from australian_players where id='"+id91+"'";
	                        stmt.executeUpdate(del31);
	                        String del41 = "ALTER table australian_players AUTO_INCREMENT =1";
	                        stmt.executeLargeUpdate(del41);
	                        System.out.println("Record deleted successfully");
	                      break;
	         			 
	         			 
	         			 
	         			 case 3:
	         	    	   System.out.println("\nDelete south africa_players");
	                          
	                       	DataInputStream KC9=new DataInputStream(System.in);

	              			//input id for delete
	              			System.out.print("Enter PLAYER ID To Delete : ");
	              			@SuppressWarnings("deprecation")
	              			String id911=KC9.readLine();
	                  	
	                        String del311 = "delete from  south africa_players where id='"+id911+"'";
	                        stmt.executeUpdate(del311);
	                        String del411 = "ALTER table  south africa_players AUTO_INCREMENT =1";
	                        stmt.executeLargeUpdate(del411);
	                        System.out.println("Record deleted successfully");
	                      break;
	         		  			
	         				
	                             case 4:
	         	    	   System.out.println("\nDelete england_players");
	                          
	                       	DataInputStream KK8=new DataInputStream(System.in);

	              			//input id for delete
	              			System.out.print("Enter PLAYER ID To Delete : ");
	              			@SuppressWarnings("deprecation")
	              			String id9111=KK8.readLine();
	                  	
	                        String del3111 = "delete from  south africa_players where id='"+id9111+"'";
	                        stmt.executeUpdate(del3111);
	                        String del4111 = "ALTER table  south africa_players AUTO_INCREMENT =1";
	                        stmt.executeLargeUpdate(del4111);
	                        System.out.println("Record deleted successfully");
	                      break;				
	         				

	          				case 5:
	         	    	   System.out.println("\nDelete west indies_players");
	                          
	                       	DataInputStream KD7=new DataInputStream(System.in);

	              			//input id for delete
	              			System.out.print("Enter PLAYER ID To Delete : ");
	              			@SuppressWarnings("deprecation")
	              			String id91111=KD7.readLine();
	                  	
	                        String del31111 = "delete from  west indies_players where id='"+id91111+"'";
	                        stmt.executeUpdate(del31111);
	                        String del41111 = "ALTER table  west indies_players AUTO_INCREMENT =1";
	                        stmt.executeLargeUpdate(del41111);
	                        System.out.println("Record deleted successfully");
	                      break;
	         					
	         					
	         		  			
	         	        } System.out.println("Do you want to continue with Deleting Player Details .. (y/Y)");
	         		      choice=sc.next();
	                 		
	                   }while (choice.equalsIgnoreCase("y"));
	                  break;
	              }System.out.println("Do you want to continue With Delete Options.. (y/Y)");
			      choice=sc.next();
	        	}while (choice.equalsIgnoreCase("y"));
	        	break;
	           case 3 :
	               do {
	        	   System.out.println("\n\t\t\t\t\t\tGeneral Update Options \n1.Update Team Name"
	                		  +"\n2.update Location  \n3.Update Player and Runs Details");
	                  System.out.print("\nENTER OPTION : ");
	                  int  option3=sc.nextInt();
	                  switch (option3)    
	                  {                                    
	                      case 1 :
	                    	  System.out.println("\nUpdate Team Name");
	                    	  DataInputStream KB3=new DataInputStream(System.in);

	              			//input id for update
	              			System.out.print("Enter ID:");
	              			@SuppressWarnings("deprecation")
	              			String id1=KB3.readLine();

	              			//query to take data of a particular record from table employee
	              			String q1="Select * from Teams where id='"+id1+"'";

	              			//to execute query
	              			ResultSet rs5=stmt.executeQuery(q1);
	              			if(rs5.next())
	              			{
	              				//to show the data
	              				System.out.println("Id:"+rs5.getString(1));
	              				System.out.println("1.Team Name:"+rs5.getString(2));				
	              				System.out.println("2.Exit");
	              				System.out.println("Select Option to Update: ");
	              				@SuppressWarnings("deprecation")
	              				String ch=KB3.readLine();
	              				String aat="";
	              				//cases to choose field you want to edit
	              				switch(ch)
	              				{ 
	              					case "1":
	              						System.out.print("Enter New Team Name:");
	              						@SuppressWarnings("deprecation")
	              						String nn=KB3.readLine();
	              						aat="team_name='"+nn+"'";
	              						break;

	              					case "2":
	              						System.out.println("Exit");
	              						break;

	              					default:
	              						System.out.println("Wrong Option");
	              						break;
	              				}
	              				if(!aat.equals(""))
	              				{
	              					//query to edit data of a particular record from table employee
	              					q1="update Teams set "+aat+" where id='"+id1+"'";
	              					//to execute update
	              					stmt.executeUpdate(q1);
	              					System.out.println("Record Updated....");
	              				}
	              			}
	              			else
	              			{
	              				System.out.println("Record Not Found...");
	              			}
	                          break;
	                          
	                          
	                  
	                      case 2 :
	                    	  System.out.println("\nUpdate Location ");
	                    	
	                    	  DataInputStream KB4=new DataInputStream(System.in);

		              			//input id for update
		              			System.out.print("Enter ID:");
		              			@SuppressWarnings("deprecation")
		              			String id2=KB4.readLine();

		              			//query to take data of a particular record from table employee
		              			String q2="Select * from location where id='"+id2+"'";

		              			//to execute query
		              			ResultSet rs6=stmt.executeQuery(q2);
		              			if(rs6.next())
		              			{
		              				//to show the data
		              				System.out.println("Id:"+rs6.getString(1));
		              				System.out.println("1.Location_Name:"+rs6.getString(2));				
		              				System.out.println("2.Exit");
		              				System.out.println("Select Option to Update: ");
		              				@SuppressWarnings("deprecation")
		              				String ch=KB4.readLine();
		              				String loc="";
		              				//cases to choose field you want to edit
		              				switch(ch)
		              				{ 
		              					case "1":
		              						System.out.print("Enter New Location Name:");
		              						@SuppressWarnings("deprecation")
		              						String nn=KB4.readLine();
		              						loc="location_name='"+nn+"'";
		              						break;

		              					case "2":
		              						System.out.println("Exit");
		              						break;

		              					default:
		              						System.out.println("Wrong Option");
		              						break;
		              				}
		              				if(!loc.equals(""))
		              				{
		              					//query to edit data of a particular record from table employee
		              					q2="update Location set "+loc+" where id='"+id2+"'";
		              					//to execute update
		              					stmt.executeUpdate(q2);
		              					System.out.println("Record Updated....");
		              				}
		              			}
		              			else
		              			{
		              				System.out.println("Record Not Found...");
		              			}
		              		
	                    	  	                    	  	                    	  
	                    	
	                          break;
	                          	                          	                          	                         	                          
	                      case 3 :
	                          System.out.println("\n\t\t\tUpdate Players and Runs Details");
	                         
	                          do { 
	                 			 System.out.println("\n\t\t\tSELECT PLAYER COUNTRY/TEAM NAME \n1.India \n2.Australia \n3.England"
	                 					             +"\n4.West Indies \n5.South Africa");
	                 	          System.out.print("\nENTER OPTION : ");
	                 	          int  p1=sc.nextInt();
	                 	     
	                 	      switch (p1)    
	                 	        {   
	                 	       case 1:
	                 	    	    System.out.println("\nUpdate Indian Player Details");
	                 	    	    
	                 				
	                 	  			DataInputStream KB11=new DataInputStream(System.in);

	                 	  			//input id for update
	                 	  			System.out.print("Enter ID:");
	                 	  			@SuppressWarnings("deprecation")
	                 	  			String id11=KB11.readLine();

	                 	  			//query to take data of a particular record from table employee
	                 	  			String m1="Select * from indian_players where id='"+id11+"'";

	                 	  			//to execute query
	                 	  			ResultSet rs11=stmt.executeQuery(m1);
	                 	  			if(rs11.next())
	                 	  			{
	                 	  				//to show the data
	                 	  				System.out.println("Id:"+rs11.getString(1));
	                 	  				System.out.println("1.Player Name:"+rs11.getString(2));				
	                 	  				System.out.println("2.Player Type:"+rs11.getString(3));
	                 	  				System.out.println("3.Player Team ID:"+rs11.getString(4));
	                 	  				System.out.println("4.Status:"+rs11.getString(5));
	                 	  				System.out.println("5.Runs:"+rs11.getString(6));
	                 	  				System.out.println("6.Exit");
	                 	  				System.out.println("Which Field U Want to Edit?");
	                 	  				@SuppressWarnings("deprecation")
	                 	  				String ch1=KB11.readLine();
	                 	  				String in1="";
	                 	  				//cases to choose field you want to edit
	                 	  				switch(ch1)
	                 	  				{ 
	                 	  					case "1":
	                 	  						System.out.print("Enter New Name:");
	                 	  						@SuppressWarnings("deprecation")
	                 	  						String nn1=KB11.readLine();
	                 	  						in1="name='"+nn1+"'";
	                 	  						break;

	                 	  					case "2":
	                 	  						System.out.print("Enter Player Type:");
	                 	  						@SuppressWarnings("deprecation")
	                 	  						String nd1=KB11.readLine();
	                 	  						in1="type='"+nd1+"'";
	                 	  						break;

	                 	  					case "4":
	                 	  						System.out.print("Enter Status:");
	                 	  						@SuppressWarnings("deprecation")
	                 	  						String nc1=KB11.readLine();
	                 	  						in1="Status='"+nc1+"'";
	                 	  						break;
	                 	  						
	                 	  					case "5":
	                 	  						System.out.print("Enter Runs:");
	                 	  						@SuppressWarnings("deprecation")
	                 	  						String ne1=KB11.readLine();
	                 	  						in1="Runs='"+ne1+"'";
	                 	  						break;

	                 	  					case "6":
	                 	  						System.out.println("Exit");
	                 	  						break;

	                 	  					default:
	                 	  						System.out.println("Wrong Option");
	                 	  						break;
	                 	  				}
	                 	  				if(!in1.equals(""))
	                 	  				{
	                 	  					//query to edit data of a particular record from table employee
	                 	  					m1="update indian_players set "+in1+" where id='"+id11+"'";
	                 	  					//to execute update
	                 	  					stmt.executeUpdate(m1);
	                 	  					System.out.println("Record Updated....");
	                 	  				}
	                 	  			}//if 
	                 	  			else
	                 	  			{
	                 	  				System.out.println("Record Not Found...");
	                 	  			}
	                 	  		   break;
	                 	  		   
	                 		       case 2:
	                 			        System.out.println("\nUpdate Australian Player Details");
	                 			    
	                 					
	                 		  			DataInputStream KB12=new DataInputStream(System.in);

	                 		  			//input id for update
	                 		  			System.out.print("Enter ID:");
	                 		  			@SuppressWarnings("deprecation")
	                 		  			String id12=KB12.readLine();

	                 		  			//query to take data of a particular record from table employee
	                 		  			String m2="Select * from Australian_players where id='"+id12+"'";

	                 		  			//to execute query
	                 		  			ResultSet rs12=stmt.executeQuery(m2);
	                 		  			if(rs12.next())
	                 		  			{
	                 		  				//to show the data
	                 		  				System.out.println("Id:"+rs12.getString(1));
	                 		  				System.out.println("1.Player Name:"+rs12.getString(2));				
	                 		  				System.out.println("2.Player Type:"+rs12.getString(3));
	                 		  				System.out.println("3.Player Team ID:"+rs12.getString(4));
		                 	  				System.out.println("4.Status:"+rs12.getString(5));
		                 	  				System.out.println("5.Runs:"+rs12.getString(6));
		                 	  				System.out.println("6.Exit");
	                 		  				System.out.println("Which Field U Want to Edit?");
	                 		  				@SuppressWarnings("deprecation")
	                 		  				String ch2=KB12.readLine();
	                 		  				String au1="";
	                 		  				//cases to choose field you want to edit
	                 		  				switch(ch2)
	                 		  				{ 
	                 		  					case "1":
	                 		  						System.out.print("Enter New Name:");
	                 		  						@SuppressWarnings("deprecation")
	                 		  						String nn2=KB12.readLine();
	                 		  						au1="name='"+nn2+"'";
	                 		  						break;

	                 		  					case "2":
	                 		  						System.out.print("Enter Player Type:");
	                 		  						@SuppressWarnings("deprecation")
	                 		  						String nd2=KB12.readLine();
	                 		  						au1="type='"+nd2+"'";
	                 		  						break;

	                 		  				    case "4":
                                                 System.out.print("Enter Status:");
						                         @SuppressWarnings("deprecation")
						                         String nc2=KB12.readLine();
						                         au1="Status='"+nc2+"'";
						                          break;
						
					                             case "5":
						                         System.out.print("Enter Runs:");
						                         @SuppressWarnings("deprecation")
						                         String ne2=KB12.readLine();
						                         au1="Runs='"+ne2+"'";
						                         break;

					                             case "6":
	                 		  						System.out.println("Exit");
	                 		  						break;

	                 		  					default:
	                 		  						System.out.println("Wrong Option");
	                 		  						break;
	                 		  				}
	                 		  				if(!au1.equals(""))
	                 		  				{
	                 		  					//query to edit data of a particular record from table employee
	                 		  					m2="update Australian_players set "+au1+" where id='"+id12+"'";
	                 		  					//to execute update
	                 		  					stmt.executeUpdate(m2);
	                 		  					System.out.println("Record Updated....");
	                 		  				}
	                 		  			}//if 
	                 		  			else
	                 		  			{
	                 		  				System.out.println("Record Not Found...");
	                 		  			}
	                 	  			   break;
	                 	  			   
	                 		       case 3:
	                 			        System.out.println("\nUpdate England Player Details");
	                 			    
	                 					
	                 		  			DataInputStream KB13=new DataInputStream(System.in);

	                 		  			//input id for update
	                 		  			System.out.print("Enter ID:");
	                 		  			@SuppressWarnings("deprecation")
	                 		  			String id13=KB13.readLine();

	                 		  			//query to take data of a particular record from table employee
	                 		  			String m3="Select * from England_players where id='"+id13+"'";

	                 		  			//to execute query
	                 		  			ResultSet rs13=stmt.executeQuery(m3);
	                 		  			if(rs13.next())
	                 		  			{
	                 		  				//to show the data
	                 		  				System.out.println("Id:"+rs13.getString(1));
	                 		  				System.out.println("1.Player Name:"+rs13.getString(2));				
	                 		  				System.out.println("2.Player Type:"+rs13.getString(3));
	                 		  				System.out.println("3.Player Team ID:"+rs13.getString(4));
		                 	  				System.out.println("4.Status:"+rs13.getString(5));
		                 	  				System.out.println("5.Runs:"+rs13.getString(6));
		                 	  				System.out.println("6.Exit");
	                 		  				System.out.println("Which Field U Want to Edit?");
	                 		  				@SuppressWarnings("deprecation")
	                 		  				String ch3=KB13.readLine();
	                 		  				String e1="";
	                 		  				//cases to choose field you want to edit
	                 		  				switch(ch3)
	                 		  				{ 
	                 		  					case "1":
	                 		  						System.out.print("Enter New Name:");
	                 		  						@SuppressWarnings("deprecation")
	                 		  						String nn3=KB13.readLine();
	                 		  						e1="name='"+nn3+"'";
	                 		  						break;

	                 		  					case "2":
	                 		  						System.out.print("Enter Player Type:");
	                 		  						@SuppressWarnings("deprecation")
	                 		  						String nd3=KB13.readLine();
	                 		  						e1="type='"+nd3+"'";
	                 		  						break;

	                 		  					case "4":
                                                    System.out.print("Enter Status:");
                         	  						@SuppressWarnings("deprecation")
                        	  						String nc3=KB13.readLine();
	  		                        				e1="Status='"+nc3+"'";
	  			                        			break;
	  						
	  	                         				case "5":
	  		                        				System.out.print("Enter Runs:");
	  			                        			@SuppressWarnings("deprecation")
	  	                        					String ne3=KB13.readLine();
	                         						e1="Runs='"+ne3+"'";
	  	                        					break;

	  		                         			case "6":
	                 		  						System.out.println("Exit");
	                 		  						break;

	                 		  					default:
	                 		  						System.out.println("Wrong Option");
	                 		  						break;
	                 		  				}
	                 		  				if(!e1.equals(""))
	                 		  				{
	                 		  					//query to edit data of a particular record from table employee
	                 		  					m3="update England_players set "+e1+" where id='"+id13+"'";
	                 		  					//to execute update
	                 		  					stmt.executeUpdate(m3);
	                 		  					System.out.println("Record Updated....");
	                 		  				}
	                 		  			}//if 
	                 		  			else
	                 		  			{
	                 		  				System.out.println("Record Not Found...");
	                 		  			}
	                 		  			break;
	                 		  			
	                 		       case 4:
	                 			        System.out.println("\nUpdate West Indies Player Details");
	                 			    
	                 					
	                 		  			DataInputStream KB14=new DataInputStream(System.in);

	                 		  			//input id for update
	                 		  			System.out.print("Enter ID:");
	                 		  			@SuppressWarnings("deprecation")
	                 		  			String id14=KB14.readLine();

	                 		  			//query to take data of a particular record from table employee
	                 		  			String m4="Select * from West_Indies_players where id='"+id14+"'";

	                 		  			//to execute query
	                 		  			ResultSet rs14=stmt.executeQuery(m4);
	                 		  			if(rs14.next())
	                 		  			{
	                 		  				//to show the data
	                 		  				System.out.println("Id:"+rs14.getString(1));
	                 		  				System.out.println("1.Player Name:"+rs14.getString(2));				
	                 		  				System.out.println("2.Player Type:"+rs14.getString(3));
	                 		  				System.out.println("3.Player Team ID:"+rs14.getString(4));
		                 	  				System.out.println("4.Status:"+rs14.getString(5));
		                 	  				System.out.println("5.Runs:"+rs14.getString(6));
		                 	  				System.out.println("6.Exit");
	                 		  				System.out.println("Which Field U Want to Edit?");
	                 		  				@SuppressWarnings("deprecation")
	                 		  				String ch4=KB14.readLine();
	                 		  				String wi1="";
	                 		  				//cases to choose field you want to edit
	                 		  				switch(ch4)
	                 		  				{ 
	                 		  					case "1":
	                 		  						System.out.print("Enter New Name:");
	                 		  						@SuppressWarnings("deprecation")
	                 		  						String nn4=KB14.readLine();
	                 		  						wi1="name='"+nn4+"'";
	                 		  						break;

	                 		  					case "2":
	                 		  						System.out.print("Enter Player Type:");
	                 		  						@SuppressWarnings("deprecation")
	                 		  						String nd4=KB14.readLine();
	                 		  						wi1="type='"+nd4+"'";
	                 		  						break;

	                 		  					case "4":
                                                    System.out.print("Enter Status:");
	  						                        @SuppressWarnings("deprecation")
	  			                        			String nc4=KB14.readLine();
	  			                        			wi1="Status='"+nc4+"'";
	                        						break;
	  						
	                        					case "5":
                         	  						System.out.print("Enter Runs:");
	                         						@SuppressWarnings("deprecation")
                        	  						String ne4=KB14.readLine();
	                        						wi1="Runs='"+ne4+"'";
	                        						break;
          
	                        					case "6":
	                 		  						System.out.println("Exit");
	                 		  						break;

	                 		  					default:
	                 		  						System.out.println("Wrong Option");
	                 		  						break;
	                 		  				}
	                 		  				if(!wi1.equals(""))
	                 		  				{
	                 		  					//query to edit data of a particular record from table employee
	                 		  					m4="update West_Indies_players set "+wi1+" where id='"+id14+"'";
	                 		  					//to execute update
	                 		  					stmt.executeUpdate(m4);
	                 		  					System.out.println("Record Updated....");
	                 		  				}
	                 		  			}//if 
	                 		  			else
	                 		  			{
	                 		  				System.out.println("Record Not Found...");
	                 		  			}
	                 		  			break;
	                 			
	                 		       case 5:
	                 			        System.out.println("\nUpdate South Africa Player Details");
	                 			    
	                 					
	                 		  			DataInputStream KB15=new DataInputStream(System.in);

	                 		  			//input id for update
	                 		  			System.out.print("Enter ID:");
	                 		  			@SuppressWarnings("deprecation")
	                 		  			String id15=KB15.readLine();

	                 		  			//query to take data of a particular record from table employee
	                 		  			String m5="Select * from South_African_players where id='"+id15+"'";

	                 		  			//to execute query
	                 		  			ResultSet rs15=stmt.executeQuery(m5);
	                 		  			if(rs15.next())
	                 		  			{
	                 		  				//to show the data
	                 		  				System.out.println("Id:"+rs15.getString(1));
	                 		  				System.out.println("1.Player Name:"+rs15.getString(2));				
	                 		  				System.out.println("2.Player Type:"+rs15.getString(3));
	                 		  				System.out.println("3.Player Team ID:"+rs15.getString(4));
		                 	  				System.out.println("4.Status:"+rs15.getString(5));
		                 	  				System.out.println("5.Runs:"+rs15.getString(6));
		                 	  				System.out.println("6.Exit");
	                 		  				System.out.println("Which Field U Want to Edit?");
	                 		  				@SuppressWarnings("deprecation")
	                 		  				String ch5=KB15.readLine();
	                 		  				String sa1="";
	                 		  				//cases to choose field you want to edit
	                 		  				switch(ch5)
	                 		  				{ 
	                 		  					case "1":
	                 		  						System.out.print("Enter New Name:");
	                 		  						@SuppressWarnings("deprecation")
	                 		  						String nn5=KB15.readLine();
	                 		  						sa1="name='"+nn5+"'";
	                 		  						break;

	                 		  					case "2":
	                 		  						System.out.print("Enter Player Type:");
	                 		  						@SuppressWarnings("deprecation")
	                 		  						String nd5=KB15.readLine();
	                 		  						sa1="type='"+nd5+"'";
	                 		  						break;

	                 		  					case "4":
                                                    System.out.print("Enter Status:");
	                        						@SuppressWarnings("deprecation")
                        	  						String nc5=KB15.readLine();
                        	  						sa1="Status='"+nc5+"'";
                         	  						break;
	  						
	                          					case "5":
	                        						System.out.print("Enter Runs:");
	                          						@SuppressWarnings("deprecation")
                         	  						String ne5=KB15.readLine();
	                        						sa1="Runs='"+ne5+"'";
	                           						break;

	                        					case "6":
	                 		  						System.out.println("Exit");
	                 		  						break;

	                 		  					default:
	                 		  						System.out.println("Wrong Option");
	                 		  						break;
	                 		  				}
	                 		  				if(!sa1.equals(""))
	                 		  				{
	                 		  					//query to edit data of a particular record from table employee
	                 		  					m5="update South_African_players set "+sa1+" where id='"+id15+"'";
	                 		  					//to execute update
	                 		  					stmt.executeUpdate(m5);
	                 		  					System.out.println("Record Updated....");
	                 		  				}
	                 		  			}//if 
	                 		  			else
	                 		  			{
	                 		  				System.out.println("Record Not Found...");
	                 		  			}
	                 		  			break;
	                 	        } System.out.println("Do you want to continue with Players Score Updates .. (y/Y)");
	                 		      choice=sc.next();
	                         		
	                           }while (choice.equalsIgnoreCase("y"));
	              		break;	
	              		} System.out.println("Do you want to continue GENERAL UPDATE.. (y/Y)");
					      choice=sc.next();
	              		
	               }while (choice.equalsIgnoreCase("y"));
	               break;

		      case 4 :
		    	  do
			        {
		          System.out.println("\n\t\t\t\tTOTAL SCORE UPDATE \n1.Total Score \n2.Wickets  \n3.Overs  \n4.Current Player Update \n5.Current Bowler Update");
		          System.out.print("\nENTER OPTION : ");
		          int  option4=sc.nextInt();
		      
		          switch (option4)    
		          {                                    
		              
		              case 1 :
		              System.out.println("\nTotal Score");
		           

		  			DataInputStream KB=new DataInputStream(System.in);
		  			String pat="";
		  			System.out.println("\n\nEnter new total score:");
		  			@SuppressWarnings("deprecation")
		  			String nn=KB.readLine();
		  			pat="total='"+nn+"'";
		  			if(!pat.equals(""))
		  			     {
		  				  //query to edit data of a particular record from table total_score
		  			
		  				  String q="update total_score set "+pat+" where t_id=1";
		  				  //to execute update
		  				  stmt.executeUpdate(q);
		  				  System.out.println("Record Updated....");
		  			     }
		  		    else
		                 {
		  	                 System.out.println("Record Not Found...");
		                 }
		              break;
		          
		              case 2 :
		            	  System.out.println("\nWicket");
			              
			              DataInputStream RB=new DataInputStream(System.in);
				  			String sat="";
				  			System.out.println("\n\nEnter wicket:");
				  			@SuppressWarnings("deprecation")
				  			String mm=RB.readLine();
				  			sat="W='"+mm+"'";
				  			if(!sat.equals(""))
				  			     {
				  				  //query to edit data of a particular record from total_score
				  			
				  				  String q="update total_score set "+sat+" where t_id=1";
				  				  //to execute update
				  				  stmt.executeUpdate(q);
				  				  System.out.println("Record Updated....");
				  			     }
				  		    else
				                 {
				  	                 System.out.println("Record Not Found...");
				                 }

			              break;
			              
			              case 3 :
			            	  System.out.println("\nOvers");
					          
					          DataInputStream KB1=new DataInputStream(System.in);
					  			String pat3="";
					  			System.out.println("\n\nEnter overs:");
					  			@SuppressWarnings("deprecation")
					  			String cc=KB1.readLine();
					  			pat3="OVERS='"+cc+"'";
					  			if(!pat3.equals(""))
					  			     {
					  				  //query to edit data of a particular record from total_score
					  			
					  				  String q="update total_score set "+pat3+" where t_id=1";
					  				  //to execute update
					  				  stmt.executeUpdate(q);
					  				  System.out.println("Record Updated....");
					  			     }
					  		    else
					                 {
					  	                 System.out.println("Record Not Found...");
					                 }

					          break;
					          
			              case 4:
			            	  do { 
			         			 System.out.println("\n\t\tUPDATE CURRENT PLAYER DETAILS ");
			         			 System.out.println("\nUSE BELOW GIVEN IDs FOR UPDATION \n1.FOR INDIA:1,2 \n2.FOR AUSTRALIA:5,6 \n3.FOR SOUTH AFRICA:9,10"
			         					             +"\n4.FOR ENGLAND:3.4 \n5.FOR WEST INDIES:7,8");
			         		  
			         			    
			         				
			         					DataInputStream y1=new DataInputStream(System.in);
			         					DataInputStream y2=new DataInputStream(System.in);
			         					String cc11,cc22,cc33,cc44,cc55;
			         					
			         					System.out.println("\n1.");
			         					//input id for update
			         					System.out.print("Enter FIRST PLAYER ID:");
			         					@SuppressWarnings("deprecation")
			         					String i3=y1.readLine();

			         					//query to take data of a particular record from table employee
			         					String c2c="Select * from Current_players where id='"+i3+"'";
			         					

			         					System.out.print("Enter PLAYER NAME: ");
			         					@SuppressWarnings("deprecation")
			         					String n1=y1.readLine();
			         					cc11="name='"+n1+"'";
			         					c2c="update current_players set "+cc11+" where id='"+i3+"'";
			         					//to execute update
			         					stmt.executeUpdate(c2c);

			         					System.out.print("Enter PLAYER STATUS: ");
			         					@SuppressWarnings("deprecation")
			         					String f1=y1.readLine();
			         					cc22="status1='"+f1+"'";
			         					c2c="update current_players set "+cc22+" where id='"+i3+"'";
			         					//to execute update
			         					stmt.executeUpdate(c2c);

			         					System.out.print("Enter RUNS SCORED:");
			         					@SuppressWarnings("deprecation")
			         					String f2=y1.readLine();
			         					cc33="R='"+f2+"'";
			         					c2c="update current_players set "+cc33+" where id='"+i3+"'";
			         					//to execute update
			         					stmt.executeUpdate(c2c);

			         					System.out.print("Enter 4s:");
			         					@SuppressWarnings("deprecation")
			         					String f3=y1.readLine();
			         					cc44="4s1='"+f3+"'";
			         					c2c="update current_players set "+cc44+" where id='"+i3+"'";
			         					//to execute update
			         					stmt.executeUpdate(c2c);
			         					
			         					System.out.print("Enter 6s:");
			         				@SuppressWarnings("deprecation")
			         				String f4=y1.readLine();
			         				cc55="6s1='"+f4+"'";
			         				c2c="update current_players set "+cc55+" where id='"+i3+"'";
			         				//to execute update
			         				stmt.executeUpdate(c2c);
			         				
			         				String a11,a22,a33,a44,a55;
			         				
			         				    System.out.println("\n2.");
			         					System.out.print("Enter SECOND PLAYER ID:");
			         					@SuppressWarnings("deprecation")
			         					String i4=y2.readLine();

			         					//query to take data of a particular record from table employee
			         					String c1c="Select * from Current_players where id='"+i4+"'";
			         				
			         					

			         						
			         			
			         								System.out.print("Enter PLAYER NAME: ");
			         								@SuppressWarnings("deprecation")
			         								String g1=y2.readLine();
			         								a11="name='"+g1+"'";
			         								c1c="update current_players set "+a11+" where id='"+i4+"'";
			         		 					//to execute update
			         		 					stmt.executeUpdate(c1c);

			         								System.out.print("Enter PLAYER STATUS: ");
			         								@SuppressWarnings("deprecation")
			         								String g2=y2.readLine();
			         								a22="status1='"+g2+"'";
			         								c1c="update current_players set "+a22+" where id='"+i4+"'";
			         		 					//to execute update
			         		 					stmt.executeUpdate(c1c);
			         			
			         								System.out.print("Enter RUNS SCORED:");
			         								@SuppressWarnings("deprecation")
			         								String g3=y2.readLine();
			         								a33="R='"+g3+"'";
			         								c1c="update current_players set "+a33+" where id='"+i4+"'";
			         		 					//to execute update
			         		 					stmt.executeUpdate(c1c);

			         								System.out.print("Enter 4s:");
			         								@SuppressWarnings("deprecation")
			         								String g4=y2.readLine();
			         								a44="4s1='"+g4+"'";
			         								c1c="update current_players set "+a44+" where id='"+i4+"'";
			         		 					//to execute update
			         		 					stmt.executeUpdate(c1c);
			         		 					
			         		 					System.out.print("Enter 6s:");
			         							@SuppressWarnings("deprecation")
			         							String g5=y2.readLine();
			         							a55="6s1='"+g5+"'";
			         							c1c="update current_players set "+a55+" where id='"+i4+"'";
			         	 					//to execute update
			         	 					stmt.executeUpdate(c1c);

			         							
			         							System.out.println("Record Updated....");
			         							


			         		       System.out.println("Do you want to continue with Updating CURRENT PLAYER Details .. (y/Y)");
			         		     choice=sc.next();
			         				
			         		 }while (choice.equalsIgnoreCase("y"));
			            	  
			              case 5:
			            	  do { 
			            			 System.out.println("\n\t\tUpdate Current Bowlers Details \n1.India \n2.Australia \n3.South Africa"
			            					             +"\n4.England \n5.West Indies");
			            		     System.out.print("\nENTER OPTION : ");
			            		     int  p1=sc.nextInt();

			            		 switch (p1)    
			            		   {   
			            		  case 1:
			            		 
			            			    System.out.println("\nUpdate Indian bowlers Details");
			            			    
			            				
			            					DataInputStream b1=new DataInputStream(System.in);

			            					//input id for update
			            					System.out.print("Enter ID:");
			            					@SuppressWarnings("deprecation")
			            					String id3=b1.readLine();

			            					//query to take data of a particular record from table employee
			            					String c1="Select * from indian_players where id='"+id3+"'";
			            					String c2="Select * from indian_players where id='"+id3+"'";
			            					String c3="Select * from indian_players where id='"+id3+"'";
			            					String c4="Select * from indian_players where id='"+id3+"'";
			            					

			            						String inb11,inb22,inb33,inb44;
			            			
			            								System.out.print("Enter OVERS: ");
			            								@SuppressWarnings("deprecation")
			            								String nnb11=b1.readLine();
			            								inb11="overs='"+nnb11+"'";
			            								c1="update indian_players set "+inb11+" where id='"+id3+"'";
			            		 					//to execute update
			            		 					stmt.executeUpdate(c1);

			            								System.out.print("Enter MAIDEN: ");
			            								@SuppressWarnings("deprecation")
			            								String ndb11=b1.readLine();
			            								inb22="maiden='"+ndb11+"'";
			            								c2="update indian_players set "+inb22+" where id='"+id3+"'";
			            		 					//to execute update
			            		 					stmt.executeUpdate(c2);
			            			
			            								System.out.print("Enter RUNS GIVEN:");
			            								@SuppressWarnings("deprecation")
			            								String ncb11=b1.readLine();
			            								inb33="run='"+ncb11+"'";
			            								c3="update indian_players set "+inb33+" where id='"+id3+"'";
			            		 					//to execute update
			            		 					stmt.executeUpdate(c3);

			            								System.out.print("Enter WICKET TAKEN:");
			            								@SuppressWarnings("deprecation")
			            								String neb11=b1.readLine();
			            								inb44="wickets='"+neb11+"'";
			            								c4="update indian_players set "+inb44+" where id='"+id3+"'";
			            		 					//to execute update
			            		 					stmt.executeUpdate(c4);

			            							
			            							System.out.println("Record Updated....");
			            							break;
			            							
			            		         case 2:
			            			                     System.out.println("\nUpdate australian bowlers Details");
			            			    		
			            			                  	DataInputStream m1=new DataInputStream(System.in);

			            		                        		//input id for update
			            			                          	System.out.print("Enter ID:");
			            			                             	@SuppressWarnings("deprecation")
			            			                         	String id5=m1.readLine();

			            			                   	//query to take data of a particular record from table employee
			            				                   String q1="Select * from australian_players where id='"+id5+"'";
			            				                   String q2="Select * from australian_players where id='"+id5+"'";
			            				                   String q3="Select * from australian_players where id='"+id5+"'";
			            				                   String q4="Select * from australian_players where id='"+id5+"'";
			            				

			            					                      String inb66,inb77,inb88,inb99;

			            							System.out.print("Enter OVERS: ");
			            							@SuppressWarnings("deprecation")
			            							String nnb66=m1.readLine();
			            							inb66="overs='"+nnb66+"'";
			            							q1="update australian_players set "+inb66+" where id='"+id5+"'";
			            						//to execute update
			            						stmt.executeUpdate(q1);

			            							System.out.print("Enter MAIDEN: ");
			            							@SuppressWarnings("deprecation")
			            							String ndb66=m1.readLine();
			            							inb77="maiden='"+ndb66+"'";
			            							q2="update australian_players set "+inb77+" where id='"+id5+"'";
			            						//to execute update
			            						stmt.executeUpdate(q2);

			            							System.out.print("Enter RUNS GIVEN:");
			            							@SuppressWarnings("deprecation")
			            							String ncb1112=m1.readLine();
			            							inb88="run='"+ncb1112+"'";
			            							q3="update australian_players set "+inb88+" where id='"+id5+"'";
			            						//to execute update
			            						stmt.executeUpdate(q3);

			            							System.out.print("Enter WICKET TAKEN:");
			            							@SuppressWarnings("deprecation")
			            							String neb66=m1.readLine();
			            							inb99="wickets='"+neb66+"'";
			            							q4="update australian_players set "+inb99+" where id='"+id5+"'";
			            						//to execute update
			            						stmt.executeUpdate(q4);

			            						
			            						System.out.println("Record Updated....");
			            						break;
			            						
			            						case 3:

			            		                                    System.out.println("\nUpdate england bowlers Details");
			            		  	
			            			                                	DataInputStream s1=new DataInputStream(System.in);

			            			                                  	//input id for update
			            				                              System.out.print("Enter ID:");
			            			                                 	@SuppressWarnings("deprecation")
			            			                                 	String id8=s1.readLine();

			            			                          	//query to take data of a particular record from table employee
			            			                        	String w1="Select * from england_players where id='"+id8+"'";
			            				                      String w2="Select * from england_players where id='"+id8+"'";
			            				                        String w3="Select * from england_players where id='"+id8+"'";
			            			                            String w4="Select * from england_players where id='"+id8+"'";
			            				

			            				                                   	String inb12,inb13,inb34,inb14;

			            							System.out.print("Enter OVERS: ");
			            							@SuppressWarnings("deprecation")
			            							String nnb12=s1.readLine();
			            							inb12="overs='"+nnb12+"'";
			            							w1="update england_players set "+inb12+" where id='"+id8+"'";
			            						//to execute update
			            						stmt.executeUpdate(w1);

			            							System.out.print("Enter MAIDEN: ");
			            							@SuppressWarnings("deprecation")
			            							String ndb12=s1.readLine();
			            							inb13="maiden='"+ndb12+"'";
			            							w2="update england_players set "+inb13+" where id='"+id8+"'";
			            						//to execute update
			            						stmt.executeUpdate(w2);

			            							System.out.print("Enter RUNS GIVEN:");
			            							@SuppressWarnings("deprecation")
			            							String ncb12=s1.readLine();
			            							inb34="run='"+ncb12+"'";
			            							w3="update england_players set "+inb34+" where id='"+id8+"'";
			            						//to execute update
			            						stmt.executeUpdate(w3);

			            							System.out.print("Enter WICKET TAKEN:");
			            							@SuppressWarnings("deprecation")
			            							String neb12=s1.readLine();
			            							inb14="wickets='"+neb12+"'";
			            							w4="update england_players set "+inb14+" where id='"+id8+"'";
			            						//to execute update
			            						stmt.executeUpdate(w4);

			            						
			            						System.out.println("Record Updated....");
			            						
			            						break;
			            						
			            						
			            						case 4:

			            		                                System.out.println("\nUpdate south africa bowlers Details");
			            		  
			            				                           DataInputStream p11=new DataInputStream(System.in);

			            			                                   	//input id for update
			            			                            	System.out.print("Enter ID:");
			            			                             	@SuppressWarnings("deprecation")
			            			                               	String id6=p11.readLine();

			            			                               	//query to take data of a particular record from table south_africa_players
			            				                            String o1="Select * from south_africa_players where id='"+id6+"'";
			            				                            String o2="Select * from south_africa_players where id='"+id6+"'";
			            			                               	String o3="Select * south_africa_players where id='"+id6+"'";
			            			                             	String o4="Select * south_africa_players where id='"+id6+"'";
			            				

			            				                         	String inb41,inb42,inb43,inb45;

			            						                   	System.out.print("Enter OVERS: ");
			            						                  	@SuppressWarnings("deprecation")
			            					                   		String nnb41=p11.readLine();
			            				                   			inb41="overs='"+nnb41+"'";
			            					                		o1="update south_africa_players set "+inb41+" where id='"+id6+"'";
			            					                     	//to execute update
			            				                    		stmt.executeUpdate(o1);

			            							                 System.out.print("Enter MAIDEN: ");
			            						                    	@SuppressWarnings("deprecation")
			            						                 	String ndb41=p11.readLine();
			            					                      		inb42="maiden='"+ndb41+"'";
			            					                    		o2="update south_africa_players set "+inb42+" where id='"+id6+"'";
			            				                     		//to execute update
			            				                     		stmt.executeUpdate(o2);

			            							System.out.print("Enter RUNS GIVEN:");
			            							@SuppressWarnings("deprecation")
			            							String ncb41=p11.readLine();
			            							inb43="run='"+ncb41+"'";
			            							o3="update south_africa_players set "+inb43+" where id='"+id6+"'";
			            						//to execute update
			            						stmt.executeUpdate(o3);

			            							System.out.print("Enter WICKET TAKEN:");
			            							@SuppressWarnings("deprecation")
			            							String neb41=p11.readLine();
			            							inb45="wickets='"+neb41+"'";
			            							o4="update south_africa_players set "+inb45+" where id='"+id6+"'";
			            						//to execute update
			            						stmt.executeUpdate(o4);

			            						
			            						System.out.println("Record Updated....");
			            						
			            						break;
			            						
			            						
			            						case 5:
			            						
			            		  System.out.println("\nUpdate west indies bowlers Details");
			            		  
			            			
			            				DataInputStream x1=new DataInputStream(System.in);

			            				//input id for update
			            				System.out.print("Enter ID:");
			            				@SuppressWarnings("deprecation")
			            				String id2=x1.readLine();

			            				//query to take data of a particular record from table employee
			            				String z1="Select * from west_indies_players where id='"+id2+"'";
			            				String z2="Select * from west_indies_players where id='"+id2+"'";
			            				String z3="Select * from west_indies_players where id='"+id2+"'";
			            				String z4="Select * from west_indies_players where id='"+id2+"'";
			            				

			            					String inb51,inb52,inb53,inb54;

			            							System.out.print("Enter OVERS: ");
			            							@SuppressWarnings("deprecation")
			            							String nnb51=x1.readLine();
			            							inb51="overs='"+nnb51+"'";
			            							z1="update west_indies_players set "+inb51+" where id='"+id2+"'";
			            						//to execute update
			            						stmt.executeUpdate(z1);

			            							System.out.print("Enter MAIDEN: ");
			            							@SuppressWarnings("deprecation")
			            							String ndb51=x1.readLine();
			            							inb52="maiden='"+ndb51+"'";
			            							z2="update west_indies_playersset "+inb52+" where id='"+id2+"'";
			            						//to execute update
			            						stmt.executeUpdate(z2);

			            							System.out.print("Enter RUNS GIVEN:");
			            							@SuppressWarnings("deprecation")
			            							String ncb51=x1.readLine();
			            							inb53="run='"+ncb51+"'";
			            							z3="update west_indies_players set "+inb53+" where id='"+id2+"'";
			            						//to execute update
			            						stmt.executeUpdate(z3);

			            							System.out.print("Enter WICKET TAKEN:");
			            							@SuppressWarnings("deprecation")
			            							String neb51=x1.readLine();
			            							inb54="wickets='"+neb51+"'";
			            							z4="update west_indies_players set "+inb54+" where id='"+id2+"'";
			            						//to execute update
			            						stmt.executeUpdate(z4);

			            				
			            						System.out.println("Record Updated....");
			            						break;

			            		   } System.out.println("Do you want to continue with Updating bowler bowling Details .. (y/Y)");
			            		     choice=sc.next();
			            				
			            		 }while (choice.equalsIgnoreCase("y"));
			            	  break;
			          }
			          System.out.println("Do you want to continue TOTAL SCORE UPDATE.. (y/Y)");
				      choice=sc.next();
			        } while (choice.equalsIgnoreCase("y")); 
		    	  
		      case 5:
		    	  System.out.println("EXIT");
		          break;
		      default :
		    	  System.out.println("Invalid Option Selection...Please select Correct Option");
		    	  break;
			      } System.out.println("Do you want to continue ADMIN CHOICES.. (y/Y)");
			        choice=sc.next();
		      }  while (choice.equalsIgnoreCase("y")); 
                 con.close();  
               sc.close();
	 }	//try       
                 catch(Exception e){
	             System.out.println(e);
                }//catch
      	        
	  	}
}