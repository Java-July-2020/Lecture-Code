package com.matthew.petswithafrontend.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.petswithafrontend.models.Toy;
import com.matthew.petswithafrontend.services.PetService;
import com.matthew.petswithafrontend.services.ToyService;

@Controller
@RequestMapping("/toys")
public class ToyController {
	@Autowired
	private ToyService tService;
	@Autowired
	private PetService pService;
	//localhost:8080/toys/new
	@RequestMapping("/new")
	public String createToy(@ModelAttribute("toy") Toy toy, Model model) {
		model.addAttribute("pets", this.pService.getAllPets());
		return "toys/new.jsp";
	}
	
	//localhost:8080/toys//
	@PostMapping("")
	public String create(@Valid @ModelAttribute("toy") Toy toy, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("pets", this.pService.getAllPets());
			return "toys/new.jsp";
		} else {
			this.tService.create(toy);
			return "redirect:/pets";
		}
	}
}
