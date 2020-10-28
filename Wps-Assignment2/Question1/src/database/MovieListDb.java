package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import connectionpackage.connection;
public class MovieListDb
{
	
	public ArrayList<String> getMoviesList()
	{
		ArrayList<String> list=new ArrayList<String>();
		
		try {
			Connection con = new connection().getConnection();
			String querystring="select moviename from movieslist";
			
			PreparedStatement pstmnt=con.prepareStatement(querystring);
			
			
			
			
			ResultSet rs=pstmnt.executeQuery();
			
			if(rs.next())
			{
				
				list.add(rs.getString(1));
				while(rs.next())
				{
					list.add(rs.getString(1));
				}
				return list;
				
			}
			else {
				
				return null;
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	
		
	}

}
