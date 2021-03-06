package edu.austincc.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import edu.austincc.databaseManagers.DBManager;
import edu.austincc.databaseManagers.UsersManager;
import edu.austincc.domain.User;
import edu.austincc.exceptions.DBErrorException;

/**
 * Servlet implementation class ShowPersonServlet
 */
@WebServlet({ "/ShowPersonServlet", "/showperson" })
public class ShowPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/DB")
	DataSource ds;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPersonServlet() {
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
		boolean loggedIn = (boolean)session.getAttribute("isLoggedIn");
		 
		if ( loggedIn ) {
		
			url = "/WEB-INF/listpeople";
			
			String theUserID = request.getParameter("id");
			User theFoundUser = null;
			try {
				theFoundUser = new UsersManager(ds).getUserWithID(theUserID);
			} catch (DBErrorException e) {
				// TODO Auto-generated catch block
				url = "/dberror.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				return;
			} 
			
			if (theFoundUser != null) {
				request.setAttribute("user", theFoundUser);
				request.setAttribute("capName", theFoundUser.getCapitalizedUserName());
				url = "/WEB-INF/viewPersonDetail.jsp";
			} else {
				url = "/WEB-INF/people";
			}
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
