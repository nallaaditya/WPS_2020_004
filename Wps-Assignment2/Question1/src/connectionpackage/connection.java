package connectionpackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection 
{

	public Connection getConnection()
	{
		String url="jdbc:mysql://localhost:3306/moviesdb";
		String username="root";
		String password="";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection(url,username,password);
			return con;
		} catch (Exception e) {
			
			return null;
		}

	}
}
