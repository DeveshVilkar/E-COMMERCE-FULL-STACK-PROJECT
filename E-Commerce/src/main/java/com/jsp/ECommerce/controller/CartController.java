package com.jsp.ECommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ECommerce.common.ApiResponse;
import com.jsp.ECommerce.dao.AuthenticationTokenDao;
import com.jsp.ECommerce.dto.cart.CartDto;
import com.jsp.ECommerce.exception.AuthenticationFailedException;
import com.jsp.ECommerce.exception.CustomException;
import com.jsp.ECommerce.exception.ProductNotFoundException;
import com.jsp.ECommerce.model.AddToCart;
import com.jsp.ECommerce.model.User;
import com.jsp.ECommerce.service.CartService;

import jakarta.websocket.server.PathParam;
@CrossOrigin("*")
@RestController
public class CartController {
	@Autowired
	CartService cartService;
	
	@Autowired
	AuthenticationTokenDao authenticationTokenDao;
	
//	adding product to cart
	
	@PostMapping("/cart/add")
	public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCart addToCart,@RequestParam("token")String token) throws AuthenticationFailedException, ProductNotFoundException{
		authenticationTokenDao.authenticate(token);
		User user=authenticationTokenDao.getUser(token);
		cartService.addToCart(addToCart, user);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Added to Cart"),HttpStatus.CREATED);
		
	}
	
//	get all items in cart
	
	@GetMapping("/cart/")
	public ResponseEntity<CartDto> getCartItems(@RequestParam("token")String token) throws AuthenticationFailedException{
		authenticationTokenDao.authenticate(token);
		User user=authenticationTokenDao.getUser(token);
		CartDto cartDto=cartService.listCartItems(user);
		return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
	}
	
//	delete item from cart
	@DeleteMapping("/cart/{cartItemId}")
	public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId")int itemId,@RequestParam("token")String token ) throws AuthenticationFailedException, CustomException{
		authenticationTokenDao.authenticate(token);
		User user=authenticationTokenDao.getUser(token);
		cartService.deleteCartItem(itemId,user);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true," Successfully Deleted Item"),HttpStatus.OK);
		}


}
