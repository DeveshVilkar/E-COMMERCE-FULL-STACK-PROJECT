package com.jsp.ECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ECommerce.model.Admin;
import com.jsp.ECommerce.model.LogIn;
import com.jsp.ECommerce.model.ResponseStructure;
import com.jsp.ECommerce.service.AdminService;

@CrossOrigin("*")
@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("/admin")
	public ResponseStructure<Admin> SaveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@PostMapping("/admin/login")
	public ResponseStructure<Admin> loginAdmin(@RequestBody LogIn login){
		return adminService.validateAdmin(login.getEmail(),login.getPassword());
	}
	
	

}
