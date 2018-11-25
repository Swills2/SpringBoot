package com.scottwills.productscategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.scottwills.productscategories.models.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {

}
