package es.upm.dit.isst.webLab.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.webLab.model.Supervisor;

public class SupervisorDAOImplementation implements SupervisorDAO{
	
	private static SupervisorDAOImplementation instancia = null;
	
	private SupervisorDAOImplementation(){
		
	}
	
	public static SupervisorDAOImplementation getInstance(){
		if(null == instancia){
			instancia = new SupervisorDAOImplementation();
		}
		return instancia;
	}

	@Override
	public void create(Supervisor supervisor) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.save(supervisor);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}		
	}

	@Override
	public Supervisor read(String email) {
		Session session = SessionFactoryService.get().openSession();
		Supervisor supervisor = null;
		try{
			session.beginTransaction();
			supervisor = session.load(Supervisor.class, email);
			session.getTransaction().commit();	
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		return supervisor;
	}

	@Override
	public void update(Supervisor supervisor) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(supervisor);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		
	}
	
	
	
	@Override
	public void delete(Supervisor supervisor) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.delete(supervisor);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Supervisor> readAll() {
		Session session = SessionFactoryService.get().openSession();
		Collection<Supervisor> supervisores = null;
		try{
			session.beginTransaction();
			supervisores = session.createQuery("from Supervisor").list();
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		return supervisores;
	}
	@Override
	public Supervisor loginSupervisor(String email, String password) {
		Supervisor supervisor = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			supervisor = (Supervisor)
					session.createQuery("select u from Supervisor u where u.email= :email and u.password= :password")
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();
			session.getTransaction().commit();
		} catch(Exception e) {
			
		} finally {
			session.close();
			
		}
		return supervisor;
	}
}
