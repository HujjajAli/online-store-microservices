package com.online.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.dto.ProductDTO;
import com.online.store.service.ProductService;

@RequestMapping("/product")
@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<?> getAllProducts(){
		ResponseEntity<?> response = null;
		try {
			System.out.println("Getting All Products");
			response = productService.getAllProducts();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping("categoryId/{categoryId}")
	public ResponseEntity<?> getAllProductsByCategoryId(@PathVariable("categoryId")Long categoryId){
		ResponseEntity<?> response = null;
		try {
			System.out.println("Getting All Products By Category");
			response = productService.getAllProductsByCategoryId(categoryId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping("productId/{productId}")
	public ResponseEntity<?> getProductsByProductId(@PathVariable("productId")Long productId){
		ResponseEntity<?> response = null;
		try {
			System.out.println("Getting Product By Product ID: "+productId);
			response = productService.getAllProductByProductId(productId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@PostMapping
	public ResponseEntity<?> createProducts(@RequestBody ProductDTO productDTO){
		ResponseEntity<?> response = null;
		try {
			response = productService.saveProducts(productDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
