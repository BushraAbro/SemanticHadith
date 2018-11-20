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

	public static final String URL = "jdbc:mysql://localhost:8889/hadithFH?characterEncoding=utf8";

	public static Connection createConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			  return DriverManager.getConnection(URL,"root", "root"); 
		} catch (SQLException | ClassNotFoundException e) {
			 throw new RuntimeException("Error connecting to the database", e);
		}
		
	}
	
}
