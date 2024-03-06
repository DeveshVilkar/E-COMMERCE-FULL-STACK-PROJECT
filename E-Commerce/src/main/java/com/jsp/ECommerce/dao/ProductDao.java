package com.jsp.ECommerce.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.exception.ProductNotFoundException;
import com.jsp.ECommerce.model.Category;
import com.jsp.ECommerce.model.Product;
import com.jsp.ECommerce.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	ProductRepository productRepository;
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public boolean deleteProduct(int id) {
		Optional<Product> optional=productRepository.findById(id);
		if (optional.isPresent()) {
			productRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(int id) throws ProductNotFoundException{
		Optional<Product> optional=productRepository.findById(id);
		if (optional.isEmpty()) {
			throw new ProductNotFoundException("product id invalid");
			
		}else {
			return optional.get();
		}
	}
	
	public Product updateProduct(int id,Product product) {
		Optional<Product> optional=productRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}else {
			return productRepository.save(product);
		}
	}

}
