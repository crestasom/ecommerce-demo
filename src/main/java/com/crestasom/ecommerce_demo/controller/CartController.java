package com.crestasom.ecommerce_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crestasom.ecommerce_demo.entity.Cart;
import com.crestasom.ecommerce_demo.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/{userId}")
	public Cart getCartByUserId(@PathVariable Long userId) {
		return cartService.getCartByUserId(userId);
	}

	@PostMapping("/{userId}/products/{productId}")
	public Cart addProductToCart(@PathVariable Long userId, @PathVariable Long productId) {
		return cartService.addProductToCart(userId, productId);
	}

	@DeleteMapping("/{userId}/products/{productId}")
	public Cart removeProductFromCart(@PathVariable Long userId, @PathVariable Long productId) {
		return cartService.removeProductFromCart(userId, productId);
	}
}
