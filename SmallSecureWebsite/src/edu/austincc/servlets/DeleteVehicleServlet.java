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
import edu.austincc.exceptions.DBErrorException;

/**
 * Servlet implementation class DeleteVehicleServlet
 */
@WebServlet({ "/DeleteVehicleServlet", "/deleteVehicle" })
public class DeleteVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/DB")
	DataSource ds;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getContextPath() + "/listVehicles";
		
		boolean updateSucceeded = false;
		
		int id = new Integer(request.getParameter("id"));
		
		
		try {
			updateSucceeded = new VehiclesManager(ds).deleteVehicleWithID(id);
		} catch (DBErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		if (updateSucceeded != true) {
			request.setAttribute("error", "Delete of database record failed.");
			url = "/WEB-INF/listVehicles";

			getServletContext().getRequestDispatcher(url).forward(request, response);
			return;
		}
		
		response.sendRedirect(url);
	}

}
