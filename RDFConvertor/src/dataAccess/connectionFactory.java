/**
 * 
 */
package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Bushra
 *
 */
public class connectionFactory {

// mac
	//public static final String port = "jdbc:mysql://localhost:8889/";
//windows 
	public static final String port = "jdbc:mysql://localhost:3306/";
	
	public static final String encoding = "?characterEncoding=utf8";
	
	//for Windows laptop
	//public static final String URL = "jdbc:mysql://localhost:3306/hadithdatafh?characterEncoding=utf8";

	public static Connection createConnection(String dbName)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			  return DriverManager.getConnection(port+dbName+encoding,"root", ""); 
		} catch (SQLException | ClassNotFoundException e) {
			 throw new RuntimeException("Error connecting to the database", e);
		}
		
	}
	
}
