package edu.austincc.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import edu.austincc.databaseManagers.UsersManager;
import edu.austincc.domain.User;
import edu.austincc.exceptions.DBErrorException;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet({ "/UsersServlet", "/users" })
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/DB")
	DataSource ds;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/main.jsp";
		UsersManager um = new UsersManager(ds);
		ArrayList<User> theUsers = null;
		try {
			theUsers = um.getUsers();
		} catch (DBErrorException e) {
			// TODO Auto-generated catch block
			url = "/dberror.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			return;
		} 
		
		// System.out.println(theUsers);
		if (theUsers != null) {
			url = "/WEB-INF/people.jsp";
			
			request.setAttribute("people", theUsers);
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
