package com.cricket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.sql.ResultSet;

public class Cricket {
	
	 public static void main(String[] args) throws Exception {

	      // register MySQL thin driver with DriverManager service
	      // It is optional for JDBC4.x version
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      // variables
	      final String url = "jdbc:mysql:///mini_project";
	      final String user = "root";
	      final String password = "root";

	      // establish the connection
	      Connection con = DriverManager.getConnection(url, user, password);

	      // display status message
	     
	   
	        //String choice="";
	        
	        Scanner sc=new Scanner(System.in);
	        System.out.println("\t\t\t\tCRICKET SCORE BOARD\n\n");                               
	        
	        System.out.println("TODAYS MATCH \n1.ONE DAY MATCH \n2.T20 MATCH \n");
	         //int b=sc.nextInt();
	        
	        //do {
	        	 System.out.print("ENTER OPTION : ");
	             int  operation=sc.nextInt();
	             
	             String op="";
	do {                                      // 1st do while 
	        switch (operation)    
	          { 
	            case 1 :
	            System.out.println("\t\t\t\t\t\t\t\tTODAYS TEAMS MATCHES \n1.INDIA vs ENGLAND  \n2.SOUTH AFRICA vs AUSTRALIA \n3.AUSTRALIA vs WEST INDIES \n4.WEST INDIES vs ENGLAND  \n5.ENGLAND vs SOUTH AFRICA ");
	            System.out.print("\nENTER OPTION : ");
	            int  option=sc.nextInt();
	            switch (option)    
	            {                                    
	                case 1 :
	                System.out.println("\n\nINDIA vs ENGLAND");

                  
                    
            	    
          	      // create JDBC statement object
          	      Statement st = con.createStatement();
          	      Statement st2 = con.createStatement();
          	      Statement st3 = con.createStatement();
          	      Statement st33 = con.createStatement();
          	      Statement st34 = con.createStatement();
          	      Statement st35 = con.createStatement();
          	     
          	     
          	      Statement st66 = con.createStatement();
          	      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
                    LocalDate localDate = LocalDate.now();
                    System.out.println(dtf.format(localDate));
                    
                    String choice1="";
                   
                    
                    String overs = "select overs from total_score where t_id=1";
                    ResultSet rs12=st66.executeQuery(overs);
          	while(rs12.next())
          	{
                    String quer1=rs12.getString("overs");
                    
                if(!quer1.equals("50"))
                  {
                    do {                                         // 2nd do while 
                  	  System.out.println("\nTEAM INDIA");
          	      String query = "select concat(sum(runs),'-',0) as ONEDAY from indian_players;";
          	      String query2 = " select overs from total_score where t_id=1";
          	      ResultSet rs = st.executeQuery(query);
          	      ResultSet rs2 = st2.executeQuery(query2);
          	     // boolean flag = false;
          	      while (rs.next()) {
          	 		     // flag = true;
          	 		     System.out.println("\nTOTAL SCORE :"+rs.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
          	 		    } 
          	      while (rs2.next()) {
           		    //  flag = true;
           		      
           		     System.out.println("\nOVERS: "+rs2.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
           		    } 
          	                                               // BATTERS //
          	      Statement st1 = con.createStatement();

          	      // prepare SQL query
          	        
          	      String query3 = "select name,status1,R,4s1,6s1 from current_players where id=1 or id=2"; 
          	      
          	       System.out.println("\nBATTERS \t\t\tRuns    4s   6s");
          	      // send and execute SQL query in Database software	     
          	      ResultSet rs3= st1.executeQuery(query3);
          		  // process the ResultSet object
          	      while (rs3.next()) {
          	       //  flag = true;
          	         System.out.println("\n"+rs3.getString(1)+ "    " +rs3.getString(2) +"         " +rs3.getInt(3) +"      " + rs3.getInt(4) +"     " + rs3.getInt(5));
          	      } 
                                                                        // BOWLERS //
          Statement st5 = con.createStatement();

          // prepare SQL query
          //String query3 = "select name,status,runs,4s,6s from indian_players where id=1 or id=2"; 	       
          String q12 = "select name,overs,Run,maiden,wickets from england_players where type='bo'"; 

          System.out.println("\n\nBOWLERS \t\tOvers    M   R   W");
          // send and execute SQL query in Database software	     
          ResultSet b12= st5.executeQuery(q12);
          // process the ResultSet object
          while (b12.next()) {
          //  flag = true;
          System.out.println("\n"+b12.getString(1)+ "        \t    " +b12.getString(2) +"    " +b12.getInt(3) +"   " + b12.getInt(4) +"   " + b12.getInt(5));
          } 
          	      
          	      
          	      System.out.println("\n\nFor Refresh Enter  ... (y/Y)");
          	      choice1=sc.next();
              		
                }while (choice1.equalsIgnoreCase("y"));  // 2nd while 
            
                                                                     // FULL SCORE CARD
                              String choice2="";
             do {                                     // 3rd do while 
            	 
          	   System.out.println("\n\t\tWANT TO SEE FULL SCORE CARD ENTER 1 ELSE 2 TO EXIT \n1.Score Card \n2.Exit");
                 System.out.print("\nENTER OPTION : ");
                 int  option1=sc.nextInt();
             
                 switch (option1) 
                 {
                 case 1:
                        Statement st4 = con.createStatement();

                         // prepare SQL query
                          String query4 = "select name,status,runs,4s,6s from indian_players"; 	       
             
                         System.out.println("\n\nDETAIL SCORE BOARD \t\t\tRuns    4s     6s");
                        // send and execute SQL query in Database software	     
                          ResultSet rs4= st4.executeQuery(query4);
          	              // process the ResultSet object
                        while (rs4.next()) {
                         //  flag = true;
                             System.out.println("\n"+rs4.getString(1)+ "     " +rs4.getString(2) +"     " +rs4.getInt(3) +"       " + rs4.getInt(4) +"     " + rs4.getInt(5));
                          } 
                       break;
                       
                 case 2:
          				System.out.println("Exit");
          				break;
          				
          	   default :
          		        System.out.println("Invalid Option Selection");
          		        break;
          					
                    }      
          	         
                      System.out.println("WANT TO SEE FULL SCORE CARD ... (y/Y)");
             choice2=sc.next();
               
                  }while (choice2.equalsIgnoreCase("y"));   //3rd while 
            }//if
                                                        //////////ENGLAND/////////
                else 
                {
              	    System.out.println("\nTEAM ENGLAND");
            do {                                          //4th do while
              			
              	      String quer11 = "select concat(sum(runs),'-',0) as ONEDAY from england_players;";
              	      String quer22 = " select overs from total_score where t_id=2";     // use overs id 2 for 2nd team 
              	      ResultSet rs11 = st3.executeQuery(quer11);
              	      ResultSet rs22 = st33.executeQuery(quer22);
              	     // boolean flag = false;
              	      while (rs11.next()) {
              	 		     // flag = true;
              	 		     System.out.println("\nTOTAL SCORE :"+rs11.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
              	 		    } 
              	      while (rs22.next()) {
               		    //  flag = true;
               		      
               		     System.out.println("\nOVERS: "+rs22.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
               		    } 
              	                                               // BATTERS //
              	  

              	      // prepare SQL query
              	      	       
              	      String quer33 = "select name,status1,R,4s1,6s1 from current_players where id=3 or id=4"; 
              	      
              	       System.out.println("\nBATTERS \t\t\tRuns    4s   6s");
              	      // send and execute SQL query in Database software	     
              	      ResultSet rs33= st34.executeQuery(quer33);
              		  // process the ResultSet object
              	      while (rs33.next()) {
              	       //  flag = true;
              	         System.out.println("\n"+rs33.getString(1)+ "    " +rs33.getString(2) +"         " +rs33.getInt(3) +"      " + rs33.getInt(4) +"     " + rs33.getInt(5));
              	      } 
                                                                            // BOWLERS //
              

              // prepare SQL query
              //String query3 = "select name,status,runs,4s,6s from indian_players where id=1 or id=2"; 	       
              String quer34 = "select name,overs,Run,maiden,wickets from Indian_players where type='bo'"; 

              System.out.println("\n\nBOWLERS \t\tOvers    R   M   W");
              // send and execute SQL query in Database software	     
              ResultSet b34= st35.executeQuery(quer34);
              // process the ResultSet object
              while (b34.next()) {
              //  flag = true;
              System.out.println("\n"+b34.getString(1)+ "        \t    " +b34.getString(2) +"    " +b34.getInt(3) +"   " + b34.getInt(4) +"   " + b34.getInt(5));
              } 
              	      
              	      
              	      System.out.println("\n\nFor Refresh Enter  ... (y/Y)");
              	      choice1=sc.next();
                  		
           }while (choice1.equalsIgnoreCase("y"));  //4th 
                
                                                                         // FULL SCORE CARD
                                  String choice2="";
              do {                                   //5th do while
            	  
              	   System.out.println("\n\t\tWANT TO SEE FULL SCORE CARD ENTER 1 ELSE 2 TO EXIT \n1.Score Card \n2.Exit");
                     System.out.print("\nENTER OPTION : ");
                     int  option11=sc.nextInt();
                 
                     switch (option11) 
                     {
                     case 1:
                           
                             // prepare SQL query
                              String quer35 = "select name,status,runs,4s,6s from england_players"; 	       
                 
                             System.out.println("\n\nDETAIL SCORE BOARD \t\tRuns    \t4s      6s");
                            // send and execute SQL query in Database software	     
                              ResultSet rs35= st35.executeQuery(quer35);
              	              // process the ResultSet object
                            while (rs35.next()) {
                             //  flag = true;
                                 System.out.println("\n"+rs35.getString(1)+ "     " +rs35.getString(2) +"  \t   " +rs35.getInt(3) +"       " + rs35.getInt(4) +"     " + rs35.getInt(5));
                              } 
                           break;
                           
                     case 2:
              				System.out.println("Exit");
              				break;
              				
              	   default :
              		        System.out.println("Invalid Option Selection");
              		        break;
              					
                        }      
              	         
                          System.out.println("WANT TO SEE FULL SCORE CARD ... (y/Y)");
                 choice2=sc.next();
                   
                   }while (choice2.equalsIgnoreCase("y")); //5th 
                }//else
          	}//while
               
	                break;
	            
	                case 2  :
	                	System.out.println("SOUTH AFRICA vs AUSTRALIA");
	                	
	                	// create JDBC statement object
		          	      Statement st50 = con.createStatement();
		          	      Statement st51 = con.createStatement();
		          	      Statement st52 = con.createStatement();
		          	      Statement st53 = con.createStatement();
		          	      Statement st54 = con.createStatement();
		          	      Statement st55 = con.createStatement();
		          	     
		          	     
		          	      Statement st56 = con.createStatement();
		          	      DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		                    LocalDate localDate2= LocalDate.now();
		                    System.out.println(dtf2.format(localDate2));
		                    
		                    String choice2="";
		                   
		                    
		                    String overs2 = "select overs from total_score where t_id=1";
		                    ResultSet rs123=st56.executeQuery(overs2);
		          	while(rs123.next())
		          	{
		                    String quer1=rs123.getString("overs");
		                    
		                if(!quer1.equals("50"))
		                  {
		                    do {                                         // 2nd do while 
		                  	  System.out.println("\nTEAM SOUTH AFRICA");
		          	      String query = "select concat(sum(runs),'-',0) as ONEDAY from south"
		          	      		+ "_africa_players;";
		          	      String query2 = " select overs from total_score where t_id=1";
		          	      ResultSet rs = st50.executeQuery(query);
		          	      ResultSet rs2 = st51.executeQuery(query2);
		          	     // boolean flag = false;
		          	      while (rs.next()) {
		          	 		     // flag = true;
		          	 		     System.out.println("\nTOTAL SCORE :"+rs.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
		          	 		    } 
		          	      while (rs2.next()) {
		           		    //  flag = true;
		           		      
		           		     System.out.println("\nOVERS: "+rs2.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
		           		    } 
		          	                                               // BATTERS //
		          	      Statement st11 = con.createStatement();

		          	      // prepare SQL query
		          	        
		          	      String query3 = "select name,status1,R,4s1,6s1 from current_players where id=9 or id=10"; 
		          	      
		          	       System.out.println("\nBATTERS \t\t\tRuns    4s   6s");
		          	      // send and execute SQL query in Database software	     
		          	      ResultSet rs3= st11.executeQuery(query3);
		          		  // process the ResultSet object
		          	      while (rs3.next()) {
		          	       //  flag = true;
		          	         System.out.println("\n"+rs3.getString(1)+ "    " +rs3.getString(2) +"         " +rs3.getInt(3) +"      " + rs3.getInt(4) +"     " + rs3.getInt(5));
		          	      } 
		                                                                        // BOWLERS //
		          Statement st5 = con.createStatement();

		          // prepare SQL query
		          //String query3 = "select name,status,runs,4s,6s from australian_players where id=1 or id=2"; 	       
		          String q12 = "select name,overs,Run,maiden,wickets from australian_players where type='bo'"; 

		          System.out.println("\n\nBOWLERS \t\tOvers    M   R   W");
		          // send and execute SQL query in Database software	     
		          ResultSet b12= st5.executeQuery(q12);
		          // process the ResultSet object
		          while (b12.next()) {
		          //  flag = true;
		          System.out.println("\n"+b12.getString(1)+ "        \t    " +b12.getString(2) +"    " +b12.getInt(3) +"   " + b12.getInt(4) +"   " + b12.getInt(5));
		          } 
		          	      
		          	      
		          	      System.out.println("\n\nFor Refresh Enter  ... (y/Y)");
		          	      choice1=sc.next();
		              		
		                }while (choice1.equalsIgnoreCase("y"));  // 2nd while 
		            
		                                                                     // FULL SCORE CARD
		                              String choice="";
		             do {                                     // 3rd do while 
		            	 
		          	   System.out.println("\n\t\tWANT TO SEE FULL SCORE CARD ENTER 1 ELSE 2 TO EXIT \n1.Score Card \n2.Exit");
		                 System.out.print("\nENTER OPTION : ");
		                 int  option1=sc.nextInt();
		             
		                 switch (option1) 
		                 {
		                 case 1:
		                        Statement st4 = con.createStatement();

		                         // prepare SQL query
		                          String query4 = "select name,status,runs,4s,6s from south_africa_players"; 	       
		             
		                         System.out.println("\n\nDETAIL SCORE BOARD \t\t\tRuns    4s     6s");
		                        // send and execute SQL query in Database software	     
		                          ResultSet rs4= st4.executeQuery(query4);
		          	              // process the ResultSet object
		                        while (rs4.next()) {
		                         //  flag = true;
		                             System.out.println("\n"+rs4.getString(1)+ "     " +rs4.getString(2) +"     " +rs4.getInt(3) +"       " + rs4.getInt(4) +"     " + rs4.getInt(5));
		                          } 
		                       break;
		                       
		                 case 2:
		          				System.out.println("Exit");
		          				break;
		          				
		          	   default :
		          		        System.out.println("Invalid Option Selection");
		          		        break;
		          					
		                    }      
		          	         
		                      System.out.println("WANT TO SEE FULL SCORE CARD ... (y/Y)");
		             choice2=sc.next();
		               
		                  }while (choice2.equalsIgnoreCase("y"));   //3rd while 
		            }//if
		                                                        //////////ENGLAND/////////
		                else 
		                {
		              	    System.out.println("\nTEAM AUSTRALIA");
		            do {                                          //4th do while
		              			
		              	      String quer11 = "select concat(sum(runs),'-',0) as ONEDAY from australian_players;";
		              	      String quer22 = " select overs from total_score where t_id=2";     // use overs id 2 for 2nd team 
		              	      ResultSet rs11 = st52.executeQuery(quer11);
		              	      ResultSet rs22 = st53.executeQuery(quer22);
		              	     // boolean flag = false;
		              	      while (rs11.next()) {
		              	 		     // flag = true;
		              	 		     System.out.println("\nTOTAL SCORE :"+rs11.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
		              	 		    } 
		              	      while (rs22.next()) {
		               		    //  flag = true;
		               		      
		               		     System.out.println("\nOVERS: "+rs22.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
		               		    } 
		              	                                               // BATTERS //
		              	  

		              	      // prepare SQL query
		              	      	       
		              	      String quer33 = "select name,status1,R,4s1,6s1 from current_players where id=5 or id=6"; 
		              	      
		              	       System.out.println("\nBATTERS \t\t\tRuns    4s   6s");
		              	      // send and execute SQL query in Database software	     
		              	      ResultSet rs33= st54.executeQuery(quer33);
		              		  // process the ResultSet object
		              	      while (rs33.next()) {
		              	       //  flag = true;
		              	         System.out.println("\n"+rs33.getString(1)+ "    " +rs33.getString(2) +"         " +rs33.getInt(3) +"      " + rs33.getInt(4) +"     " + rs33.getInt(5));
		              	      } 
		                                                                            // BOWLERS //
		              

		              // prepare SQL query
		              //String query3 = "select name,status,runs,4s,6s from indian_players where id=1 or id=2"; 	       
		              String quer34 = "select name,overs,Run,maiden,wickets from south_africa_players where type='bo'"; 

		              System.out.println("\n\nBOWLERS \t\tOvers    R   M   W");
		              // send and execute SQL query in Database software	     
		              ResultSet b34= st55.executeQuery(quer34);
		              // process the ResultSet object
		              while (b34.next()) {
		              //  flag = true;
		              System.out.println("\n"+b34.getString(1)+ "        \t    " +b34.getString(2) +"    " +b34.getInt(3) +"   " + b34.getInt(4) +"   " + b34.getInt(5));
		              } 
		              	      
		              	      
		              	      System.out.println("\n\nFor Refresh Enter  ... (y/Y)");
		              	      choice1=sc.next();
		                  		
		           }while (choice1.equalsIgnoreCase("y"));  //4th 
		                
		                                                                         // FULL SCORE CARD
		                                  String choice3="";
		              do {                                   //5th do while
		            	  
		              	   System.out.println("\n\t\tWANT TO SEE FULL SCORE CARD ENTER 1 ELSE 2 TO EXIT \n1.Score Card \n2.Exit");
		                     System.out.print("\nENTER OPTION : ");
		                     int  option11=sc.nextInt();
		                 
		                     switch (option11) 
		                     {
		                     case 1:
		                           
		                             // prepare SQL query
		                              String quer35 = "select name,status,runs,4s,6s from australian_players"; 	       
		                 
		                             System.out.println("\n\nDETAIL SCORE BOARD \t\tRuns    \t4s      6s");
		                            // send and execute SQL query in Database software	     
		                              ResultSet rs35= st55.executeQuery(quer35);
		              	              // process the ResultSet object
		                            while (rs35.next()) {
		                             //  flag = true;
		                                 System.out.println("\n"+rs35.getString(1)+ "     " +rs35.getString(2) +"  \t   " +rs35.getInt(3) +"       " + rs35.getInt(4) +"     " + rs35.getInt(5));
		                              } 
		                           break;
		                           
		                     case 2:
		              				System.out.println("Exit");
		              				break;
		              				
		              	   default :
		              		        System.out.println("Invalid Option Selection");
		              		        break;
		              					
		                        }      
		              	         
		                          System.out.println("WANT TO SEE FULL SCORE CARD ... (y/Y)");
		                 choice2=sc.next();
		                   
		                   }while (choice2.equalsIgnoreCase("y")); //5th 
		                }//else
		          	}//while
	                
	                break;
	                
	                case 3 :
	                System.out.println("AUSTRALIA vs WEST INDIES");
	                
	                
	          	      // create JDBC statement object
	          	      Statement st40 = con.createStatement();
	          	      Statement st41 = con.createStatement();
	          	      Statement st42 = con.createStatement();
	          	      Statement st43 = con.createStatement();
	          	      Statement st44 = con.createStatement();
	          	      Statement st45 = con.createStatement();
	          	    Statement st48 = con.createStatement();
	          	    Statement st477 = con.createStatement();
	          	      Statement st46 = con.createStatement();
	          	      DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("uuuu/MM/dd");
	                    LocalDate localDate3 = LocalDate.now();
	                    System.out.println(dtf3.format(localDate3));
	                    
	                    String choice3="";
	                   
	                    
	                    String overs3 = "select overs from total_score where t_id=1";
					
					ResultSet rs14=st46.executeQuery(overs3);
	          	while(rs14.next())
	          	{
	                    String quer1=rs14.getString("overs");
	                    
	                if(!quer1.equals("50"))
	                  {
	                    do {                                         // 2nd do while 
	                  	  System.out.println("\nTEAM AUSTRALIA");
	          	      String query = "select concat(sum(runs),'-',0) as ONEDAY from australian_players;";
	          	      String query2 = " select overs from total_score where t_id=1";
	          	     
					
					ResultSet rs = st40.executeQuery(query);	          	     					
					ResultSet rs2 = st41.executeQuery(query2);
	          	     // boolean flag = false;
	          	      while (rs.next()) {
	          	 		     // flag = true;
	          	 		     System.out.println("\nTOTAL SCORE :"+rs.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
	          	 		    } 
	          	      while (rs2.next()) {
	           		    //  flag = true;
	           		      
	           		     System.out.println("\nOVERS: "+rs2.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
	           		    } 
	          	                                               // BATTERS //
	          	      Statement st11 = con.createStatement();

	          	      // prepare SQL query
	          	        
	          	      String query3 = "select name,status1,R,4s1,6s1 from current_players where id=5 or id=6"; 
	          	      
	          	       System.out.println("\nBATTERS \t\t\tRuns    4s   6s");
	          	      // send and execute SQL query in Database software	     
	          	      ResultSet rs3= st11.executeQuery(query3);
	          		  // process the ResultSet object
	          	      while (rs3.next()) {
	          	       //  flag = true;
	          	         System.out.println("\n"+rs3.getString(1)+ "    " +rs3.getString(2) +"         " +rs3.getInt(3) +"      " + rs3.getInt(4) +"     " + rs3.getInt(5));
	          	      } 
	                                                                        // BOWLERS //
	          Statement st5 = con.createStatement();

	          // prepare SQL query
	          //String query3 = "select name,status,runs,4s,6s from australian_players where id=5 or id=6"; 	       
	          String q12 = "select name,overs,Run,maiden,wickets from west_indies_players where type='bo'"; 

	          System.out.println("\n\nBOWLERS \t\tOvers    M   R   W");
	          // send and execute SQL query in Database software	     
	          ResultSet b12= st5.executeQuery(q12);
	          // process the ResultSet object
	          while (b12.next()) {
	          //  flag = true;
	          System.out.println("\n"+b12.getString(1)+ "        \t    " +b12.getString(2) +"    " +b12.getInt(3) +"   " + b12.getInt(4) +"   " + b12.getInt(5));
	          } 
	          	      
	          	      
	          	      System.out.println("\n\nFor Refresh Enter  ... (y/Y)");
	          	      choice1=sc.next();
	              		
	                }while (choice1.equalsIgnoreCase("y"));  // 2nd while 
	            
	                                                                     // FULL SCORE CARD
	                              String choice22="";
	             do {                                     // 3rd do while 
	            	 
	          	   System.out.println("\n\t\tWANT TO SEE FULL SCORE CARD ENTER 1 ELSE 2 TO EXIT \n1.Score Card \n2.Exit");
	                 System.out.print("\nENTER OPTION : ");
	                 int  option1=sc.nextInt();
	             
	                 switch (option1) 
	                 {
	                 case 1:
	                        Statement st4 = con.createStatement();

	                         // prepare SQL query
	                          String query4 = "select name,status,runs,4s,6s from australian_players"; 	       
	             
	                         System.out.println("\n\nDETAIL SCORE BOARD \t\t\tRuns    4s     6s");
	                        // send and execute SQL query in Database software	     
	                          ResultSet rs4= st4.executeQuery(query4);
	          	              // process the ResultSet object
	                        while (rs4.next()) {
	                         //  flag = true;
	                             System.out.println("\n"+rs4.getString(1)+ "     " +rs4.getString(2) +"     " +rs4.getInt(3) +"       " + rs4.getInt(4) +"     " + rs4.getInt(5));
	                          } 
	                       break;
	                       
	                 case 2:
	          				System.out.println("Exit");
	          				break;
	          				
	          	   default :
	          		        System.out.println("Invalid Option Selection");
	          		        break;
	          					
	                    }      
	          	         
	                      System.out.println("WANT TO SEE FULL SCORE CARD ... (y/Y)");
	             choice2=sc.next();
	               
	                  }while (choice2.equalsIgnoreCase("y"));   //3rd while 
	            }//if
	                                                        //////////WEST INDIES/////////
	                else 
	                {
	              	    System.out.println("\nTEAM WEST_INDIES");
	            do {                                          //4th do while
	              			
	              	      String quer11 = "select concat(sum(runs),'-',0) as ONEDAY from west_indies_players;";
	              	      String quer22 = " select overs from total_score where t_id=4";     // use overs id 2 for 2nd team 
	              	     // Statement st11 = null;
						ResultSet rs11 = st48.executeQuery(quer11);
	              	     // Statement st47 = null;
						ResultSet rs22 = st477.executeQuery(quer22);
	              	     // boolean flag = false;
	              	      while (rs11.next()) {
	              	 		     // flag = true;
	              	 		     System.out.println("\nTOTAL SCORE :"+rs11.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
	              	 		    } 
	              	      while (rs22.next()) {
	               		    //  flag = true;
	               		      
	               		     System.out.println("\nOVERS: "+rs22.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
	               		    } 
	              	                                               // BATTERS //
	              	  

	              	      // prepare SQL query
	              	      	       
	              	      String quer33 = "select name,status1,R,4s1,6s1 from current_players where id=7 or id=8"; 
	              	      
	              	       System.out.println("\nBATTERS \t\t\tRuns    4s   6s");
	              	      // send and execute SQL query in Database software	     
	              	      ResultSet rs33= st44.executeQuery(quer33);
	              		  // process the ResultSet object
	              	      while (rs33.next()) {
	              	       //  flag = true;
	              	         System.out.println("\n"+rs33.getString(1)+ "    " +rs33.getString(2) +"         " +rs33.getInt(3) +"      " + rs33.getInt(4) +"     " + rs33.getInt(5));
	              	      } 
	                                                                            // BOWLERS //
	              

	              // prepare SQL query
	              //String query3 = "select name,status,runs,4s,6s from australian_players where id=5 or id=6"; 	       
	              String quer34 = "select name,overs,Run,maiden,wickets from australian_players where type='bo'"; 

	              System.out.println("\n\nBOWLERS \t\tOvers    R   M   W");
	              // send and execute SQL query in Database software	     
	              ResultSet b34= st45.executeQuery(quer34);
	              // process the ResultSet object
	              while (b34.next()) {
	              //  flag = true;
	              System.out.println("\n"+b34.getString(1)+ "        \t    " +b34.getString(2) +"    " +b34.getInt(3) +"   " + b34.getInt(4) +"   " + b34.getInt(5));
	              } 
	              	      
	              	      
	              	      System.out.println("\n\nFor Refresh Enter  ... (y/Y)");
	              	      choice1=sc.next();
	                  		
	           }while (choice1.equalsIgnoreCase("y"));  //4th 
	                
	                                                                         // FULL SCORE CARD
	                                  String choice22="";
	              do {                                   //5th do while
	            	  
	              	   System.out.println("\n\t\tWANT TO SEE FULL SCORE CARD ENTER 1 ELSE 2 TO EXIT \n1.Score Card \n2.Exit");
	                     System.out.print("\nENTER OPTION : ");
	                     int  option11=sc.nextInt();
	                 
	                     switch (option11) 
	                     {
	                     case 1:
	                           
	                             // prepare SQL query
	                              String quer35 = "select name,status,runs,4s,6s from west_indies_players"; 	       
	                 
	                             System.out.println("\n\nDETAIL SCORE BOARD \t\tRuns    \t4s      6s");
	                            // send and execute SQL query in Database software	     
	                              ResultSet rs35= st45.executeQuery(quer35);
	              	              // process the ResultSet object
	                            while (rs35.next()) {
	                             //  flag = true;
	                                 System.out.println("\n"+rs35.getString(1)+ "     " +rs35.getString(2) +"  \t   " +rs35.getInt(3) +"       " + rs35.getInt(4) +"     " + rs35.getInt(5));
	                              } 
	                           break;
	                           
	                     case 2:
	              				System.out.println("Exit");
	              				break;
	              				
	              	   default :
	              		        System.out.println("Invalid Option Selection");
	              		        break;
	              					
	                        }      
	              	         
	                          System.out.println("WANT TO SEE FULL SCORE CARD ... (y/Y)");
	                 choice2=sc.next();
	                   
	                   }while (choice2.equalsIgnoreCase("y")); //5th 
	                }//else
	          	}//while
	               
	                break;
	                
	                case 4 :
		                System.out.println("WEST INDIES vs ENGLAND");
					
		                
		          	      // create JDBC statement object
		          	      Statement st401 = con.createStatement();
		          	      Statement st411 = con.createStatement();
		          	      Statement st421 = con.createStatement();
		          	      Statement st431 = con.createStatement();
		          	      Statement st441 = con.createStatement();
		          	      Statement st451 = con.createStatement();
		          	     
		          	     
		          	      Statement st461 = con.createStatement();
		          	      DateTimeFormatter dtf31 = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		                    LocalDate localDate31 = LocalDate.now();
		                    System.out.println(dtf31.format(localDate31));
		                    
		                    String choice31="";
		                   
		                    
		                    String overs31 = "select overs from total_score where t_id=1";
						
						ResultSet rs141=st461.executeQuery(overs31);
		          	while(rs141.next())
		          	{
		                    String quer1=rs141.getString("overs");
		                    
		                if(!quer1.equals("50"))
		                  {
		                    do {                                         // 2nd do while 
		                  	  System.out.println("\nTEAM WEST_INDIES");
		          	      String query = "select concat(sum(runs),'-',0) as ONEDAY from west_indies_players;";
		          	      String query2 = " select overs from total_score where t_id=1";
		          	     
						
						ResultSet rs = st401.executeQuery(query);	          	     					
						ResultSet rs2 = st411.executeQuery(query2);
		          	     // boolean flag = false;
		          	      while (rs.next()) {
		          	 		     // flag = true;
		          	 		     System.out.println("\nTOTAL SCORE :"+rs.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
		          	 		    } 
		          	      while (rs2.next()) {
		           		    //  flag = true;
		           		      
		           		     System.out.println("\nOVERS: "+rs2.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
		           		    } 
		          	                                               // BATTERS //
		          	      Statement st11 = con.createStatement();

		          	      // prepare SQL query
		          	        
		          	      String query3 = "select name,status1,R,4s1,6s1 from current_players where id=7 or id=8"; 
		          	      
		          	       System.out.println("\nBATTERS \t\t\tRuns    4s   6s");
		          	      // send and execute SQL query in Database software	     
		          	      ResultSet rs3= st11.executeQuery(query3);
		          		  // process the ResultSet object
		          	      while (rs3.next()) {
		          	       //  flag = true;
		          	         System.out.println("\n"+rs3.getString(1)+ "    " +rs3.getString(2) +"         " +rs3.getInt(3) +"      " + rs3.getInt(4) +"     " + rs3.getInt(5));
		          	      } 
		                                                                        // BOWLERS //
		          Statement st5 = con.createStatement();

		          // prepare SQL query
		          //String query3 = "select name,status,runs,4s,6s from west_indies_players where id=5 or id=6"; 	       
		          String q12 = "select name,overs,Run,maiden,wickets from england_players where type='bo'"; 

		          System.out.println("\n\nBOWLERS \t\tOvers    M   R   W");
		          // send and execute SQL query in Database software	     
		          ResultSet b12= st5.executeQuery(q12);
		          // process the ResultSet object
		          while (b12.next()) {
		          //  flag = true;
		          System.out.println("\n"+b12.getString(1)+ "        \t    " +b12.getString(2) +"    " +b12.getInt(3) +"   " + b12.getInt(4) +"   " + b12.getInt(5));
		          } 
		          	      
		          	      
		          	      System.out.println("\n\nFor Refresh Enter  ... (y/Y)");
		          	      choice1=sc.next();
		              		
		                }while (choice1.equalsIgnoreCase("y"));  // 2nd while 
		            
		                                                                     // FULL SCORE CARD
		                              String choice22="";
		             do {                                     // 3rd do while 
		            	 
		          	   System.out.println("\n\t\tWANT TO SEE FULL SCORE CARD ENTER 1 ELSE 2 TO EXIT \n1.Score Card \n2.Exit");
		                 System.out.print("\nENTER OPTION : ");
		                 int  option1=sc.nextInt();
		             
		                 switch (option1) 
		                 {
		                 case 1:
		                        Statement st4 = con.createStatement();

		                         // prepare SQL query
		                          String query4 = "select name,status,runs,4s,6s from west_indies_players"; 	       
		             
		                         System.out.println("\n\nDETAIL SCORE BOARD \t\t\tRuns    4s     6s");
		                        // send and execute SQL query in Database software	     
		                          ResultSet rs4= st4.executeQuery(query4);
		          	              // process the ResultSet object
		                        while (rs4.next()) {
		                         //  flag = true;
		                             System.out.println("\n"+rs4.getString(1)+ "     " +rs4.getString(2) +"     " +rs4.getInt(3) +"       " + rs4.getInt(4) +"     " + rs4.getInt(5));
		                          } 
		                       break;
		                       
		                 case 2:
		          				System.out.println("Exit");
		          				break;
		          				
		          	   default :
		          		        System.out.println("Invalid Option Selection");
		          		        break;
		          					
		                    }      
		          	         
		                      System.out.println("WANT TO SEE FULL SCORE CARD ... (y/Y)");
		             choice2=sc.next();
		               
		                  }while (choice2.equalsIgnoreCase("y"));   //3rd while 
		            }//if
		                                                        //////////ENGLAND/////////
		                else 
		                {
		              	    System.out.println("\nTEAM ENGLAND");
		            do {                                          //4th do while
		              			
		              	      String quer11 = "select concat(sum(runs),'-',0) as ONEDAY from england_players;";
		              	      String quer22 = " select overs from total_score where t_id=4";     // use overs id 2 for 2nd team 
		              	      Statement st11 = null;
							ResultSet rs11 = st11.executeQuery(quer11);
		              	      Statement st47 = null;
							ResultSet rs22 = st47.executeQuery(quer22);
		              	     // boolean flag = false;
		              	      while (rs11.next()) {
		              	 		     // flag = true;
		              	 		     System.out.println("\nTOTAL SCORE :"+rs11.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
		              	 		    } 
		              	      while (rs22.next()) {
		               		    //  flag = true;
		               		      
		               		     System.out.println("\nOVERS: "+rs22.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
		               		    } 
		              	                                               // BATTERS //
		              	  

		              	      // prepare SQL query
		              	      	       
		              	      String quer33 = "select name,status1,R,4s1,6s1 from current_players where id=3 or id=4"; 
		              	      
		              	       System.out.println("\nBATTERS \t\t\tRuns    4s   6s");
		              	      // send and execute SQL query in Database software	     
		              	      ResultSet rs33= st441.executeQuery(quer33);
		              		  // process the ResultSet object
		              	      while (rs33.next()) {
		              	       //  flag = true;
		              	         System.out.println("\n"+rs33.getString(1)+ "    " +rs33.getString(2) +"         " +rs33.getInt(3) +"      " + rs33.getInt(4) +"     " + rs33.getInt(5));
		              	      } 
		                                                                            // BOWLERS //
		              

		              // prepare SQL query
		              //String query3 = "select name,status,runs,4s,6s from west_indies_players where id=5 or id=6"; 	       
		              String quer34 = "select name,overs,Run,maiden,wickets from west_indies_players where type='bo'"; 

		              System.out.println("\n\nBOWLERS \t\tOvers    R   M   W");
		              // send and execute SQL query in Database software	     
		              ResultSet b34= st451.executeQuery(quer34);
		              // process the ResultSet object
		              while (b34.next()) {
		              //  flag = true;
		              System.out.println("\n"+b34.getString(1)+ "        \t    " +b34.getString(2) +"    " +b34.getInt(3) +"   " + b34.getInt(4) +"   " + b34.getInt(5));
		              } 
		              	      
		              	      
		              	      System.out.println("\n\nFor Refresh Enter  ... (y/Y)");
		              	      choice1=sc.next();
		                  		
		           }while (choice1.equalsIgnoreCase("y"));  //4th 
		                
		                                                                         // FULL SCORE CARD
		                                  String choice22="";
		              do {                                   //5th do while
		            	  
		              	   System.out.println("\n\t\tWANT TO SEE FULL SCORE CARD ENTER 1 ELSE 2 TO EXIT \n1.Score Card \n2.Exit");
		                     System.out.print("\nENTER OPTION : ");
		                     int  option11=sc.nextInt();
		                 
		                     switch (option11) 
		                     {
		                     case 1:
		                           
		                             // prepare SQL query
		                              String quer35 = "select name,status,runs,4s,6s from england_players"; 	       
		                 
		                             System.out.println("\n\nDETAIL SCORE BOARD \t\tRuns    \t4s      6s");
		                            // send and execute SQL query in Database software	     
		                              ResultSet rs35= st451.executeQuery(quer35);
		              	              // process the ResultSet object
		                            while (rs35.next()) {
		                             //  flag = true;
		                                 System.out.println("\n"+rs35.getString(1)+ "     " +rs35.getString(2) +"  \t   " +rs35.getInt(3) +"       " + rs35.getInt(4) +"     " + rs35.getInt(5));
		                              } 
		                           break;
		                           
		                     case 2:
		              				System.out.println("Exit");
		              				break;
		              				
		              	   default :
		              		        System.out.println("Invalid Option Selection");
		              		        break;
		              					
		                        }      
		              	         
		                          System.out.println("WANT TO SEE FULL SCORE CARD ... (y/Y)");
		                 choice2=sc.next();
		                   
		                   }while (choice2.equalsIgnoreCase("y")); //5th 
		                }//else
		          	}//while
																																																																																								               
		          	break;	                
	                
	                case 5 :
	                  System.out.println("ENGLAND vs SOUTH AFRICA");
          	    
      	      // create JDBC statement object
      	      Statement st61 = con.createStatement();
      	      Statement st62= con.createStatement();
      	      Statement st63 = con.createStatement();
      	      Statement st64 = con.createStatement();
      	      Statement st65 = con.createStatement();
      	      Statement st67 = con.createStatement();
      	      Statement st21 = con.createStatement();
    	      Statement st22= con.createStatement();
    	      Statement st23 = con.createStatement();
    	      Statement st24 = con.createStatement();
    	      Statement st25 = con.createStatement();
    	     
      	     
      	      DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("uuuu/MM/dd");
                LocalDate localDate5 = LocalDate.now();
                System.out.println(dtf1.format(localDate5));
                
                String co3="";
               
                
                String overs5 = "select overs from total_score where t_id=1";
                ResultSet rs121=st61.executeQuery(overs5);
      	while(rs121.next())
      	{
                String quer121=rs121.getString("overs");
                
            if(!quer121.equals("50"))
              {
                do {                                         // 2nd do while 
              	  System.out.println("\nTEAM ENGLAND");
      	      String que1 = "select concat(sum(runs),'-',0) as ONEDAY from england_players;";
      	      String que2 = " select overs from total_score where t_id=1";
      	      ResultSet rt1 = st62.executeQuery(que1);
      	      ResultSet rt2 = st63.executeQuery(que2);
      	     // boolean flag = false;
      	      while (rt1.next()) {
      	 		     // flag = true;
      	 		     System.out.println("\nTOTAL SCORE :"+rt1.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
      	 		    } 
      	      while (rt2.next()) {
       		    //  flag = true;
       		      
       		     System.out.println("\nOVERS: "+rt2.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
       		    } 
      	                                               // BATTERS //

      	      // prepare SQL query
      	        
      	      String que3 = "select name,status1,R,4s1,6s1 from current_players where id=3 or id=4"; 
      	      
      	       System.out.println("\nBATTERS \t\t\tRuns    4s   6s");
      	      // send and execute SQL query in Database software	     
      	      ResultSet rt3= st64.executeQuery(que3);
      		  // process the ResultSet object
      	      while (rt3.next()) {
      	       //  flag = true;
      	         System.out.println("\n"+rt3.getString(1)+ "    " +rt3.getString(2) +"         " +rt3.getInt(3) +"      " + rt3.getInt(4) +"     " + rt3.getInt(5));
      	      } 
                                                                    // BOWLERS //
     
      // prepare SQL query
          
      String que4 = "select name,overs,Run,maiden,wickets from south_african_players where type='bo'"; 

      System.out.println("\n\nBOWLERS \t\tOvers    M   R   W");
      // send and execute SQL query in Database software	     
      ResultSet rr1= st65.executeQuery(que4);
      // process the ResultSet object
      while (rr1.next()) {
      //  flag = true;
      System.out.println("\n"+rr1.getString(1)+ "        \t    " +rr1.getString(2) +"    " +rr1.getInt(3) +"   " + rr1.getInt(4) +"   " +rr1.getInt(5));
      } 
      	      
      	      
      	      System.out.println("\n\nFor Refresh Enter  ... (y/Y)");
      	      choice1=sc.next();
          		
            }while (co3.equalsIgnoreCase("y"));  // 2nd while 
        
                                                                 // FULL SCORE CARD
                          String co4="";
         do {                                     // 3rd do while 
        	 
      	   System.out.println("\n\t\tWANT TO SEE FULL SCORE CARD ENTER 1 ELSE 2 TO EXIT \n1.Score Card \n2.Exit");
             System.out.print("\nENTER OPTION : ");
             int  opt1=sc.nextInt();
         
             switch (opt1) 
             {
             case 1:
                  

                     // prepare SQL query
                      String que5 = "select name,status,runs,4s,6s from england_players"; 	       
         
                     System.out.println("\n\nDETAIL SCORE BOARD \t\t\tRuns    4s     6s");
                    // send and execute SQL query in Database software	     
                      ResultSet ra4= st67.executeQuery(que5);
      	              // process the ResultSet object
                    while (ra4.next()) {
                     //  flag = true;
                         System.out.println("\n"+ra4.getString(1)+ "     " +ra4.getString(2) +"     " +ra4.getInt(3) +"       " + ra4.getInt(4) +"     " + ra4.getInt(5));
                      } 
                   break;
                   
             case 2:
      				System.out.println("Exit");
      				break;
      				
      	   default :
      		        System.out.println("Invalid Option Selection");
      		        break;
      					
                }      
      	         
                  System.out.println("WANT TO SEE FULL SCORE CARD ... (y/Y)");
         co4=sc.next();
           
              }while (co4.equalsIgnoreCase("y"));   //3rd while 
        }//if
                                                    //////////SOUTH AFRICA/////////
            else 
            {
          	    System.out.println("\nTEAM SOUTH AFRICA");
        do {                                          //4th do while
          			
          	      String que11 = "select concat(sum(runs),'-',0) as ONEDAY from south_african_players;";
          	      String que22 = " select overs from total_score where t_id=2";     // use overs id 2 for 2nd team 
          	      ResultSet ra5 = st21.executeQuery(que11);
          	      ResultSet ra6 = st22.executeQuery(que22);
          	     // boolean flag = false;
          	      while (ra5.next()) {
          	 		     // flag = true;
          	 		     System.out.println("\nTOTAL SCORE :"+ra5.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
          	 		    } 
          	      while (ra6.next()) {
           		    //  flag = true;
           		      
           		     System.out.println("\nOVERS: "+ra6.getString(1));// + " " + rs.getString(2) +" " + rs.getInt(3) +" " + rs.getInt(4));
           		    } 
          	                                               // BATTERS //
          	  

          	      // prepare SQL query
          	      	       
          	      String que33 = "select name,status1,R,4s1,6s1 from current_players where id=9 or id=10"; 
          	      
          	       System.out.println("\nBATTERS \t\t\tRuns    4s   6s");
          	      // send and execute SQL query in Database software	     
          	      ResultSet rs33= st23.executeQuery(que33);
          		  // process the ResultSet object
          	      while (rs33.next()) {
          	       //  flag = true;
          	         System.out.println("\n"+rs33.getString(1)+ "    " +rs33.getString(2) +"         " +rs33.getInt(3) +"      " + rs33.getInt(4) +"     " + rs33.getInt(5));
          	      } 
                                                                        // BOWLERS //
          

          // prepare SQL query
        	       
          String que34 = "select name,overs,Run,maiden,wickets from england_players where type='bo'"; 

          System.out.println("\n\nBOWLERS \t\tOvers    R   M   W");
          // send and execute SQL query in Database software	     
          ResultSet ra7= st24.executeQuery(que34);
          // process the ResultSet object
          while (ra7.next()) {
          //  flag = true;
          System.out.println("\n"+ra7.getString(1)+ "        \t    " +ra7.getString(2) +"    " +ra7.getInt(3) +"   " + ra7.getInt(4) +"   " + ra7.getInt(5));
          } 
          	      
          	      
          	      System.out.println("\n\nFor Refresh Enter  ... (y/Y)");
          	      co3=sc.next();
              		
       }while (co3.equalsIgnoreCase("y"));  //4th 
            
                         String co4="";                                            // FULL SCORE CARD
                             
          do {                                   //5th do while
        	  
          	   System.out.println("\n\t\tWANT TO SEE FULL SCORE CARD ENTER 1 ELSE 2 TO EXIT \n1.Score Card \n2.Exit");
                 System.out.print("\nENTER OPTION : ");
                 int  op11=sc.nextInt();
             
                 switch (op11) 
                 {
                 case 1:
                       
                         // prepare SQL query
                          String que44 = "select name,status,runs,4s,6s from south_african_players"; 	       
             
                         System.out.println("\n\nDETAIL SCORE BOARD \t\tRuns    \t4s      6s");
                        // send and execute SQL query in Database software	     
                          ResultSet ra8= st25.executeQuery(que44);
          	              // process the ResultSet object
                        while (ra8.next()) {
                         //  flag = true;
                             System.out.println("\n"+ra8.getString(1)+ "     " +ra8.getString(2) +"  \t   " +ra8.getInt(3) +"       " + ra8.getInt(4) +"     " + ra8.getInt(5));
                          } 
                       break;
                       
                 case 2:
          				System.out.println("Exit");
          				break;
          				
          	   default :
          		        System.out.println("Invalid Option Selection");
          		        break;
          					
                    }      
          	         
                      System.out.println("WANT TO SEE FULL SCORE CARD ... (y/Y)");
             co4=sc.next();
               
               }while (co4.equalsIgnoreCase("y")); //5th 
            }//else
      	}//while
	                break;           
	            } 
	           
	          }   System.out.println("WANT TO BACK TO TODAYS TEAM MATCHES ... (y/Y)");
              op=sc.next(); 
	        
	}while (op.equalsIgnoreCase("y"));         // 1st while 

	sc.close();
	con.close();

  } // main
	              
}//class 

