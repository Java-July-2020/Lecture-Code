package com.matthew.petswithafrontend22.services;

import org.springframework.stereotype.Service;

import com.matthew.petswithafrontend22.models.Tag;
import com.matthew.petswithafrontend22.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository repo;
	public TagService(TagRepository repo) {
		this.repo = repo;
	}
	
	// create
	public Tag create(Tag tag) {
		return this.repo.save(tag);
	}
}
