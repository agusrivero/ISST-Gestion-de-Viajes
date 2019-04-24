package es.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authc.UsernamePasswordToken;

import es.upm.dit.isst.webLab.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.webLab.dao.SupervisorDAOImplementation;
import es.upm.dit.isst.webLab.dao.ViajeDAOImplementation;
import es.upm.dit.isst.webLab.model.Empleado;
import es.upm.dit.isst.webLab.model.Supervisor;

@WebServlet({ "/LoginServlet", "/" })
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/LoginView.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter( "email" );
		String pass = req.getParameter( "password" );
		Subject currentUser = SecurityUtils.getSubject();
		if ( !currentUser.isAuthenticated() ) {
			UsernamePasswordToken token = new UsernamePasswordToken( email, pass );
			try {
				currentUser.login( token );
				if ( currentUser.hasRole( "admin" ) ) {
					resp.sendRedirect( req.getContextPath() + "/AdminServlet" );
				}
				else if ( currentUser.hasRole( "supervisor" ) ) {
					resp.sendRedirect( req.getContextPath() + "/SupervisorServlet?email="+currentUser.getPrincipal());
				}
				else {
					resp.sendRedirect( req.getContextPath() + "/EmpleadoServlet?email=" + currentUser.getPrincipal() );
				}
			} catch ( Exception e ) {
				resp.sendRedirect( req.getContextPath() + "/LoginServlet" );
			}
		} else
			resp.sendRedirect( req.getContextPath() + "/LoginServlet" );
	}
}


//private final String USER_ADMIN = "root";
//private final String USER_PASSWORD = "root";
//
//@Override
//
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		String email = req.getParameter("email");
//		String password = req.getParameter("password");
//		
//		Empleado empleado = EmpleadoDAOImplementation.getInstance().loginEmpleado(email, password);
//		Supervisor supervisor = SupervisorDAOImplementation.getInstance().loginSupervisor(email, password);
//
//		if(USER_ADMIN.equals(email) && USER_PASSWORD.equals(password)) {
//			req.getSession().setAttribute("empleados_list", EmpleadoDAOImplementation.getInstance().readAll());
//			req.getSession().setAttribute("supervisor_list", SupervisorDAOImplementation.getInstance().readAll());
//			req.getSession().setAttribute("viajes_list", ViajeDAOImplementation.getInstance().readAll());
//			
//			resp.sendRedirect(req.getContextPath() + "/AdminView.jsp");
//
//
//		} else if(null!=empleado){
//			for( Empleado e : EmpleadoDAOImplementation.getInstance().readAll()) {
//				if(empleado.getEmail()==e.getEmail() && empleado.getPassword() == e.getPassword()) {
//					
//					resp.sendRedirect(req.getContextPath() + "/InicioEmpleado.jsp");
//					
//				}
//			}
//			
//		}else if(null!=supervisor){
//			for( Supervisor s : SupervisorDAOImplementation.getInstance().readAll()) {
//				if(supervisor.getEmail()==s.getEmail() && supervisor.getPassword() == s.getPassword()) {
//					
//					resp.sendRedirect(req.getContextPath() + "/InicioSupervisor.jsp");
//					
//				}
//			}
//			
//		} else {
//			
//			req.getSession().setAttribute("error", "Los datos introducidos son incorrectos.");
//		
//			getServletContext().getRequestDispatcher( "/LoginView.jsp" ).forward( req, resp );
//		}
//		
//	//	SupervisorDAO sdao = SupervisorDAOImplementation.getInstance();
//	//	req.getSession().setAttribute( "supervisor_list", sdao.readAll() );
//	//	getServletContext().getRequestDispatcher( "/LoginView.jsp" ).forward( req, resp );
//	}
//	
//	
//}
