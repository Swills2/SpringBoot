package com.scottwills.productscategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.scottwills.productscategories.models.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {

}
