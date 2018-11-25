package com.scottwills.productscategories.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scottwills.productscategories.models.Product;
import com.scottwills.productscategories.repositories.CategoryRepo;
import com.scottwills.productscategories.repositories.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
		this.productRepo = productRepo;
	}
	public void addProduct(Product product) {
		productRepo.save(product);
	}
	public List<Product> getAll(){
		return (List<Product>) productRepo.findAll();
	}
	public Product getOne(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	}
	public void update(Product product) {
		productRepo.save(product);
	}
}
