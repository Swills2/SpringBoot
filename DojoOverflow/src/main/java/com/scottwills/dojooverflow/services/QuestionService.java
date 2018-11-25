package com.scottwills.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scottwills.dojooverflow.models.Question;
import com.scottwills.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
    QuestionRepository questionRepository;
    QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    public List<Question> getAll(){
        return questionRepository.findAll();
    }
    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }
    public void saveQuestion(Question question){
        questionRepository.save(question);
    }

}
