package com.jsp.ECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
	Admin findByEmailAndPassword(String email,String password);

}
