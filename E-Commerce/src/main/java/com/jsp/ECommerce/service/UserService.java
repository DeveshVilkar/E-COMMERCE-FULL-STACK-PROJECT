package com.jsp.ECommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.ECommerce.dao.AuthenticationTokenDao;
import com.jsp.ECommerce.dao.UserDao;
import com.jsp.ECommerce.exception.NoSuchUserFoundException;
import com.jsp.ECommerce.model.AuthenticationToken;
import com.jsp.ECommerce.model.ResponseStructure;
import com.jsp.ECommerce.model.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	@Autowired
	AuthenticationTokenDao authenticationTokenDao;
	
	public ResponseStructure<User> validateUser(String email,String password){
		User user=userDao.validateUser(email, password);
		if(user!=null) {
			AuthenticationToken token=authenticationTokenDao.getToken(user);
			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
			responseStructure.setMessage("login successfully");
			responseStructure.setStatus_code(HttpStatus.ACCEPTED.value());	
			responseStructure.setToken(token);
			return responseStructure;
		}else {
			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
			responseStructure.setData(null);
			responseStructure.setMessage("login failed");
			responseStructure.setStatus_code(404);
			responseStructure.setToken(null);
			return responseStructure;
		}
	}
	
	public ResponseStructure<User> createUser(User user) {
		if (user!=null) {
			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
			responseStructure.setData(userDao.saveUser(user));
			responseStructure.setMessage("user registered successfully");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			AuthenticationToken authenticationToken=new AuthenticationToken(user);
			authenticationTokenDao.saveConfirmationToken(authenticationToken);
			return responseStructure;
		}else {
			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
			responseStructure.setData(null);
			responseStructure.setMessage("User Registration failed");
			responseStructure.setStatus_code(404);
			return responseStructure;
		}
	}
	
	public List<User> listUser(){
		return userDao.getAllUsers();
	}
	
	public ResponseStructure<User> getUserById(int id) throws NoSuchUserFoundException{
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		User user=userDao.getUserById(id);
		if (user!=null) {
			responseStructure.setData(user);
			responseStructure.setMessage("success");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());			
		}else {
			throw new NoSuchUserFoundException();
		}
		return responseStructure;
	}
	
	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}
	
	public User updateUser(int id,User user) {
		User u=userDao.getUserById(id);
		if (u!=null) {
		   u.setPassword(user.getPassword());
		   return userDao.updateUser(id,u);
		}else {
			return null;
		}
	}

}
