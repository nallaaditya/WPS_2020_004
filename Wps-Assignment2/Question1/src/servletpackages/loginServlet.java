package servletpackages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AuthDB;

@WebServlet(description = "for loggin Servlets", urlPatterns = { "/loginServlet" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public loginServlet() {
        super();
     
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("loginUserMail");
		String userPassword = request.getParameter("loginUserPassword");
		
		System.out.println(userEmail+" "+userPassword);
		
		AuthDB auth = new AuthDB();
		if(auth.checkCredentials(userEmail,userPassword)) {
			RequestDispatcher rd=request.getRequestDispatcher("/home.html");
			rd.include(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
	}

}
