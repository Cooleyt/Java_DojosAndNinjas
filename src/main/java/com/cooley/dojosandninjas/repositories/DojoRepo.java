package com.cooley.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooley.dojosandninjas.models.Dojo;


@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long>{
	
	List<Dojo> findAll();
	 
	 List<Dojo> findByLocationContaining(String search);
	 
	 Long countByNameContaining(String search);
	 
	 Long deleteByNameStartingWith(String search);
}
