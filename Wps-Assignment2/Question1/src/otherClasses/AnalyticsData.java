package otherClasses;

import java.util.Date;

public class AnalyticsData 
{
	
	public int reportid,cost,seats,bookedseats,revenue;
	public String moviename,screenname;
	public Date date;
	
	public AnalyticsData(int reportid,String moviename,String screenname, int cost, int seats, int bookedseats, Date date, int revenue) {
		
		this.reportid = reportid;
		this.cost = cost;
		this.seats = seats;
		this.bookedseats = bookedseats;
		this.revenue = revenue;
		this.moviename = moviename;
		this.date = date;
		this.screenname=screenname;
	}
	
	
	
	
	
}
