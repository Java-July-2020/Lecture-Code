package com.matthew.petswithafrontend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.petswithafrontend.models.Toy;
import com.matthew.petswithafrontend.repositories.ToyRepository;

@Service
public class ToyService {
	@Autowired
	private ToyRepository repo;

	public Toy create(Toy toy) {
		return this.repo.save(toy);
	}
}
