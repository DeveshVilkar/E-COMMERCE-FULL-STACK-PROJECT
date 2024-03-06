package com.jsp.ECommerce.model;

public class ResponseStructure<T> {
	private T data;
	private String message;
	private int status_code;
	private AuthenticationToken token;
	private AdminToken adminToken;
	
	
	public AdminToken getAdminToken() {
		return adminToken;
	}
	public void setAdminToken(AdminToken adminToken) {
		this.adminToken = adminToken;
	}
	public AuthenticationToken getToken() {
		return token;
	}
	public void setToken(AuthenticationToken token) {
		this.token = token;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus_code() {
		return status_code;
	}
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	
	

}
