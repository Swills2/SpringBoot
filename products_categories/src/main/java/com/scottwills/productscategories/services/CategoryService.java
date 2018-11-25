package com.scottwills.productscategories.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottwills.productscategories.models.Category;
import com.scottwills.productscategories.repositories.CategoryRepo;
import com.scottwills.productscategories.repositories.ProductRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	public CategoryService(CategoryRepo categoryRepo, ProductRepo productRepo) {
		this.categoryRepo = categoryRepo;
	}
	public void addCategory(Category category) {
		categoryRepo.save(category);
	}
	public List<Category> getAll() {
		return (List<Category>) categoryRepo.findAll();
	}
	public Category getOne(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		else {
			return null;
		}
	}
	public void update(Category category) {
		categoryRepo.save(category);
	}
}
