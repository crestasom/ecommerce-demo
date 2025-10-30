package com.crestasom.ecommerce_demo.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Long id;
//    private Long userId;
	private User user;
    private List<Product> products = new ArrayList<>();

	public Cart(Long id, User user) {
		super();
		this.id = id;
		this.user = user;
	}


}
