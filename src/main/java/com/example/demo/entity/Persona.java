package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sys_persona")
public class Persona implements Serializable{
	
	//dice cual sera mi id
	@Id
	//lo hace auto incremental
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//le indica el nombre de la columna
	@Column(name="per_id")
	private Long id;
	@Column(name="per_nombre")
	private String nombre;
	@Column(name="per_apellido")
	private String apellido;
	@Column(name="per_fecha_nacimiento")
	private Date fechaNacimiento;
	
	//muchos a uno
	//@ManyToOne(cascade = CascadeType.ALL)
	//pk de la tabla sys_dom
	//@JoinColumn(name = "dom_id")
	private Domicilio domicilio;
	
	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
