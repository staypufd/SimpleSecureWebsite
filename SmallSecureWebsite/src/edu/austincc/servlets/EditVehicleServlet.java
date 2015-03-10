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

import edu.austincc.databaseManagers.VehiclesManager;
import edu.austincc.domain.Vehicle;
import edu.austincc.exceptions.DBErrorException;

/**
 * Servlet implementation class EditVehicleServlet
 */
@WebServlet({ "/EditVehicleServlet", "/editVehicle" })
public class EditVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/DB")
	DataSource ds;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/index.jsp";
		Vehicle vehicle = null;
		int id = new Integer(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		
		Boolean loggedInBoolean = (Boolean) session.getAttribute("isLoggedIn");
		if ( loggedInBoolean != null ) {
			boolean loggedIn = loggedInBoolean.booleanValue();
			 
			if ( loggedIn ) {
				
				try {
					vehicle = new VehiclesManager(ds).getVehicleWithID(id);			
				} catch (DBErrorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					url = "/dberror.jsp";
					getServletContext().getRequestDispatcher(url).forward(request, response);
					return;
				}
				
				if (vehicle != null) {
					request.setAttribute("vehicle", vehicle);
					request.setAttribute("title", "Edit Vehicle");
					url = "/WEB-INF/editVehicle.jsp";
				}
			}
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "listVehicles";
		
		int id = new Integer(request.getParameter("id"));
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		int year = new Integer(request.getParameter("year"));
		int mileage = new Integer(request.getParameter("mileage"));
		
		Vehicle v = new Vehicle(id, make, model, color, year, mileage);
		
		boolean updateSucceeded = new VehiclesManager(ds).updateVehicle(v);	
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
