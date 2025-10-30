package com.crestasom.ecommerce_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crestasom.ecommerce_demo.entity.Cart;
import com.crestasom.ecommerce_demo.entity.Product;
import com.crestasom.ecommerce_demo.repository.CartRepository;
import com.crestasom.ecommerce_demo.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId).orElseGet(() -> {
            Cart cart = new Cart(null, userId);
            return cartRepository.save(cart);
        });
    }

    public Cart addProductToCart(Long userId, Long productId) {
        Cart cart = getCartByUserId(userId);
		Product product = productRepository.findById(productId);
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
