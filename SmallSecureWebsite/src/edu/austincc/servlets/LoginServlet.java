package edu.austincc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.austincc.database.DBManager;
import edu.austincc.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String url = "/index.html";
    	
    	String age = request.getParameter("age");
    	
    	if (age != null) {
    		url = "/WEB-INF/login.jsp";
    		request.setAttribute("age", age);
    	}
    
    	
    	// If age is 25, set reponse to tell browser to redirt to cnn
    	int ageNum = new Integer(age);
    	if (ageNum == 25) {
    		url = "http://www.cnn.com";
    		response.sendRedirect(url);
    		return;
    	}
    	
    	getServletContext().getRequestDispatcher(url).forward(request, response);
    
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/WEB-INF/login.jsp";
		
		String action = request.getParameter("action");
		
		if (action == null) {
			url = "/WEB-INF/login.jsp";
		}
		
		if (action.equalsIgnoreCase("login")) {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
	
			User theFoundUser = DBManager.findUserWithNameAndPassword(name, password);
			
			// If we find the user set the user on the request and foward to the main page
			// otherwise send them back to the login page
			if (theFoundUser != null) {
				request.setAttribute("user", theFoundUser);
				request.setAttribute("capName", theFoundUser.getCapitalizedUserName());
				url = "/WEB-INF/main.jsp";
			} else {
				url = "/WEB-INF/login.jsp";
			}
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	

}
