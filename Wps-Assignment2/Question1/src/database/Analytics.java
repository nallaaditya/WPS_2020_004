package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connectionpackage.connection;
import otherClasses.AnalyticsData;

public class Analytics 
{
	
	public ArrayList<AnalyticsData> getAnalyticsData()
	{
		ArrayList<AnalyticsData> list=new ArrayList<AnalyticsData>();
		
		try {
			Connection con = new connection().getConnection();
			String querystring="select reportid,moviename,screenname,cost,seats,bookedseats,date,bookedseats*cost as revenue from report";
			
			PreparedStatement pstmnt=con.prepareStatement(querystring);
	
			ResultSet rs=pstmnt.executeQuery();
			
			if(rs.next())
			{
				AnalyticsData obj=new AnalyticsData(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6),rs.getDate(7),rs.getInt(8)
						);
				list.add(obj);
				
				while(rs.next())
				{
					AnalyticsData obj2=new AnalyticsData(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
							rs.getInt(5),rs.getInt(6),rs.getDate(7),rs.getInt(8)
							);
					list.add(obj2);
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
