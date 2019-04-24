package es.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.SupervisorDAO;
import es.upm.dit.isst.webLab.dao.SupervisorDAOImplementation;
import es.upm.dit.isst.webLab.model.Supervisor;


@WebServlet("/SupervisorSolicitudViajeServlet")
public class SupervisorSolicitudViajeServlet  extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		getServletContext().getRequestDispatcher( "/supervisorSolicitudesViaje.jsp" ).forward( req, resp );
	}
	
}
