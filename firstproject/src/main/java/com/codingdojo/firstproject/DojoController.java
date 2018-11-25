package com.codingdojo.firstproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DojoController {
    @RequestMapping("/dojo")
    public String dojo(@PathVariable("dojo") String dojo){
    	return "The" + dojo + "is awesome!";
    }
    @RequestMapping("/burbank-dojo")
    public String burbankDojo(@PathVariable("bubank-dojo") String dojo){
    	return "The" + dojo + "is awesome!";
    }
    @RequestMapping("/san-jose")
    public String sanJose(@PathVariable("san-jose") String dojo){
    	return "The" + dojo + "is awesome!";
    }
    
}
