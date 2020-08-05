package com.matthew.petswithafrontend.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.petswithafrontend.models.Pet;
import com.matthew.petswithafrontend.models.Tag;
import com.matthew.petswithafrontend.services.PetService;
import com.matthew.petswithafrontend.services.TagService;

@Controller
public class PetController {
	
	private PetService pService;
	private TagService tService;
	
	public PetController(PetService service, TagService tService) {
		this.pService = service;
		this.tService = tService;
	}
	@RequestMapping("/")
	public String index(Model viewModel) {
		List<Pet> pets = this.pService.getAllPets();
		viewModel.addAttribute("pets", pets);
		return "index.jsp";
	}
	
	@RequestMapping("/new")
	public String create(@ModelAttribute("pet") Pet pet) {
		return "redirect:/";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String createPet(@Valid @ModelAttribute("pet") Pet pet, BindingResult result) {
		if(result.hasErrors()) {
			// invalid input was received.
			return "new.jsp";
		} else {
			// everything is all good, we can create the pet class
			this.pService.createPet(pet);
		}
		return "redirect:/new";
	}
	
	@RequestMapping("/{id}")
	public String viewpet(@PathVariable("id") Long id, Model model, @ModelAttribute("tag") Tag tag) {
		model.addAttribute("pet", pService.getOnePet(id));
		return "show.jsp";
	}
	
	@PostMapping("/tag")
	public String createTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model  model) {
		Long petID = tag.getPet().getId();
		if(result.hasErrors()) {
			model.addAttribute("pet", pService.getOnePet(petID));
			return "show.jsp";
		} else {
			this.tService.create(tag);
			return "redirect:/" + petID;
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String updatePet(@Valid @ModelAttribute("pet") Pet updatedPet, BindingResult result) {
		if(result.hasErrors()) {
			return "show.jsp";
		} else {
			pService.updatePet(updatedPet);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String oldWay(@RequestParam("name") String name, @RequestParam("species") String species, @RequestParam("age") int age, RedirectAttributes redirectAttributes) {		
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			// Flag Bad Validation
			errors.add("Hey there, you forgot to add a name");
		}
		if(errors.size() > 0) {
			for(String e: errors) {
				redirectAttributes.addFlashAttribute("error", e);
			}
			return "redirect:/new";
			//iterated through the errors
		}
		
		
		
		// Add A Pet
		this.pService.createPet(name, species, age);
		return "redirect:/";
	}
}
