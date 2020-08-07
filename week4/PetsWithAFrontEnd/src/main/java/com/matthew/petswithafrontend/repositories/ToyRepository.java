package com.matthew.petswithafrontend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.petswithafrontend.models.Toy;

@Repository
public interface ToyRepository extends CrudRepository<Toy, Long>{

}
