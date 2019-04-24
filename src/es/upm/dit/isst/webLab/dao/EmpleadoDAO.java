package es.upm.dit.isst.webLab.dao;

import java.util.Collection;

import es.upm.dit.isst.webLab.model.Empleado;
public interface EmpleadoDAO {

	public void create(Empleado empleado);
	public Empleado read(String email);
	public void update(Empleado empleado);
	public void delete(Empleado empleado);
	public Collection<Empleado> readAll();
	public Empleado loginEmpleado(String email, String password);
}
