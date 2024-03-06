package com.jsp.ECommerce.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tokens")
public class AuthenticationToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String token;
	
	@Column(name = "created_date")
	private Date createDate;
	
	@OneToOne(targetEntity =User.class, fetch = FetchType.EAGER )
	@JoinColumn(nullable = false,name="user_id")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public AuthenticationToken(User user) {
		this.createDate=new Date();
		this.user=user;
		this.token=UUID.randomUUID().toString();
	}
	
	public AuthenticationToken() {
		
	}

	
	

}
