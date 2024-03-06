package com.jsp.ECommerce.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.model.Category;
import com.jsp.ECommerce.repository.CategoryRepository;

@Repository
public class CategoryDao {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category> listCategories(){
		return categoryRepository.findAll();
	}
	
	public Category getCategoryById(int id) {
		Optional<Category> optional=categoryRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public boolean deleteCategory(int id) {
		Optional<Category> optional=categoryRepository.findById(id);
		if (optional.isEmpty()) {
			return false;
			
		}else {
			categoryRepository.deleteById(id);
			return true;
		}
	}
	
	public Category updateCategory(int id,Category category) {
		Optional<Category> optional=categoryRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}else {
			return categoryRepository.save(category);
		}
	}
	

}
