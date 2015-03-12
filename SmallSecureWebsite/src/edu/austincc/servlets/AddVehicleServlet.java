package edu.austincc.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import edu.austincc.databaseManagers.VehiclesManager;
import edu.austincc.domain.Vehicle;
import edu.austincc.exceptions.DBErrorException;

/**
 * Servlet implementation class AddVehicleServlet
 */
@WebServlet({ "/AddVehicleServlet", "/addVehicle" })
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Resource(name="jdbc/DB")
	DataSource ds;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/WEB-INF/addVehicle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getContextPath() + "/listVehicles";
		boolean updateSucceeded = false;
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		int year = new Integer(request.getParameter("year"));
		int mileage = new Integer(request.getParameter("mileage"));
		
	
		
		try {
			updateSucceeded = new VehiclesManager(ds).addVehicleForValues(make, model, color, year, mileage);
		} catch (DBErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		if (updateSucceeded != true) {
			request.setAttribute("error", "Update of database record failed.");
			url = "/WEB-INF/addVehicle";
			request.setAttribute("make", make);
			request.setAttribute("model", model);
			request.setAttribute("color", color);
			request.setAttribute("year", year);
			request.setAttribute("mileage", mileage);
			
			getServletContext().getRequestDispatcher(url).forward(request, response);
			return;
		}
		
		response.sendRedirect(url);
	}

}
