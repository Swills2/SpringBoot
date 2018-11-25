package com.scottwills.greatIdeas.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scottwills.greatIdeas.models.UserIdea;
import com.scottwills.greatIdeas.models.Idea;
import com.scottwills.greatIdeas.models.User;
import com.scottwills.greatIdeas.services.UserService;
import com.scottwills.greatIdeas.services.IdeaService;



@Controller
public class Ideas {
	private UserService userService;
	private IdeaService ideaService;
    
	public Ideas(UserService userService, IdeaService ideaService) {
		this.userService = userService;
		this.ideaService = ideaService;
	}
  	
    @RequestMapping("/ideas")
    public String dashboard(Model model, HttpSession session, @ModelAttribute("ucObj") UserIdea ui) {
    	Long id = (Long) session.getAttribute("id");
		if(id == null) {
			return "redirect:/";
		} else {
			model.addAttribute("user", userService.findUserById(id));
			model.addAttribute("idea", ideaService.findAll());
			return "dashboard.jsp";		
		}
    }
    
    // show create page
    @GetMapping("/ideas/new")
    public String createIdea(@ModelAttribute("idea") Idea idea) {
    	return "addIdea.jsp";
    }

    // create process
    @PostMapping("/ideas/new")
    public String createProcess(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session){
    	if(session.getAttribute("id") == null) {
			return "redirect:/";
		}   	
		if(result.hasErrors()){
			return "addIdea.jsp";
    	} else {
			ideaService.createIdea(idea);
			return "redirect:/ideas/new";
		}
	}
    
    // show idea by ID
    @GetMapping("/ideas/{ideaId}")
	public String showIdea(@PathVariable("ideaId") Long ideaId, Model model, HttpSession session) {
    	if(session.getAttribute("id") == null) {
			return "redirect:/";
		}
    	Idea idea = ideaService.findIdeaById(ideaId);
    	if(idea == null) {
    		return "redirect:/ideas";
    	} else {
    		User user = userService.findUserById((Long) session.getAttribute("id"));
			idea.setUsers(idea.getUsers());
    		model.addAttribute("idea", idea);
    		model.addAttribute("user", user);
    		return "showIdea.jsp";
    	}
	}
        
    
    // show edit page
    @RequestMapping("/ideas/{id}/edit")
    public String editIdea(@PathVariable("id") Long ideaId, @Valid @ModelAttribute("editIdea") Idea idea, BindingResult result, Model model, HttpSession session) {
    	if(session.getAttribute("id") == null) {
			return "redirect:/";
		}
    	model.addAttribute("editIdea", ideaService.findIdeaById(ideaId));
		return "editIdea.jsp";
	}
    
    // edit idea by ID process
    @PutMapping("/ideas/{id}/edit")
    public String editProcess(@PathVariable("id") Long ideaId, @RequestParam("name") String name, @Valid @ModelAttribute("editIdea") Idea idea, BindingResult result, Model model, HttpSession session)	{
    	if(session.getAttribute("id") == null) {
			return "redirect:/";
    	}
		if(result.hasErrors()) {
			return "editIdea.jsp";
		} else {
	    	ideaService.updateIdea(idea);
			return "redirect:/ideas";
		}
    }
    
    // delete idea by ID process
    @RequestMapping("/delete/{id}")
	public String deleteIdea(@PathVariable("id") Long ideaId, HttpSession session) {
    	if(session.getAttribute("id") == null) {
			return "redirect:/";
		} else {
			ideaService.deleteIdeaById(ideaId);
			return "redirect:/ideas";
		}
	}
    
    
}

