package com.online.store.service;

import org.springframework.http.ResponseEntity;

import com.online.store.dto.ProductDTO;

public interface ProductService {
	
	ResponseEntity<?> getAllProducts();
	ResponseEntity<?> saveProducts(ProductDTO productDTO);
}
