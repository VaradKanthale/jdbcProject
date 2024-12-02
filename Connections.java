package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {
	
	Connection conn=null;
	
	  String url = "jdbc:mysql://localhost:3306/home"; 
      String user = "root"; 
     String password = "manager"; 

      
      public Connection getConnection()  {
    	  
			try {
				conn= DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
	         		
    	  
      }
}
