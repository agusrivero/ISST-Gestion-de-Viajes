package es.upm.dit.isst.webLab.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Supervisor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String email;
	private String password;
	private String name;
	private String departamento;
	private String empresa;
	private String cuenta;
	private String dni;
	
	
	@OneToMany(mappedBy="supervisor",fetch=FetchType.LAZY)
	private List<Empleado> empleados;
	
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public Supervisor(){
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
	
	public String getDepartamento() {
		return departamento;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getCuenta() {
		return cuenta;
	}

	public String getDni() {
		return dni;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}