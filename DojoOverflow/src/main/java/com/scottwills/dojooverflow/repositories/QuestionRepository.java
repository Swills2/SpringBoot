package com.scottwills.dojooverflow.repositories;

import com.scottwills.dojooverflow.models.Question;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findAll();
}
