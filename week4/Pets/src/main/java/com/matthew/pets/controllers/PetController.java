package com.matthew.pets.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matthew.pets.models.Pet;
import com.matthew.pets.services.PetService;

@RestController
public class PetController {
	
	private PetService pService;
	
	public PetController(PetService service) {
		this.pService = service;
	}
	
	//Routes
	@RequestMapping("/")
	public List<Pet> index(){
		return this.pService.getAllPets();
	}
	
	@RequestMapping("/{id}")
	public Pet returnOne(@PathVariable("id") Long id) {
		return this.pService.getOnePet(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Pet create(Pet newPet) {
		return this.pService.createPet(newPet);
	}
	
	@RequestMapping(value="/pet/delete/{id}")
	public String removePet(@PathVariable("id") Long id) {
		this.pService.deletePet(id);
		return id + " has been removed from the database";
	}
	
	@RequestMapping(value="/pet/update/{id}", method=RequestMethod.PUT)
	public Pet edit(@PathVariable("id") Long id, Pet updatedPet) {
		return this.pService.updatePet(id, updatedPet);
	}
	
	@RequestMapping("/pet/{species}")
	public List<Pet> species(@PathVariable("species") String species){
		return this.pService.getPetSpecies(species);
	}
	
}
