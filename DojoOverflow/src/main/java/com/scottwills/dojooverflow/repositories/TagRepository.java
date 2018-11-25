package com.scottwills.dojooverflow.repositories;

import com.scottwills.dojooverflow.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long>{
    Tag findBySubjectEquals(String subject);
}
