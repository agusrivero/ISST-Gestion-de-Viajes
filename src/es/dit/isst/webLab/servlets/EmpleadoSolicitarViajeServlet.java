package es.dit.isst.webLab.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java .util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.EmpleadoDAO;
import es.upm.dit.isst.webLab.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.webLab.dao.SupervisorDAO;
import es.upm.dit.isst.webLab.dao.SupervisorDAOImplementation;
import es.upm.dit.isst.webLab.dao.ViajeDAO;
import es.upm.dit.isst.webLab.dao.ViajeDAOImplementation;
import es.upm.dit.isst.webLab.model.Empleado;
import es.upm.dit.isst.webLab.model.Supervisor;
import es.upm.dit.isst.webLab.model.Viaje;

@WebServlet({"/EmpleadoSolicitarViajeServlet"})
public class EmpleadoSolicitarViajeServlet extends HttpServlet {
	
	private String empleadoEmail;
	private Empleado empleado;
	private Supervisor supervisor;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.empleadoEmail = req.getParameter("email");
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		SupervisorDAO sdao = SupervisorDAOImplementation.getInstance();
		this.empleado =  edao.read(this.empleadoEmail);
		this.supervisor = this.empleado.getSupervisor();
		

	
		getServletContext().getRequestDispatcher( "/empleadoSolicitarViaje.jsp" ).forward( req, resp );

	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String destino = req.getParameter("destino");
		String origen = req.getParameter("origen");
		String fechaInicio = req.getParameter("fechaInicio"); 
		String fechaFin = req.getParameter("fechaFin"); 
		String descripcion = req.getParameter("descripcion");
		String precio = req.getParameter("precio"); 
		
		Viaje viaje = new Viaje();
		
		viaje.setDestino(destino);
		viaje.setFechaFin(fechaFin);
		viaje.setFechaInicio(fechaInicio);
		viaje.setOrigen(origen);
		viaje.setDescripcion(descripcion);

		viaje.setPrecio(precio);
		viaje.setEmpleado(this.empleado);

		ViajeDAO vdao = ViajeDAOImplementation.getInstance();
		vdao.create( viaje );
		
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		edao.update(this.empleado);
		
		req.getSession().setAttribute("rino",viaje.getFechaFin());
		
		resp.sendRedirect( req.getContextPath() + "/EmpleadoSolicitarViajeServlet?email="+this.empleadoEmail);
	}
	
	
	
}

