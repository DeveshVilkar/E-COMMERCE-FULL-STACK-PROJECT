package com.jsp.ECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.ECommerce.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
//	@Query("SELECT u FROM User u WHERE u.email=:myemail AND u.password=:mypassword")
//	User validateUser(@Param("myemail")String email,@Param("mypassword")String password);

	User findByEmailAndPassword(String email,String password);

}
	
	
	
