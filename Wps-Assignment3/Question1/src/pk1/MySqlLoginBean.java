package pk1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySqlLoginBean 
{
	private String username;
	private String rollnumber;
	private int id;
		
	private int store;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRollNumber() {
		return rollnumber;
	}

	public void setRollNumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStore() {
		String url="jdbc:mysql://localhost:3306/student";
		String dbusername="root";
		String dbpassword="";
		
		try {
			
			//for loading the vendor specific driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//for establishing the connection
			Connection con=DriverManager.getConnection(url,dbusername,dbpassword);
			
			System.out.println(con);
			
			
			String updation="select * from information where name like ?";
		
			//we will use prepared statement for the manipulations
			
			PreparedStatement pstmnt=con.prepareStatement(updation);
			
			pstmnt.setString(1, this.username);
			
			ResultSet rs=pstmnt.executeQuery();
			
			String result="";
			if(rs.next())
			{
				result=result+" "+rs.getString(3)+" "+rs.getString(1)+ " "+username;
			}
			return result;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Connection did not establish");
			
			e.printStackTrace();
			return "Connection Problem";
		}
	}

	public void setStore(int store) 
	{
		this.store = store;
		
		String url="jdbc:mysql://localhost:3306/student";
		String dbusername="root";
		String dbpassword="";
		
		try {
			
			//for loading the vendor specific driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//for establishing the connection
			Connection con=DriverManager.getConnection(url,dbusername,dbpassword);
			
			System.out.println(con);
			
			
			String updation="insert into information(id,name,rollnumber) values(?,?,?)";
		
			//we will use prepared statement for the manipulations
			
			PreparedStatement pstmnt=con.prepareStatement(updation);
			
			pstmnt.setInt(1, id);
			pstmnt.setString(2, username);
			pstmnt.setString(3, rollnumber);
			int x=pstmnt.executeUpdate();
			
					
		}
		catch(Exception e)
		{
			System.out.println("Connection did not establish");
			e.printStackTrace();
			
		}
	}
	
	
}


