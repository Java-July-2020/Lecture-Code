package com.matthew.superSecret.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.matthew.superSecret.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	boolean existsByEmail(String email);
	User findByEmail(String email);
	List<User> findAll();
}
