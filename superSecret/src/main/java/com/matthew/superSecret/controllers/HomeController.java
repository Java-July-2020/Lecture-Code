package com.matthew.superSecret.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.superSecret.models.User;
import com.matthew.superSecret.services.UserService;

import com.matthew.superSecret.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired 
	private UserService uService;

	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User newUser, BindingResult result, HttpSession session) {

		if(result.hasErrors()) {
			// if there are any validation errors
			// we want to return them to the index page
			return "landing.jsp";
		}
		User user = this.uService.registerUser(newUser);
		session.setAttribute("user_id", user.getId());
		return "redirect:weddings/";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttrs, HttpSession session) {
	if(!this.uService.authenticateUser(email, password)) {
		redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
		return "redirect:/";
	}
	User user = this.uService.getByemail(email);
	session.setAttribute("user_id", user.getId());
	return "redirect:weddings/";
	}
	
	@RequestMapping("/weddings")
	public String display() {
		return "dashboard.jsp";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
