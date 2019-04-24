package es.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.webLab.model.Empleado;
import es.upm.dit.isst.webLab.dao.EmpleadoDAO;
import es.upm.dit.isst.webLab.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.webLab.model.Supervisor;
import es.upm.dit.isst.webLab.dao.SupervisorDAO;
import es.upm.dit.isst.webLab.dao.SupervisorDAOImplementation;



@WebServlet({ "/CreateEmpleadoServlet" })

public class CreateEmpleadoServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter( "name" );
		String password = req.getParameter( "password" );
		String email = req.getParameter( "email" );
		String empresa = req.getParameter("empresa");
		String departamento = req.getParameter("departamento");
		String cuenta = req.getParameter("cuenta");
		String dni = req.getParameter("dni");
		String supervisoremail = req.getParameter("supervisor");
		Empleado empleado = new Empleado();
		empleado.setName( name );
		empleado.setEmail( email );
		empleado.setCuenta(cuenta);
		empleado.setDepartamento(departamento);
		empleado.setDni(dni);
		empleado.setEmpresa(empresa);
		
	
		empleado.setPassword( new Sha256Hash( password ).toString() );
		
		SupervisorDAO sdao = SupervisorDAOImplementation.getInstance();
		Supervisor sup = sdao.read(supervisoremail);
		
		empleado.setSupervisor(sup);
		
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		edao.create( empleado );
		
		resp.sendRedirect( req.getContextPath() + "/AdminServlet" );
	
	}

}
