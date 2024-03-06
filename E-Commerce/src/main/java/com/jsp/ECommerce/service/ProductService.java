package com.jsp.ECommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ECommerce.dao.ProductDao;
import com.jsp.ECommerce.dto.cart.ProductDto;
import com.jsp.ECommerce.exception.ProductNotFoundException;
import com.jsp.ECommerce.model.Category;
import com.jsp.ECommerce.model.Product;


@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	
	public void saveProduct(ProductDto productdto,Category category) {
		Product product=new Product();
		product.setName(productdto.getName());
		product.setImageurl(productdto.getImageurl());
		product.setDescription(productdto.getDescription());
		product.setPrice(productdto.getPrice());
		product.setCategory(category);
		productDao.saveProduct(product);
	}
	
	public List<Product> getAllProducts(){
		return productDao.getAllProducts();
	}
	
	public Product getProductById(int id) throws ProductNotFoundException {
		return productDao.getProductById(id);
	}
	
	public boolean deleteProduct(int id) {
		return productDao.deleteProduct(id);
	}
	
	public Product updateCategory(int id,Product product) throws ProductNotFoundException {
		Product p=productDao.getProductById(id);
		if (p!=null) {
			p.setName(product.getName());
			p.setImageurl(product.getImageurl());
			p.setCategory(product.getCategory());
			p.setDescription(product.getDescription());
			p.setPrice(product.getPrice());
			return productDao.updateProduct(id,p);
		}else {
			return null;
		}
	}

}
