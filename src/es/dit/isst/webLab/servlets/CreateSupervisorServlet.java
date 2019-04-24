package es.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;

import es.upm.dit.isst.webLab.model.Supervisor;
import es.upm.dit.isst.webLab.dao.SupervisorDAO;
import es.upm.dit.isst.webLab.dao.SupervisorDAOImplementation;

@WebServlet({ "/CreateSupervisorServlet" })

public class CreateSupervisorServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter( "name" );
		String password = req.getParameter( "password" );
		String email = req.getParameter( "email" );
		String cuenta = req.getParameter( "cuenta" );
		String departamento = req.getParameter( "departamento" );
		String dni = req.getParameter( "dni" );
		String empresa = req.getParameter("empresa");
		Supervisor supervisor = new Supervisor();
		supervisor.setName( name );
		supervisor.setEmail( email );
		supervisor.setCuenta(cuenta);
		supervisor.setDepartamento(departamento);
		supervisor.setDni(dni);
		supervisor.setEmpresa(empresa);
		
		supervisor.setPassword( new Sha256Hash( password ).toString() );
		
		SupervisorDAO pdao = SupervisorDAOImplementation.getInstance();
		pdao.create( supervisor );
		
		
		resp.sendRedirect( req.getContextPath() + "/AdminServlet" );
	
	}

}
