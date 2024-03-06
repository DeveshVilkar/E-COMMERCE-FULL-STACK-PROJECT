package com.jsp.ECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.model.Admin;
import com.jsp.ECommerce.model.AdminToken;

@Repository
public interface AdminTokenRepository extends JpaRepository<AdminToken,Integer>{
	AdminToken findByAdmin(Admin admin);

}
