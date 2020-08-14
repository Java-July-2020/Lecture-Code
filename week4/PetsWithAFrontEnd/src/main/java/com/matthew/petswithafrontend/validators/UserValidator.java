package com.matthew.petswithafrontend.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.matthew.petswithafrontend.models.User;
import com.matthew.petswithafrontend.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Matthew", "Passwords do not match!!!!!!!!!!!!!!!!!!!!!");
		}
		
		// Make sure email is unique in the DB
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "Email is already taken");
		}
		

	}
	
	
}
