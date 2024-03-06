package com.jsp.ECommerce.dto.cart;

public class StripeResponse {
	private String sessionid;

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	
	public StripeResponse(String sessionid) {
		this.sessionid=sessionid;
	}

}
