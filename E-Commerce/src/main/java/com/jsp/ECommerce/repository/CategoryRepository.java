package com.jsp.ECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
