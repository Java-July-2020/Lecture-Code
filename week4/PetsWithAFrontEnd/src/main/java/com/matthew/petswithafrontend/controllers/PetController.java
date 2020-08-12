package com.matthew.petswithafrontend.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.petswithafrontend.models.Pet;
import com.matthew.petswithafrontend.models.Tag;
import com.matthew.petswithafrontend.models.User;
import com.matthew.petswithafrontend.services.PetService;
import com.matthew.petswithafrontend.services.TagService;
import com.matthew.petswithafrontend.services.UserService;


@Controller
public class PetController {
	
	private PetService pService;
	private TagService tService;
	private UserService uService;

	
	public PetController(PetService service, TagService tService, UserService uService) {
		this.pService = service;
		this.tService = tService;
		this.uService = uService;

	}
	
	@RequestMapping("/")
	public String landing(Model viewModel) {
		List<User> user = this.uService.allUser();
		viewModel.addAttribute("users", user);
		return "landing.jsp";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, @RequestParam("users") Long id) {
		if(session.getAttribute("user_id")== null) {
			session.setAttribute("user_id", id);
		}
		return "redirect:/pets";
	}
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long petId = id;
		User liker = this.uService.findAUser(userId);
		Pet likedPet = this.pService.getOnePet(petId);
		this.pService.addLiker(liker, likedPet);
		return "redirect:/pets";
	}
	
	@RequestMapping("/pets")
	public String pets(Model viewModel, HttpSession session) {
		Long userID = (long) session.getAttribute("user_id");
		User user = this.uService.findAUser(userID);
		List<Pet> pets = this.pService.getAllPets();
		viewModel.addAttribute("pets", pets);
		viewModel.addAttribute("user", user);
		return "index.jsp";
	}
	
	@RequestMapping("/new")
	public String create(@ModelAttribute("pet") Pet pet) {
		return "new.jsp";
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
	public String createTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model model) {
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
	public String updatePet(@Valid @ModelAttribute("pet") Pet updatedPet, BindingResult result,  @ModelAttribute("tag") Tag tag) {
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
