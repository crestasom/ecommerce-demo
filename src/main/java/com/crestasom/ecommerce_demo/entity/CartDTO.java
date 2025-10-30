package com.crestasom.ecommerce_demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDTO {
	private Long productId;
	private Long userId;
}
