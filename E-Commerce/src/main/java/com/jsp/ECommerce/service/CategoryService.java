package com.jsp.ECommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ECommerce.dao.CategoryDao;
import com.jsp.ECommerce.model.Category;

@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	public void createCategory(Category category) {
		categoryDao.createCategory(category);
	}
	
	public List<Category> listCategories(){
		return categoryDao.listCategories();
	}
	
	public Category getCategoryById(int id) {
		return categoryDao.getCategoryById(id);
	}
	
	public boolean deleteCategory(int id) {
		return categoryDao.deleteCategory(id);
	}
	
	public Category updateCategory(int id,Category category) {
		Category c=categoryDao.getCategoryById(id);
		if (c!=null) {
			c.setCategoryname(category.getCategoryname());
			c.setDescription(category.getDescription());
			c.setImageurl(category.getImageurl());
			return categoryDao.updateCategory(id,c);
		}else {
			return null;
		}
	}
	


}
