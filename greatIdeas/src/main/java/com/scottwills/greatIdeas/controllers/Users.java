package com.scottwills.greatIdeas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.scottwills.greatIdeas.models.User;
import com.scottwills.greatIdeas.services.UserService;
import com.scottwills.greatIdeas.validator.UserValidator;



@Controller
public class Users {
	private UserService userService;
    private UserValidator userValidator;
    
	public Users(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
    
	@RequestMapping("/")
    public String loginReg(@ModelAttribute("user") User user) {
        return "index.jsp";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
			return "index.jsp";
			
		} else {
			userService.registerUser(user);
			session.setAttribute("id", user.getId());
    		return "redirect:/";
		}
    }
    
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	if(userService.authenticateUser(email, password)) {
    		User user = userService.findByEmail(email);
    		session.setAttribute("id", user.getId());
    		return "redirect:/ideas";
    	} else {
    		model.addAttribute("user", new User());
    		model.addAttribute("errorMsg", "Invalid credentials. Please try again.");
    		return "index.jsp";
    	}
    }
    
  	@RequestMapping("/logout")
  	public String logout(HttpSession session) {
  		session.removeAttribute("id");
  		return "redirect:/";
  	}
}
