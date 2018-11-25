package com.codingdojo.firstproject;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/coding")
public class CodingController {
    @RequestMapping("")
    public String index(){
      return "Hello Coding Dojo!";
    }
    @RequestMapping("/python")
    public String hello(){
      return "Python/Django was awesome!";
    }
    @RequestMapping("/java")
    public String world(){
      return "Java/Spring is better!";
    
}
}
