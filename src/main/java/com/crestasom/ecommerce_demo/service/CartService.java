package com.crestasom.ecommerce_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crestasom.ecommerce_demo.entity.Cart;
import com.crestasom.ecommerce_demo.entity.CartDTO;
import com.crestasom.ecommerce_demo.entity.Product;
import com.crestasom.ecommerce_demo.entity.User;
import com.crestasom.ecommerce_demo.repository.CartRepository;

@Service
public class CartService {


	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;


	public Cart getCartByUserId(Long userId) {
		User u = userService.getUserById(userId);
		if (u == null) {
			throw new RuntimeException("User not found");
		}
		Cart c = cartRepository.findByUserId(userId);

		if (c == null) {
			c = new Cart(null, u);
			cartRepository.save(c);
		}
		return c;
	}

	public Cart addProductToCart(CartDTO cartDto) {
		Cart cart = getCartByUserId(cartDto.getUserId());
		Product product = productService.getProductById(cartDto.getProductId());
		if (product == null) {
			throw new RuntimeException("Product not found");
		}
		cart.getProducts().add(product);
		return cartRepository.save(cart);
	}

	public Cart removeProductFromCart(Long userId, Long productId) {
		Cart cart = getCartByUserId(userId);
		cart.getProducts().removeIf(p -> p.getId().equals(productId));
		return cartRepository.save(cart);
	}
}
