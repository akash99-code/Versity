package c;
import java.sql.*; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class DatabaseConnection {
	 protected static Connection initializeDatabase() 
		        throws SQLException, ClassNotFoundException 
		    { 
		        
		          
		        //Connection con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword); 
		        
					
					Connection con = null;
				    try {
				      String DATASOURCE_CONTEXT = "java:comp/env/jdbc/mysqldb";
				      Context initialContext = new InitialContext();
				      
				      DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
				      if (datasource != null) {
				        con = datasource.getConnection();
				      }
				      else {
				    	  System.out.println("Failed to lookup datasource.");
				      }
				    }
				    catch ( NamingException ex ) {
				    	System.out.println("Cannot get connection: " + ex);
				    }
				    catch(SQLException ex){
				    	System.out.println("Cannot get connection: " + ex);
				    }
		            
		            return con; 
		            
		    } 

}
