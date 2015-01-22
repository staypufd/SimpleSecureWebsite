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
 * Servlet implementation class ShowPersonServlet
 */
@WebServlet({ "/ShowPersonServlet", "/showperson" })
public class ShowPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String url = "/WEB-INF/listpeople";
		
		String theUserID = request.getParameter("id");
		
		User theFoundUser = DBManager.findUserWithID(theUserID);
		
		if (theFoundUser != null) {
			request.setAttribute("user", theFoundUser);
			request.setAttribute("capName", theFoundUser.getCapitalizedUserName());
			url = "/WEB-INF/viewPersonDetail.jsp";
		} else {
			url = "/WEB-INF/listpeople";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
