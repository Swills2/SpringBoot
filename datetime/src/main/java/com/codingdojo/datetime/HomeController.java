package com.codingdojo.datetime;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	Date datetime = new java.util.Date();
	
	@RequestMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		String date = String.format("%s %tA, the %<te of %<tB, %<tY", "Date:", datetime);
		model.addAttribute("date", date);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		String time = String.format("%s %tI:%<tM %<tp", "Time:", datetime);
		model.addAttribute("time", time);
		return "time.jsp";
	}
}
