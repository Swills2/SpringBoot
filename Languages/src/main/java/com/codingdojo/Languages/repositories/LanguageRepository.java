package com.codingdojo.Languages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	
}
