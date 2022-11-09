package com.example.demo.model;

public class PersonaResponse {
	private String nombre;
	private String calle;
	private Integer altura;
	public PersonaResponse(String nombre, String calle, Integer altura) {
		this.nombre = nombre;
		this.calle = calle;
		this.altura = altura;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	
}
