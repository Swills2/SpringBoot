package com.scottwills.license.repositories;

import org.springframework.data.repository.CrudRepository;

import com.scottwills.license.models.User;

public interface UserRepository extends CrudRepository <User, Long> {

	User findOne(Long id);

}
