package com.jsp.ECommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.model.Admin;
import com.jsp.ECommerce.model.AdminToken;
import com.jsp.ECommerce.repository.AdminTokenRepository;

@Repository
public class AdminTokenDao {
	@Autowired
	AdminTokenRepository adminTokenRepository;
	
	public void saveAdminToken(AdminToken adminToken) {
		adminTokenRepository.save(adminToken);
	}
	
	public AdminToken getToken(Admin admin) {
		return adminTokenRepository.findByAdmin(admin);
	}

}
