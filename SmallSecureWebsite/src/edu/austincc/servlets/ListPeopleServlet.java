package edu.austincc.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import edu.austincc.database.DBManager;
import edu.austincc.databaseManagers.UsersManager;
import edu.austincc.domain.User;


/**
 * Servlet implementation class ListPeopleServlet
 */
@WebServlet({ "/ListPeopleServlet", "/listpeople" })
public class ListPeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/DB")
	DataSource ds;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPeopleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/index.jsp";
		
		HttpSession session = request.getSession();
		
		Boolean loggedInBoolean = (Boolean) session.getAttribute("isLoggedIn");
		if ( loggedInBoolean != null ) {
			boolean loggedIn = loggedInBoolean.booleanValue();
			 
			if ( loggedIn ) {
				
				ArrayList<User> people = new UsersManager(ds).getUsers();
				
				url = "/WEB-INF/people.jsp";
				
				request.setAttribute("people", people);
			}
		}

		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
