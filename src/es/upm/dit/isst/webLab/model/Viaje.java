package es.upm.dit.isst.webLab.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Viaje implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	@Id
	private String destino;

	@ManyToOne
	private Empleado empleado;
	private String origen;
	private String fechaInicio;
	private String fechaFin;
	private String precio;
	private String descripcion;
	
	
	
	
	
	public Viaje(){
		
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Empleado getEmpleado() {
		return empleado;
	}



	public String getDestino() {
		return destino;
	}



	public String getOrigen() {
		return origen;
	}



	public String getFechaInicio() {
		return fechaInicio;
	}



	public String getFechaFin() {
		return fechaFin;
	}



	public String getPrecio() {
		return precio;
	}



	public String getDescripcion() {
		return descripcion;
	}






	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}



	public void setDestino(String destino) {
		this.destino = destino;
	}



	public void setOrigen(String origen) {
		this.origen = origen;
	}



	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}



	public void setPrecio(String precio) {
		this.precio = precio;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	
	
}