package com.crestasom.ecommerce_demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crestasom.ecommerce_demo.entity.Cart;

@Repository
public class CartRepository {
    private final List<Cart> carts = new ArrayList<>();
    private long nextId = 1;

    public List<Cart> findAll() {
        return carts;
    }

	public Cart findById(Long id) {
		for (Cart c : carts) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
//        return carts.stream().filter(cart -> cart.getId().equals(id)).findFirst();
    }
    
	public Cart findByUserId(Long userId) {

		for (Cart c : carts) {
			if (c.getUser().getId() == userId) {
				return c;
			}
		}
		return null;
//        return carts.stream().filter(cart -> cart.getUserId().equals(userId)).findFirst();
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
