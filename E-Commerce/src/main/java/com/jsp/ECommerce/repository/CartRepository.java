package com.jsp.ECommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.model.Cart;
import com.jsp.ECommerce.model.User;
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

}

