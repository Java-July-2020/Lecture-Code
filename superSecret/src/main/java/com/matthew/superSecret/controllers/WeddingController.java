package com.matthew.superSecret.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.superSecret.models.Wedding;
import com.matthew.superSecret.services.UserService;
import com.matthew.superSecret.services.WeddingService;

@Controller
@RequestMapping("/weddings")
public class WeddingController {
	@Autowired
	private WeddingService wService;
	@Autowired
	private UserService uService;
	
	@GetMapping("/new")
	private String newWedding(@ModelAttribute("wedding") Wedding wedding, HttpSession sesh, Model viewModel) {
		Long userId = (Long)sesh.getAttribute("user_id");
		viewModel.addAttribute("user_id", userId);
		return "new.jsp";
	}
	
	@PostMapping("")
	private String create(@Valid @ModelAttribute("wedding") Wedding wedding, HttpSession sesh, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long)sesh.getAttribute("user_id");
			viewModel.addAttribute("user_id", userId);
			return "new.jsp";
		}
		this.wService.create(wedding);
		return "redirect:/weddings";
	}
	
	@GetMapping("")
	public String dashboard(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("user", this.uService.findAUser(userId));
		viewModel.addAttribute("weddings", this.wService.getWeddings());
		return "dashboard.jsp";
	}
	
	@GetMapping("/{yourWeddingId}")
	public String showcase(@PathVariable("yourWeddingId") Long id, Model viewModel) {
		viewModel.addAttribute("wedding", this.wService.getById(id));
		return "details.jsp";
	}
}
