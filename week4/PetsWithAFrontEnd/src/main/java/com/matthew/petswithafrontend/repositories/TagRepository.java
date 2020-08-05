package com.matthew.petswithafrontend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.petswithafrontend.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{

}
