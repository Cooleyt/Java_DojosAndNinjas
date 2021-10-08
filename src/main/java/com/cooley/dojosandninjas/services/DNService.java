package com.cooley.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooley.dojosandninjas.models.Dojo;
import com.cooley.dojosandninjas.repositories.DojoRepo;


@Service	
public class DNService {
private final DojoRepo dojoRepo;
	
	public DNService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	// returns all the dojos
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }
    // creates a dojo
    public Dojo createDojo(Dojo d) {
        return dojoRepo.save(d);
    }
    //updates a dojo
    public Dojo updateDojo(Dojo d) {
        return dojoRepo.save(d);
    }
    // retrieves a Dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    public Dojo oneDojo(Long id) {
    	Optional<Dojo> optionalDojo = dojoRepo.findById(id);
    	if(optionalDojo.isPresent()) {
    		return optionalDojo.get();		
    	}else {
    		return null;
    	}
    }
    
   
    //updates dojo
    public Dojo updateDojo(Long id, String name, String location) {
    	Dojo dojo = oneDojo(id);
    		dojo.setName(name);
    		dojo.setLocation(location);
    		
    		return dojoRepo.save(dojo);
    }
}
