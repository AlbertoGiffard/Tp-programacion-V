package com.example.demo.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class PersonaRequest {
	@NotNull
	@NotEmpty(message = "No puede ser vacio")
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	
	@NotNull
	@Min(value = 0)
	//@Max(value = 9999999999)
	//para strings
	//@NotEmpty(message = "No puede ser vacio")
	private Integer dni;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "PersonaRequest [nombre=" + nombre + ", dni=" + dni + "]";
	}
	
	
}
