package servletpackages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AuthDB;


@WebServlet(description = "for signing up", urlPatterns = { "/signupServlet" })
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public signupServlet() {
        super();
        
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPhoneNumber = request.getParameter("signupUserPhoneNumber");
		String userEmail = request.getParameter("signupUserMail");
		String userPassword = request.getParameter("signupUserPassword");
		
		System.out.println(userPhoneNumber+" "+userEmail+" "+userPassword);
		
		if(userPassword.length()>6) {
			AuthDB auth = new AuthDB();
			if(auth.addCredentials(userPhoneNumber,userEmail,userPassword)) {
				RequestDispatcher rd=request.getRequestDispatcher("/home.html");
				rd.include(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			}
	}

	}
}
