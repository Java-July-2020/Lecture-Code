package com.matthew.superSecret.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.superSecret.models.Wedding;
import com.matthew.superSecret.repositories.WeddingRepository;

@Service
public class WeddingService {
	@Autowired
	private WeddingRepository wRepo;
	
	public List<Wedding> getWeddings(){
		return this.wRepo.findAll();
	}
	
	public Wedding getById(Long id) {
		return this.wRepo.findById(id).orElse(null);
	}
	
	public Wedding create(Wedding wedding) {
		return this.wRepo.save(wedding);
	}
}
