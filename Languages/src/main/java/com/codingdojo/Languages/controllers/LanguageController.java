package com.codingdojo.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.Languages.models.Language;
import com.codingdojo.Languages.services.LanguageService;

@Controller
public class LanguageController {
	
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	
	@RequestMapping("/")
	public String root(Model model) {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String home(Model model) {
		List<Language> languages = languageService.all();
		model.addAttribute("languages", languages);
		model.addAttribute("language", new Language());
		return "index.jsp";
	}
	
	@PostMapping("/languages/add")
	public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/languages";
		}
		else {
			languageService.addLanguage(language);
			return "redirect:/languages";
		}
	}
		
	@RequestMapping("/languages/delete/{id}")
	public String removeLanguage(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
		}
	
	@RequestMapping("/languages/{id}")
	public String displayLanguage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", languageService.getLanguage(id));
		return "display.jsp";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, Model model) {
		System.out.println("Are we getting in here?");
		Language language = languageService.getLanguage(id);
		if (language != null) {
			model.addAttribute("language", language);
			return "edit.jsp";
		}
		else {
			System.out.println(id);
			return "redirect:/languages";
		}
	}
	
	@PostMapping("languages/edit/{id}")
	public String updateLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/languages";
		}
		else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
}
