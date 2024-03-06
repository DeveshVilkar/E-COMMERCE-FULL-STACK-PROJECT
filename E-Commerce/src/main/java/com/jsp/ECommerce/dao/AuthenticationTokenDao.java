package com.jsp.ECommerce.dao;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.exception.AuthenticationFailedException;
import com.jsp.ECommerce.model.AuthenticationToken;
import com.jsp.ECommerce.model.User;
import com.jsp.ECommerce.repository.TokenRepository;

@Repository
public class AuthenticationTokenDao {
	@Autowired
	TokenRepository tokenRepository;
	
	public void saveConfirmationToken(AuthenticationToken authenticationToken) {
		tokenRepository.save(authenticationToken);
	}
	
	public AuthenticationToken getToken(User user) {
		return tokenRepository.findByUser(user);
	}
	
	public User getUser(String token){
		AuthenticationToken authenticationToken=tokenRepository.findByToken(token);
		if(Objects.isNull(authenticationToken)) {
			return null;
		}
		return authenticationToken.getUser();
	}
	
	public void authenticate(String token) throws AuthenticationFailedException{
		if(Objects.isNull(token)) {
			throw new AuthenticationFailedException("token not present");
		}
		if (Objects.isNull(getUser(token))) {
			throw new AuthenticationFailedException("token not valid");
			
		}
	}

}
