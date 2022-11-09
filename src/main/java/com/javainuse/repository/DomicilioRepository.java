package com.javainuse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Domicilio;

//@Repository
public interface DomicilioRepository extends CrudRepository<Domicilio, Long>{

}
