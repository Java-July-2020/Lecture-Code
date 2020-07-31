package com.matthew.petswithafrontend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matthew.petswithafrontend.models.Pet;
import com.matthew.petswithafrontend.repositories.PetRepository;

@Service
public class PetService {
private PetRepository pRepo;
	
	public PetService(PetRepository repo) {
		this.pRepo = repo;
	}
	
	// getOne
	public Pet getOnePet(Long id) {
		Pet pet = this.pRepo.findById(id).orElse(null);
		return pet;
	}
	
	// getAll
	public List<Pet> getAllPets(){
		return this.pRepo.findAll();
	}
	// createPet
	public Pet createPet(Pet newPet) {
		return this.pRepo.save(newPet);
	}
	
	public Pet createPet(String name, String species, int age) {
		Pet newPet = new Pet(name, species, age);
		return this.pRepo.save(newPet);
	}
	
	// deletePet
	public void deletePet(Long id) {
		this.pRepo.deleteById(id);
	}
	// updatePet
	public Pet updatePet(Long id, Pet updatedPet) {
		return this.pRepo.save(updatedPet);
	}
	
}
