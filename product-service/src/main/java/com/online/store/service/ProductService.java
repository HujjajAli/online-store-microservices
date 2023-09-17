package com.online.store.service;

import org.springframework.http.ResponseEntity;

import com.online.store.dto.ProductDTO;

public interface ProductService {
	
	ResponseEntity<?> getAllProducts();
	ResponseEntity<?> getAllProductsByCategoryId(Long categoryId);
	ResponseEntity<?> saveProducts(ProductDTO productDTO);
}
