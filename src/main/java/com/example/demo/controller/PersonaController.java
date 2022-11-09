package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Domicilio;
import com.example.demo.entity.Persona;
import com.example.demo.model.PersonaRequest;
import com.example.demo.model.PersonaResponse;
import com.javainuse.repository.PersonaRepository;


@RestController
// @RequestMapping("/personas") //de esta forma agrego esto en el endpoint
public class PersonaController {
	
	//clases singleton no deberian tener atributos
	List<PersonaRequest> personas = new ArrayList<>();
	
	//conecte con el objeto singleton que genero para esa entidad, si no hay creado lo crea
	@Autowired
	PersonaRepository personaRepository;
	
	//puedo decirle que reciba varios endpoints e incluso pedir parametros, pero de manera opcional
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	@GetMapping({"getPersonas", "getAll", "getPersona/{id}"})
	public ResponseEntity<?> getPersonas(@PathVariable(required = false) Long id) {
		
		if(id != null ) {
			//solo trae los peru del atributo domicilio
			Domicilio dom = new Domicilio();
			dom.setId(1l);
			//List<Persona> personas = (List<Persona>) personaRepository.findByDomicilio("peru");
			//solo trae los junior del atributo nombre
			List<Persona> personas = (List<Persona>) personaRepository.findByNombre("junior");
			List<PersonaResponse> personaResponse = new ArrayList<>();
			
			for(Persona p: personas) {
				personaResponse.add(new PersonaResponse(p.getNombre(), p.getDomicilio().getCalle(), p.getDomicilio().getAltura()));
			}
			return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
		} else {
			//me devuelve un unico
			Optional<Persona> persona = personaRepository.findById(id);
			
			return new ResponseEntity<Persona>(persona.get(), HttpStatus.OK);
		}
		
	}
	
	//el parametro por postman debe ser un JSON
	//del tipo {"nombre": "junior","dni": 123456789}
	//el @Valid es necesario para las validaciones
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	@PostMapping("addPersona")
	public ResponseEntity<?> agregarPersona(@Valid @RequestBody PersonaRequest per) {
		System.out.println("Se agrego una persona " + per.toString());
		
		Persona personaEntity = new Persona();
		personaEntity.setApellido(per.getApellido());
		personaEntity.setNombre(per.getNombre());
		personaEntity.setFechaNacimiento(per.getFechaNacimiento());
		//como no tiene id detectara que no está en base
		Domicilio domicilio = new Domicilio();
		domicilio.setCalle("peru");
		domicilio.setAltura(708);
		personaEntity.setDomicilio(domicilio);
		
		personaRepository.save(personaEntity);
		return new ResponseEntity<String>("Ok", HttpStatus.OK); //forma correcta de responder
	}
	
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	@PutMapping("editPersona")
	public ResponseEntity<?> modificarPersona(@RequestBody PersonaRequest per) {
		
		Persona personaEntity = new Persona();
		personaEntity.setId(2l);
		personaEntity.setApellido(per.getApellido());
		personaEntity.setNombre(per.getNombre());
		personaEntity.setFechaNacimiento(per.getFechaNacimiento());
		
		//el save si tiene el entity que en este caso es el id, si tiene, entonces actualiza, si no, lo crea
		personaRepository.save(personaEntity);
		
		return new ResponseEntity<String>("Modificada la persona", HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	//endpoint: http://localhost:8080/deletePersona/:dni
	//lo que está entre llaves debe ser el mismo nombre
	@DeleteMapping("deletePersona/{id}")
	public ResponseEntity<?>  eliminarPersona(@PathVariable Long id) {
		this.personaRepository.deleteById(id);
			return new ResponseEntity<String>("Se eliminó", HttpStatus.OK);
	}

}
