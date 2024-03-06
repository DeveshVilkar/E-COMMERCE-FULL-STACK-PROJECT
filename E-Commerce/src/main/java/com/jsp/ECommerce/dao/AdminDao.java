package com.jsp.ECommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.model.Admin;
import com.jsp.ECommerce.repository.AdminRepository;

@Repository
public class AdminDao {
	@Autowired
	AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
    public Admin validateAdmin(String email,String password) {
    	return adminRepository.findByEmailAndPassword(email,password);
    }
}
