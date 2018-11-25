package com.codingdojo.Languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.Languages.models.Language;
import com.codingdojo.Languages.repositories.LanguageRepository;
import com.codingdojo.Languages.controllers.LanguageController;

@Service
public class LanguageService {
	
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> all(){
		return (List<Language>) languageRepository.findAll();
	}
	
	public void addLanguage(Language language) {
		languageRepository.save(language);
	}
	
	public Language getLanguage(Long id) {
		return languageRepository.findOne(id);
	}
	
	public void updateLanguage(Language language) {
		languageRepository.save(language);
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.delete(id);
	}
}
