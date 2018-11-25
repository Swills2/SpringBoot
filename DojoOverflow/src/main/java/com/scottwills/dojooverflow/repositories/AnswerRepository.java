package com.scottwills.dojooverflow.repositories;


import com.scottwills.dojooverflow.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{
}
