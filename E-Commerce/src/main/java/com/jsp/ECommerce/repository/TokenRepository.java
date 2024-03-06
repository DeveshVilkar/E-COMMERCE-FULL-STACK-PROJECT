package com.jsp.ECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.model.AuthenticationToken;
import com.jsp.ECommerce.model.User;
@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken,Integer>{
	AuthenticationToken findByUser(User user);
	AuthenticationToken findByToken(String token);

}
