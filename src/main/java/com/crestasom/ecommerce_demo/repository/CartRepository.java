package com.crestasom.ecommerce_demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.crestasom.ecommerce_demo.entity.Cart;

@Repository
public class CartRepository {
    private final List<Cart> carts = new ArrayList<>();
    private long nextId = 1;

    public List<Cart> findAll() {
        return carts;
    }

    public Optional<Cart> findById(Long id) {
        return carts.stream().filter(cart -> cart.getId().equals(id)).findFirst();
    }
    
    public Optional<Cart> findByUserId(Long userId) {
        return carts.stream().filter(cart -> cart.getUserId().equals(userId)).findFirst();
    }

    public Cart save(Cart cart) {
        if (cart.getId() == null) {
            cart.setId(nextId++);
        }
        carts.removeIf(c -> c.getId().equals(cart.getId()));
        carts.add(cart);
        return cart;
    }

    public void deleteById(Long id) {
        carts.removeIf(cart -> cart.getId().equals(id));
    }
}
