package myJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class MySQL_DB {
	
	
	@Test
	public void testDB() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/books","root","root");
		System.out.println("Data base connected");
		
		 // This will create statement  
        Statement smt=con.createStatement();
          
        System.out.println("Statement created");
 
   // Now execute the query, here facebook is the table which I have created in DB 
    
        ResultSet rs=  smt.executeQuery("SELECT * FROM authors LIMIT 1");
 
       System.out.println("Query Executed");
 
  // Iterate the resultset now
 
       while(rs.next()){
   
       String DB_ID=    rs.getString(1);
       String DB_NAME=        rs.getString(2);
       String DB_EMAIL=      rs.getString(3);
 
        System.out.println("ID  is "+DB_ID+" Name is "+DB_NAME+" email id is "+DB_EMAIL);
   
  }
	}
	
	
	

	/*public static void main(String[] args) {
	

	}*/

}
