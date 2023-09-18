package com.online.store.service;

import org.springframework.http.ResponseEntity;

import com.online.store.dto.ProductDTO;

public interface ProductService {
	
	ResponseEntity<?> getAllProductByProductId(Long productId);
	ResponseEntity<?> getAllProducts();
	ResponseEntity<?> getAllProductsByCategoryId(Long categoryId);
	ResponseEntity<?> saveProducts(ProductDTO productDTO);
}
