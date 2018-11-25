package com.scottwills.dojooverflow.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scottwills.dojooverflow.models.Answer;
import com.scottwills.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
    AnswerRepository ansRepo;
    public AnswerService(AnswerRepository ansRepo){
        this.ansRepo = ansRepo;
    }
    public Iterable<Answer> getAll(){
        return ansRepo.findAll();
    }
    public Answer findAnswer(Long id) {
        Optional<Answer> optionalAnswer = ansRepo.findById(id);
        if(optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        } else {
            return null;
        }
    }
    public void saveAnswer(Answer answer){
        ansRepo.save(answer);
    }
}
