package es.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.EmpleadoDAO;
import es.upm.dit.isst.webLab.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.webLab.dao.SupervisorDAO;
import es.upm.dit.isst.webLab.dao.SupervisorDAOImplementation;



@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SupervisorDAO sdao = SupervisorDAOImplementation.getInstance();
		req.getSession().setAttribute( "supervisor_list", sdao.readAll() );
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		req.getSession().setAttribute( "empleado_list", edao.readAll() );
		
		getServletContext().getRequestDispatcher( "/AdminView.jsp" ).forward( req, resp );
	}
	
	
}
