package es.upm.dit.isst.webLab.dao;

import java.util.Collection;

import es.upm.dit.isst.webLab.model.Supervisor;
public interface SupervisorDAO {

	public void create(Supervisor supervisor);
	public Supervisor read(String email);
	public void update(Supervisor supervisor);
	public void delete(Supervisor supervisor);
	public Collection<Supervisor> readAll();
	public Supervisor loginSupervisor(String email, String password);
}
