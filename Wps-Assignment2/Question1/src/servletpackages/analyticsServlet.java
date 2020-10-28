package servletpackages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Analytics;
import otherClasses.AnalyticsData;


@WebServlet(description = "get data of all Analytics", urlPatterns = { "/analyticsServlet" })
public class analyticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public analyticsServlet() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<AnalyticsData> analyticsdatalist=new ArrayList<AnalyticsData>();
		
		PrintWriter out=response.getWriter();
		
		Analytics obj=new Analytics();
		
		if(obj.getAnalyticsData()!=null)
		{
			
			analyticsdatalist=obj.getAnalyticsData();
			
			out.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "    <head>\r\n"
					+ "        <title>Analytics Data</title>\r\n"
					+ "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n"
					+ "        <meta charset=\"UTF-8\">\r\n"
					+ "        <meta name=\"description\" content=\"Analytics Data\">\r\n"
					+ "        <meta name=\"keywords\" content=\"homepage,movies,cities,tickets,queries\">\r\n"
					+ "        <meta name=\"author\" content=\"Aditya Nalla\">\r\n"
					+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    </head>\r\n"
					+ "    <body>\r\n"
					+"<table class=\"table table-dark\">\r\n"
					+ "            <thead>\r\n"
					+ "              <tr>\r\n"
					+ "                <th scope=\"col\">S.NO</th>\r\n"
					+ "                <th scope=\"col\">Movie Name</th>\r\n"
					+ "                <th scope=\"col\">Screen Area</th>\r\n"
					+ "                <th scope=\"col\">Cost</th>\r\n"
					+ "                <th scope=\"col\">Seats</th>\r\n"
					+ "                <th scope=\"col\">Booked</th>\r\n"
					+ "                <th scope=\"col\">Date</th>\r\n"
					+ "                <th scope=\"col\">Revenue</th>\r\n"
					+ "              </tr>\r\n"
					+ "            </thead>"
					+"             <tbody>"
					+ "");
			
			for(int i=0;i<analyticsdatalist.size();i++)
			{
			
				out.print("<tr>\r\n");
				out.print("<th scope=\"row\">"+ analyticsdatalist.get(i).reportid +"</th>");
				out.print("<td>"+analyticsdatalist.get(i).moviename +"</td>");
				out.print("<td>"+analyticsdatalist.get(i).screenname +"</td>");
				out.print("<td>"+analyticsdatalist.get(i).cost +"</td>");
				out.print("<td>"+analyticsdatalist.get(i).seats +"</td>");
				out.print("<td>"+analyticsdatalist.get(i).bookedseats +"</td>");
				out.print("<td>"+analyticsdatalist.get(i).date +"</td>");
				out.print("<td>"+analyticsdatalist.get(i).revenue +"</td>");
						
						
				out.print("              </tr>");
				
			
			}
		
			out.print("   </tbody>\r\n"
					+ "          </table>"
					+"    </body>\r\n"
					+ "</html>\r\n"
					+ "");
			
		}
		else {
			out.print("<p>No Data Sorry..");
		}
		
		
	}

}
