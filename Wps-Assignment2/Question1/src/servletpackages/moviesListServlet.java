package servletpackages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.MovieListDb;


@WebServlet("/moviesListServlet")
public class moviesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public moviesListServlet() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> moviesNamesList;
		PrintWriter out=response.getWriter();
		
		MovieListDb obj=new MovieListDb();
		if(obj.getMoviesList() !=null)
		{
			moviesNamesList=obj.getMoviesList();
		
				out.print("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "    <head>\r\n"
						+ "        <title>Movies List</title>\r\n"
						+ "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n"
						+ "        <meta charset=\"UTF-8\">\r\n"
						+ "        <meta name=\"description\" content=\"movies list\">\r\n"
						+ "        <meta name=\"keywords\" content=\"homepage,movies,cities,tickets,queries\">\r\n"
						+ "        <meta name=\"author\" content=\"Aditya Nalla\">\r\n"
						+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    </head>\r\n"
						+ "    <body>\r\n"
						+ "        <ul class=\"list-group\">\r\n");
				for(int i=0;i<moviesNamesList.size();i++)
				{  
					out.print("<li class=\"list-group-item\">"+ moviesNamesList.get(i) +"</li>\r\n");
				}
				
					
					out.print("          </ul>\r\n"
						+ "    </body>\r\n"
						+ "</html>\r\n"
						+ "");
			
			
			
		}
		else {
			out.print("Sorry No movies Available");
		}
	}

}
