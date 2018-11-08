package com.keskadaniel.garden.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keskadaniel.garden.models.PlantEntity;
import com.keskadaniel.garden.models.forms.ActionForm;
import com.keskadaniel.garden.models.services.ActionService;
import com.keskadaniel.garden.models.services.PlantService;
import com.keskadaniel.garden.models.services.UserService;

@Controller
public class ActionController {

	@Autowired
	ActionService actionService;

	@Autowired
	PlantService plantService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/addaction/{id}")
	public String addAction(Model model, @PathVariable("id") int id ) {

//		Optional<PlantEntity> plantEntity = plantService.getPlantById(id);
//		if (plantEntity.isPresent()) {
//			model.addAttribute("plant", plantEntity.get());
//		}
		model.addAttribute("user", userService.getUserData());
		model.addAttribute("plant", plantService.getPlantById(id).get());
		model.addAttribute("actionForm", new ActionForm());

		return "addaction";
	}

	@PostMapping("/addaction/{id}")
	public String addAction(@ModelAttribute ActionForm actionForm,
						    @PathVariable("id") int id) {
		
		if(!userService.isLogin()) {
			return "redirect:/";
		}
		
		actionService.addAction(actionForm, id);
		return "redirect:/plant/"+id;
	}
	
	@GetMapping("action/{id}")
	public String showActions (@PathVariable("id") int id, Model model) {
		
		model.addAttribute("user", userService.getUserData());

		model.addAttribute("actions", actionService.getAllActionsByUser(id));
		return "action";
	}
	

}
