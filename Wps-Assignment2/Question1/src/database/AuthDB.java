package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connectionpackage.connection;

public class AuthDB 
{

	public Boolean checkCredentials(String email, String password) {
		try {
			Connection con = new connection().getConnection();
			String querystring="select * from usersdb where email like ? and password like ?";
			
			PreparedStatement pstmnt=con.prepareStatement(querystring);
			
			pstmnt.setString(1,email);
			pstmnt.setString(2, password);
			
			ResultSet rs=pstmnt.executeQuery();
			
			if(rs.next())
			{
				con.close();
				return true;
			}
			else {
				con.close();
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Error");
			return false;
		}
	}
	
	public Boolean addCredentials(String phone, String email, String password) {
		try {
			Connection con = new connection().getConnection();
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO usersdb (phoneNumber,email,password) VALUES (?,?,?)");
			pstmt.setString(1, phone);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			
			if(pstmt.executeUpdate()==1)
			{
				pstmt.close();
				con.close();
				return true;
			}
			else {
				pstmt.close();
				con.close();
				return false;
			}
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
}
