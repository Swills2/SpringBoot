package com.scottwills.greatIdeas.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.scottwills.greatIdeas.models.Idea;
import com.scottwills.greatIdeas.models.UserIdea;
import com.scottwills.greatIdeas.repositories.IdeaRepository;
import com.scottwills.greatIdeas.repositories.UserIdeaRepo;

@Service
public class IdeaService {
	
	private IdeaRepository ideaRepo;
	private UserIdeaRepo uiRepo; 
	
	public IdeaService(IdeaRepository ideaRepo, UserIdeaRepo uiRepo) {
		this.ideaRepo = ideaRepo;
		this.uiRepo = uiRepo;
	}
	
	// Find all
    public List<Idea> findAll(){
		return (List<Idea>) ideaRepo.findAll();
    }
    
    // Create idea
	public Idea createIdea (Idea idea) {
		return ideaRepo.save(idea);		
	}
	//Add User to Idea
	public void addUserToIdea(UserIdea ui) {
		uiRepo.save(ui);
	}
	//Find idea by ID
	public Idea findIdeaById(Long id) {
		Optional<Idea> optionalIdea = ideaRepo.findById(id);
		if(optionalIdea.isPresent()) {
			return optionalIdea.get();
		} else {
			return null;
		}
	}
	// Update idea
	public void updateIdea(@Valid Idea idea) {
	    ideaRepo.save(idea);		
	}
	    
	// Delete course by ID
	public void deleteIdeaById(Long id) {
	    ideaRepo.deleteById(id);
	   }
}
