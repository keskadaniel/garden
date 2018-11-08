package com.keskadaniel.garden.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.keskadaniel.garden.models.forms.LoginForm;
import com.keskadaniel.garden.models.forms.RegisterForm;
import com.keskadaniel.garden.models.services.UserService;

@Controller
public class AuthController {
	
	@Autowired
	UserService userService;
	
		
	@GetMapping("/register")
	public String register(Model model) {
		
		model.addAttribute("user", userService.getUserData());
		model.addAttribute("registerForm", new RegisterForm());
		
		return "register";
	}
	
	
	@PostMapping("/register")
	public String register(@ModelAttribute RegisterForm registerForm,
						   Model model) {
		
		if(!registerForm.getPassword().equals(registerForm.getPasswordRepeat())) {
			model.addAttribute("info","You invented something else!");
			return "register";
		}
		
		if(userService.isUserExistByUsername(registerForm.getUsername())) {
			model.addAttribute("info","Already taken!");
			return "register";
		}
		
				userService.registerUser(registerForm);
		
		model.addAttribute("info", "Now you can create Your Garden!");
		return "register";
		
	}
	
	  @GetMapping("/login")
	    public String login(Model model) {
	        model.addAttribute("loginForm", new LoginForm());
	        return "login";
	    }

	    @PostMapping("/login")
	    public String login(@ModelAttribute LoginForm loginForm,
	                        Model model) {
	        if (!userService.loginUser(loginForm)) {
	            model.addAttribute("info", "Błędne dane logowania");
	            return "login";
	        }
	        return "redirect:/addplant";
	    }
	    
	    @GetMapping("/logout")
	    public String logOut() {

	        userService.logOut();
	        return "redirect:/login";
	    }
	
	@GetMapping("/user/{id}")
	public String showUser(Model model) {
		
		
		model.addAttribute("user", userService.getUserData());
		
		return "user";
	}

}
