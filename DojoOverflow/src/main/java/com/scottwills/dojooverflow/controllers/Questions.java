package com.scottwills.dojooverflow.controllers;

import com.scottwills.dojooverflow.models.Answer;
import com.scottwills.dojooverflow.models.Question;
import com.scottwills.dojooverflow.models.Tag;
import com.scottwills.dojooverflow.services.AnswerService;
import com.scottwills.dojooverflow.services.QuestionService;
import com.scottwills.dojooverflow.services.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Questions {
    QuestionService questionService;
    TagService tagService;
    AnswerService answerService;
    public Questions(QuestionService questionService, TagService tagService, AnswerService answerService){
        this.questionService = questionService;
        this.tagService = tagService;
        this.answerService = answerService;
    }
    @RequestMapping("")
    public String dashboard(Model model){
        List<Question> questions = questionService.getAll();
        model.addAttribute("questions", questions);
        return "dashboard.jsp";
    }
    @RequestMapping("/questions/new")
    public String newQuestionPage(@ModelAttribute("question") Question question, Model model){
        Boolean test = false;
        model.addAttribute("test", test);
        return "newQuestion.jsp";
    }
    @PostMapping("/questions/new")
    public String createQuestion(@RequestParam("question") String question, @RequestParam("tags") String tagsString){
        if(question.equals("")){
            return "redirect:/new";
        }
        Question newQuestion = new Question(question);
        if(tagsString.length() > 0){

            String[] tagList = tagsString.split(",");
            if(tagList.length > 3){
                return "redirect:/new";
            }
            List<Tag> tags = new ArrayList<>();
            for (String tag : tagList){
                Tag tag1;
                if(tagService.findBySubject(tag) == null){
                    tag1 = new Tag(tag);
                    tagService.saveTag(tag1);
                    tag1 = tagService.findTag(tag1.getId());
                }else{
                    tag1 = tagService.findBySubject(tag);
                }
                tags.add(tag1);
            }
            newQuestion.setTags(tags);
        }
        questionService.saveQuestion(newQuestion);
        return "redirect:/";

    }
    @RequestMapping("/questions/{id}")
    public String getOneQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answerModel") Answer answerModel){
        Question question = questionService.findQuestion(id);
        model.addAttribute("question", question);
        return "question.jsp";
    }
    @PostMapping("/questions/{id}")
    public String newAnswer(@Valid @ModelAttribute("answerModel") Answer answerModel, BindingResult result, @PathVariable("id") Long id, Model model){
        Question question = questionService.findQuestion(id);
        if(result.hasErrors()){
            System.out.println(answerModel);
            model.addAttribute("question", question);
            return "question.jsp";
        }else{

            answerModel.setQuestion(question);
            answerService.saveAnswer(answerModel);
            return "redirect:/"+id;
        }
    }
}
