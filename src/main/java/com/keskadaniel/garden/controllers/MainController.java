package com.keskadaniel.garden.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.keskadaniel.garden.models.services.DateService;
import com.keskadaniel.garden.models.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DateService dataService;

	@GetMapping("/")
	public String index(Model model) {
		
		if(userService.getUserData()==null) {
			return "redirect:/login";
		}
		
		model.addAttribute("user", userService.getUserData());
		model.addAttribute("months", dataService.showMonths());
		
		return "index";
	}
	
	
	
	
}
