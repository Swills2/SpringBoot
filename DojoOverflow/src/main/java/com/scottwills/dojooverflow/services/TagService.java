package com.scottwills.dojooverflow.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scottwills.dojooverflow.models.Tag;
import com.scottwills.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
    TagRepository tagRepo;
    public TagService(TagRepository tagRepo){
        this.tagRepo = tagRepo;
    }
    public Iterable<Tag> getAll(){
        return tagRepo.findAll();
    }
    public Tag findTag(Long id) {
        Optional<Tag> optionalTag = tagRepo.findById(id);
        if(optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }
    public void saveTag(Tag tag){
        tagRepo.save(tag);
    }
    public Tag findBySubject(String subject){
        return tagRepo.findBySubjectEquals(subject);
    }
}
