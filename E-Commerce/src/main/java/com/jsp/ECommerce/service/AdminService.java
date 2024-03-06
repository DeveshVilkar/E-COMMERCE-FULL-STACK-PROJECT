package com.jsp.ECommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.ECommerce.dao.AdminDao;
import com.jsp.ECommerce.dao.AdminTokenDao;
import com.jsp.ECommerce.model.Admin;
import com.jsp.ECommerce.model.AdminToken;
import com.jsp.ECommerce.model.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;
	@Autowired
	AdminTokenDao adminTokenDao;
	
	public ResponseStructure<Admin> saveAdmin(Admin admin) {
		if(admin!=null) {
			ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
			responseStructure.setData(adminDao.saveAdmin(admin));
			responseStructure.setMessage("admin created");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			AdminToken adminToken=new AdminToken(admin);
			adminTokenDao.saveAdminToken(adminToken);
			return responseStructure;
		}else {
			ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
			responseStructure.setData(null);
			responseStructure.setMessage("admin creation failed");
			responseStructure.setStatus_code(404);
			return responseStructure;
		}
	}
	
	public ResponseStructure<Admin> validateAdmin(String email,String password){
		Admin admin=adminDao.validateAdmin(email, password);
		if(admin!=null) {
			AdminToken token=adminTokenDao.getToken(admin);
			ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
			responseStructure.setAdminToken(token);
			responseStructure.setMessage("login successfull");
			responseStructure.setStatus_code(HttpStatus.ACCEPTED.value());
			return responseStructure;
		}else {
			ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
			responseStructure.setAdminToken(null);
			responseStructure.setMessage("login failed");
			responseStructure.setStatus_code(404);
			return responseStructure;
		}
	}

}
