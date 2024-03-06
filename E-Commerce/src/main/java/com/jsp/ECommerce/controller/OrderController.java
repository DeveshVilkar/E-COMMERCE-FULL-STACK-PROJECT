package com.jsp.ECommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ECommerce.dto.cart.CheckoutItemDto;
import com.jsp.ECommerce.dto.cart.StripeResponse;
//import com.jsp.ECommerce.model.AuthenticationToken;
import com.jsp.ECommerce.service.OrderService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

@CrossOrigin("*")
@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	   @PostMapping("/create-checkout-session")
	    public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList) throws StripeException {
	        // create the stripe session
	        Session session = orderService.createSession(checkoutItemDtoList);
	        StripeResponse stripeResponse = new StripeResponse(session.getId());
	        // send the stripe session id in response
	        return new ResponseEntity<StripeResponse>(stripeResponse, HttpStatus.OK);
	    }

}
