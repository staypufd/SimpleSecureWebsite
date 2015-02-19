package edu.austincc.servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.austincc.database.DBManager;
import edu.austincc.domain.User;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet({ "/AddUserServlet", "/adduser" })
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String url = "/index.jsp";
		
		HttpSession session = request.getSession();
		Boolean loggedIn = (Boolean)session.getAttribute("isLoggedIn");
		if (loggedIn != null) { 
			boolean isLoggedIn = loggedIn.booleanValue();
			if ( isLoggedIn ) {
			
				url = "/WEB-INF/add-user.jsp";
			}
		}
    	getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/WEB-INF/add-user.jsp";
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String verify_password = request.getParameter("verify_password");
		
		if ( ! password.equalsIgnoreCase( verify_password) ) {
			url = "/WEB-INF/add-user.jsp";
		} else {
			User newUser = new User(email, name, UUID.randomUUID(), verify_password);
			DBManager.sharedInstance().addUser(newUser);
			response.sendRedirect("/listpeople");
			
			// We have to return so the we exit this method and don't try to forward below.
			// the sendRedirect above tells the response object to put that data on and close 
			// response object and send it back to web browser.  So return out of this method
			return;
		}
		
		// To the url
		getServletContext().getRequestDispatcher(url).forward(request, response);
				
	}

}
