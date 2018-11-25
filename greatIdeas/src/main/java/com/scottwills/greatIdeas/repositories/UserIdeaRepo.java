package com.scottwills.greatIdeas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scottwills.greatIdeas.models.UserIdea;

@Repository
public interface UserIdeaRepo extends CrudRepository<UserIdea, Long> {

}
