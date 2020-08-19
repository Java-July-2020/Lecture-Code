package com.matthew.petswithafrontend.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.matthew.petswithafrontend.validators.UserValidator;


@Controller
public class PetController {
	
	private PetService pService;
	private TagService tService;
	private UserService uService;
	private UserValidator validator;

	
	public PetController(PetService service, TagService tService, UserService uService, UserValidator validator) {
		this.pService = service;
		this.tService = tService;
		this.uService = uService;
		this.validator = validator;

	}
	
	@RequestMapping("/")
	public String landing(@ModelAttribute("user") User user) {

		return "landing.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User newUser, BindingResult result, HttpSession session) {
		validator.validate(newUser, result);
		if(result.hasErrors()) {
			// if there are any validation errors
			// we want to return them to the index page
			return "landing.jsp";
		}
		User user = this.uService.registerUser(newUser);
		session.setAttribute("user_id", user.getId());
		return "redirect:/pets";
	}
	
	
	@RequestMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getByemail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/pets";
	}
	
	@GetMapping("/user/{id}")
	public String userProfile(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("user", this.uService.findAUser(id));
		return "profile.jsp";
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
	
	@GetMapping("/unlike/{petid}")
	public String unlike(@PathVariable("petid") Long petId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User liker = this.uService.findAUser(userId);
		Pet likedPet = this.pService.getOnePet(petId);
		this.pService.removeLiker(liker, likedPet);
		return "redirect:/pets";
	}
	
	@RequestMapping("/pets")
	public String pets(Model viewModel, HttpSession session) {
		Long userID = (Long)session.getAttribute("user_id");
		User user = this.uService.findAUser(userID);
		if(userID == null) {
			return "redirect:/";
		}
		
		List<Pet> pets = this.pService.getAllPets();
		viewModel.addAttribute("pets", pets);
		viewModel.addAttribute("user", user);
		return "index.jsp";
	}
	
	@RequestMapping("/new")
	public String create(@ModelAttribute("pet") Pet pet, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("userId", userId);
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
		return "redirect:/pets";
	}
	
	@RequestMapping("/{id}")
	public String viewpet(@PathVariable("id") Long id, Model model, @ModelAttribute("tag") Tag tag, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		model.addAttribute("pet", pService.getOnePet(id));
		model.addAttribute("userId", userId);
		return "show.jsp";
	}
	
	@PostMapping("/tag")
	public String createTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model model, HttpSession session) {
		Long petID = tag.getPet().getId();
		Long userId = (Long)session.getAttribute("user_id");
		if(result.hasErrors()) {
			model.addAttribute("pet", pService.getOnePet(petID));
			model.addAttribute("userId", userId);
			return "show.jsp";
		} else {
			this.tService.create(tag);
			return "redirect:/" + petID;
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String updatePet(@Valid @ModelAttribute("pet") Pet updatedPet, BindingResult result,  @ModelAttribute("tag") Tag tag, HttpSession session, Model model) {
		Long userId = (Long)session.getAttribute("user_id");
		if(result.hasErrors()) {
			model.addAttribute("userId", userId);
			return "show.jsp";
		} else {
			pService.updatePet(updatedPet);
			return "redirect:/pets";
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
	
	// Delete localhost:8080 / <id>
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.pService.deletePet(id);
		return "redirect:/pets";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
