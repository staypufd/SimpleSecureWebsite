package edu.austincc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Resource(name="jdbc/DB") 
	DataSource ds;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
//    	try {
//    		Connection conn = ds.getConnection();
//			PreparedStatement theQuery = conn.prepareStatement("SELECT * FROM ACC_USER");
//			ResultSet rs = theQuery.executeQuery();
//			
//			while (rs.next()) {
//				System.out.println(rs.getInt("ID"));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	
    	
    	String url = "/index.jsp";
    	
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
			boolean isDBError = false;
	
			// User theFoundUser = DBManager.sharedInstance().findUserWithNameAndPassword(name, password);
			User theFoundUser = null;
			try {
				theFoundUser = new UsersManager(ds).findUserWithNameAndPassword(name, password);
			} catch (DBErrorException e) {
				// TODO Auto-generated catch block
				url = "/dberror.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				return;
			} 
			
			// If we find the user set the user on the request and foward to the main page
			// otherwise send them back to the login page
			if (theFoundUser != null) {
				request.setAttribute("user", theFoundUser);

				HttpSession session = request.getSession();
				session.setAttribute("isLoggedIn", true); 
				session.setAttribute("capName", theFoundUser.getCapitalizedUserName());
			
				
				url = "/WEB-INF/main.jsp";  
			} else { 
				request.setAttribute("error", "The username or password was incorrect!");
				url = "/WEB-INF/login.jsp"; 
			}
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	

}
