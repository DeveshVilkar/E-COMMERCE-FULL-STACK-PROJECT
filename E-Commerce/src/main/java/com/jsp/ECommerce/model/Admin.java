package com.jsp.ECommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String admin_firstname;
	private String admin_lastname;
	private String email;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmin_firstname() {
		return admin_firstname;
	}
	public void setAdmin_firstname(String admin_firstname) {
		this.admin_firstname = admin_firstname;
	}
	public String getAdmin_lastname() {
		return admin_lastname;
	}
	public void setAdmin_lastname(String admin_lastname) {
		this.admin_lastname = admin_lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
