package com.javainuse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Persona;

//el que hara las query hacia la base de datos
@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
	//tiene que ser el nombre del atributo con la primera letra en mayus
	//Persona findByNombre(String nombre);
	//si quiero que sea una lista
	/*List<Persona> findByNombre(String nombre);
	
	List<Persona> findByDomicilio(String domicilio);
	
	List<Persona> findByDomicilioAndNombre(String domicilio, String nombre);
	

	List<Persona> findByDomicilioOrNombre(String domicilio, String nombre);
	

	List<Persona> findByDomicilioAndNombreOrderById(String domicilio, String nombre);
	
	//creo mis propias queries
	@Query("select per from Persona per where per.nombre = :nombre")
	List<Persona> buscarPorNombre(String nombre);*/
}
