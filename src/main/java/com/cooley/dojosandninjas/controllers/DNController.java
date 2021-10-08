package com.cooley.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cooley.dojosandninjas.models.Dojo;
import com.cooley.dojosandninjas.models.Ninja;
import com.cooley.dojosandninjas.services.DNService;
import com.cooley.dojosandninjas.services.NinjaService;



@Controller
public class DNController {
	
	@Autowired
	DNService dnService;
	@Autowired
	NinjaService ninjaService;

	
	@GetMapping("/dojos")
	public String show(Model model) {
		List<Dojo> allDojos = dnService.allDojos();
		List<Ninja> allNinjas = ninjaService.allNinjas();
		
		model.addAttribute("dojo", allDojos);
		model.addAttribute("ninjas", allNinjas);
		return "index.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dnService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}
	
	@RequestMapping("/dojos/new")
    public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "addDojo.jsp";
    }
	@RequestMapping("/newNinja")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dnService.allDojos();
		model.addAttribute("dojo", allDojos);
		
		return "NewNinja.jsp";
	}
	
	
    @RequestMapping(value="/dojos/new", method=RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "addDojo.jsp";
        } else {
            dnService.createDojo(dojo);
            return "redirect:/dojos";
        }
    }
    
    @RequestMapping(value="/createNinja", method= RequestMethod.POST)
    public String CreateNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
    	if(result.hasErrors()) {
    		return "NewNinja.jsp";
    	}
    	ninjaService.create(ninja);
    	return "redirect:/dojos";
    }
    
    @RequestMapping("/dojos/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dnService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "editDojo.jsp";
    }
    
    @RequestMapping(value="/dojos/{id}/edit", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "editDojo.jsp";
        } 
        else {
            dnService.updateDojo(dojo);
            return "redirect:/dojos";
        }
    }
    
    @RequestMapping(value="/dojos/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        ninjaService.deleteNinja(id);
        return "redirect:/dojos";
    }
}
