package com.scottwills.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scottwills.license.models.License;
import com.scottwills.license.models.User;
import com.scottwills.license.services.LicenseService;
import com.scottwills.license.services.UserService;

@Controller
@RequestMapping("/")
public class MainController {
	private final UserService userService;
	private final LicenseService licenseService;
	
	public MainController(UserService userService, LicenseService licenseService) {
		this.userService = userService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("")
	public String index(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "index.jsp";
	}
	@RequestMapping("/persons/new")
	public String showAddUser(@ModelAttribute("user") User user) {
		return "add.jsp";
	}
	@PostMapping("/persons/new")
	public String AddUser(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/persons/new";
		} else {
			userService.addUser(user);
			return "redirect:/";
		}
	}
	@RequestMapping("/licenses/new")
	public String showAddLicense(Model model, @ModelAttribute("license") License license) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "addlicense.jsp";
	}
	@PostMapping("/licenses/new")
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result, RedirectAttributes errors) {
		System.out.println(license.getExpiration_date());
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/licenses/new";
		} else {
			licenseService.addLicense(license);
			return "redirect:/";
		}
	}
	@RequestMapping("/persons/{id}")
	public String showOneUserLicense(Model model, @PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		if(user == null) {
			return "redirect:/";
		}
		model.addAttribute("user", user);
		return "showlicense.jsp";
	}
	@RequestMapping("persons/{userId}/delete")
	public String deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
		return "redirect:/";
	}
}
