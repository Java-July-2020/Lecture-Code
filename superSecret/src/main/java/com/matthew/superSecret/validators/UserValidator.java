package com.matthew.superSecret.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import com.matthew.superSecret.models.User;
import com.matthew.superSecret.repositories.UserRepository;

public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			errors.rejectValue("password", "Match", "Passwords do not match!!!!!!!!!!!!!!!!!!!!!");
		}
		
		// Make sure email is unique in the DB
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Email is already taken");
		}
		

	}
}
