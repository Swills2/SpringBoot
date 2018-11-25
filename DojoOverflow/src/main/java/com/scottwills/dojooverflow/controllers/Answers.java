package com.scottwills.dojooverflow.controllers;

import com.scottwills.dojooverflow.services.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/answers")
public class Answers {
    AnswerService ansService;
    public Answers(AnswerService ansService){
        this.ansService = ansService;
    }

}
