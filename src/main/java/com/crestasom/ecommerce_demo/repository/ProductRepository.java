package com.crestasom.ecommerce_demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crestasom.ecommerce_demo.entity.Product;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private long nextId = 1;

    public List<Product> findAll() {
        return products;
    }

	public Product findById(Long id) {
		for (Product p : products) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
//        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(nextId++);
        }
        products.removeIf(p -> p.getId().equals(product.getId()));
        products.add(product);
        return product;
    }

    public void deleteById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}