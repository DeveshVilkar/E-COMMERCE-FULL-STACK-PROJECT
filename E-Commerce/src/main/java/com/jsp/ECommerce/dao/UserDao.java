package com.jsp.ECommerce.dao;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.model.User;
import com.jsp.ECommerce.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository userRepository;
		
	public User validateUser(String email,String password){
		return userRepository.findByEmailAndPassword(email,password);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);	
		
	}
	
	public boolean deleteUser(int id) {
		Optional<User> optional=userRepository.findById(id);
		if (optional.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		Optional<User> optional=userRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public User updateUser(int id,User user) {
		Optional<User> optional=userRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}else {
			return userRepository.save(user);
		}
	}

}
