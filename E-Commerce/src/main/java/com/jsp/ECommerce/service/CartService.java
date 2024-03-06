package com.jsp.ECommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ECommerce.dto.cart.CartDto;
import com.jsp.ECommerce.dto.cart.CartItemDto;
import com.jsp.ECommerce.exception.CustomException;
import com.jsp.ECommerce.exception.ProductNotFoundException;
import com.jsp.ECommerce.model.AddToCart;
import com.jsp.ECommerce.model.Cart;
import com.jsp.ECommerce.model.Product;
import com.jsp.ECommerce.model.User;
import com.jsp.ECommerce.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	ProductService productService;
	@Autowired
	CartRepository cartRepository;
	
	public void addToCart(AddToCart addToCart,User user) throws ProductNotFoundException {
//		validate if product id is valid or not
		Product product=productService.getProductById(addToCart.getProduct_id());
//		save the product in cart
		Cart cart=new Cart();
		cart.setProduct(product);
		cart.setQuantity(addToCart.getQuantity());
		cart.setCreatedDate(new Date());
		cart.setUser(user);		
		cartRepository.save(cart);		
	}

	public CartDto listCartItems(User user) {
		List<Cart> cartList=cartRepository.findAllByUserOrderByCreatedDateDesc(user);
		List<CartItemDto> cartItems=new ArrayList<CartItemDto>();
		double totalcost=0;
		for(Cart cart:cartList) {
			CartItemDto	cartItemDto=new CartItemDto(cart);
			totalcost+=cartItemDto.getQuantity()*cartItemDto.getProduct().getPrice();
			cartItems.add(cartItemDto);
		}
		CartDto cartDto=new CartDto();
		cartDto.setTotalcost(totalcost);
		cartDto.setCartItemDtos(cartItems);
		
		return cartDto;
	}
	
	public void deleteCartItem(int itemid,User user) throws CustomException {
//		item id belong to user
		Optional<Cart> optional=cartRepository.findById(itemid);
		if(optional.isEmpty()) {
			throw new CustomException("Item id invalid");
		}
		Cart cart=optional.get();
		if(cart.getUser()!=user) {
			throw new CustomException("Cart Item does not belong to user");
		}
		cartRepository.delete(cart);
	}

}
