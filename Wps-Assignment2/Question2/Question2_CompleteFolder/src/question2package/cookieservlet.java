package question2package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "It gives the last date and time by storing it in cookie", urlPatterns = { "/cookieservlet" })
public class cookieservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cookieservlet() {
        super();
        
    }
    
   
 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException 
	{
		 
	    PrintWriter out = response.getWriter();  
		 
	    Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String present_date = dateFormat.format(date);  
		
		Cookie[] cookie_array = request.getCookies();
		
		
		
	    if(cookie_array==null) {
		    cookie_array[0]=new Cookie("present",present_date);//creating cookie object 
		    response.addCookie(cookie_array[0]);//adding cookie in the response
		    cookie_array[1]=new Cookie("past",present_date);//creating cookie object
		    response.addCookie(cookie_array[1]);//adding cookie in the response
	    }
	    else {
	    	String lastDate = cookie_array[0].getValue();
	    	cookie_array[0].setValue(present_date);
	    	response.addCookie(cookie_array[0]);
	    	cookie_array[1].setValue(lastDate);
	    	response.addCookie(cookie_array[1]);
	    }
	    out.print("past    "+cookie_array[1].getValue());
	    out.print("<br/>");
	    out.print("present "+cookie_array[0].getValue());
	    out.close();
		
		
		
	}

}
