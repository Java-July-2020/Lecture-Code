package com.matthew.petswithafrontend.services;

import org.springframework.stereotype.Service;

import com.matthew.petswithafrontend.models.Tag;
import com.matthew.petswithafrontend.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository repo;
	public TagService(TagRepository repo) {
		this.repo = repo;
	}
	
	// Create 
	public Tag create(Tag tag) {
		return this.repo.save(tag);
	}
}
