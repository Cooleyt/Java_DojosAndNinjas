package com.cooley.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooley.dojosandninjas.models.Ninja;
import com.cooley.dojosandninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	
	@Autowired
	NinjaRepo ninjaRepo;
	
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja oneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		
		else {
			return null;
		}
	}
	
	public void deleteNinja(Long id) {
    	ninjaRepo.deleteById(id);
    }

}
