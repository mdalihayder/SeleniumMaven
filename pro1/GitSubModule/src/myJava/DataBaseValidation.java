package myJava;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class DataBaseValidation 
	{
	   private static Connection connection;
	   private static Statement statement;
	   private static ResultSet rs;
	   
	   public String DB_ID="";
       public String DB_NAME="";
       public String DB_EMAIL="";
     
       public void CreateDBConnection()
       	{
    	   System.out.println("Entering into CreateDBConnection function ...");
    	   
           String databaseURL = "jdbc:mysql://127.0.0.1:3306/books";  
           String user = "root";
           String password = "root";
           connection = null;
           try {
               Class.forName("com.mysql.jdbc.Driver");
               System.out.println("Connecting to Database...");
               connection = DriverManager.getConnection(databaseURL, user, password);
                             
               if (connection != null) {
                   System.out.println("Connected to the Database...");
               }
           } catch (SQLException ex) {
              ex.printStackTrace();
              System.out.println("Exception occurred in CreateDBConnection :"+ex);
           }
           catch (ClassNotFoundException ex) {
              ex.printStackTrace();
              System.out.println("Exception occurred in CreateDBConnection :"+ex);
           }
   }
       

       public static List<Object> GetDBData() {
              try{
            	             	  
            	  String query = "SELECT * FROM authors LIMIT 1";
                  statement = connection.createStatement();
                  rs = statement.executeQuery(query);

              while (rs.next())
              {
            	     String DB_ID = rs.getString(1);
            	     String DB_NAME = rs.getString(2);
            	     String DB_EMAIL = rs.getString(3);
            	     
            	    return Arrays.asList(DB_ID, DB_NAME, DB_EMAIL);
              }
             
              }
              catch(Exception e)
              {
                  e.printStackTrace();
            	  System.out.println("Exception in GetDBData : "+ e);
              }
			return null;
									
       }

      
       public void CloseDBConnection()
       {
    	   
    	   if (connection != null) {
               try {
                   System.out.println("Closing Database Connection...");
                   connection.close();
               } catch (SQLException ex) {
                   ex.printStackTrace();
                   System.out.println("Unable to close Database Connection...");
               }
           }
     } 
       
   }
