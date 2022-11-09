package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name="sys_domicilio")
public class Domicilio implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dom_id")
	private Long id;
	@Column(name="calle")
	private String calle;
	@Column(name="altura")
	private Integer altura;
	//uno a muchos
	//que copie el mapeado del atributo domicilio
	/*@OneToMany(mappedBy = "domicilio", fetch = FetchType.LAZY)*/

	public Domicilio() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
