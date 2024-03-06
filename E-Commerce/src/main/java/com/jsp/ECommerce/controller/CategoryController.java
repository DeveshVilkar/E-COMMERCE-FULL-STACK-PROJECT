package com.jsp.ECommerce.controller;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ECommerce.common.ApiResponse;
import com.jsp.ECommerce.model.Category;
import com.jsp.ECommerce.service.CategoryService;
@CrossOrigin("*")
@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/category")
	public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true,"created new category"),HttpStatus.CREATED);
	}
	
	@GetMapping("/category")
	public ResponseEntity<List<Category>> listCategory() {
		List<Category> body=categoryService.listCategories();
		return new ResponseEntity<List<Category>>(body,HttpStatus.OK);
	}
	
	@DeleteMapping("/category/{id}")
	public boolean deleteCategory(@PathVariable int id) {
		return categoryService.deleteCategory(id);
	}
	
	@PutMapping("/category/{id}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable int id,@RequestBody Category category) {
		if (categoryService.getCategoryById(id)!=null) {
			categoryService.updateCategory(id, category);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true,"updated successfully"),HttpStatus.OK);
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse(false,"category not found"),HttpStatus.NOT_FOUND);
	}

}
