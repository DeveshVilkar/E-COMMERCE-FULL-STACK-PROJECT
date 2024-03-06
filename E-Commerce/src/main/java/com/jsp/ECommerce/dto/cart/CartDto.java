package com.jsp.ECommerce.dto.cart;

import java.util.List;

public class CartDto {
	private List<CartItemDto> cartItemDtos;
	private double totalcost;
	
	public CartDto() {
		
	}

	public List<CartItemDto> getCartItemDtos() {
		return cartItemDtos;
	}

	public void setCartItemDtos(List<CartItemDto> cartItemDtos) {
		this.cartItemDtos = cartItemDtos;
	}

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	
	

}
