package com.keskadaniel.garden.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.keskadaniel.garden.models.forms.PlantForm;
import com.keskadaniel.garden.models.services.PlantService;
import com.keskadaniel.garden.models.services.UserService;

@Controller
public class PlantController {

	@Autowired
	PlantService plantService;

	@Autowired
	UserService userService;

	@GetMapping("/addplant")
	public String addPlant(Model model) {

		model.addAttribute("user", userService.getUserData());
		model.addAttribute("plantForm", new PlantForm());

		return "addplant";
	}

	@PostMapping("/addplant")
	public String addPlant(@ModelAttribute PlantForm plantForm) {

		if (!userService.isLogin()) {
			return "redirect:/login";
		}

		plantService.addPlant(plantForm);

		return "redirect:/plants";
	}

	@GetMapping("/plants/{id}")
	public String showPlants(Model model, @PathVariable("id") int userId) {

		if (userService.getUserData() == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("user", userService.getUserData());
		model.addAttribute("plants", plantService.getAllPlantsByUser(userId));

		return "plants";
	}

	@GetMapping("/plant/{id}")
	public String showPlant(Model model, @PathVariable("id") int plantId) {

		model.addAttribute("user", userService.getUserData());
		model.addAttribute("plant", plantService.getPlantById(plantId).get());

		return "plant";
	}

}
