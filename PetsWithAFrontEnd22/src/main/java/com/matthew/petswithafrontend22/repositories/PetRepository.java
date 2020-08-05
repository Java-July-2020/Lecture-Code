package com.matthew.petswithafrontend22.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.petswithafrontend22.models.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long>{
	List<Pet> findAll();
}
