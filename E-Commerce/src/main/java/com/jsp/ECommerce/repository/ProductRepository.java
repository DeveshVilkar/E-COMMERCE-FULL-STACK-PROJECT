package com.jsp.ECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
