package com.online.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.service.ProductService;

@RequestMapping("/category")
@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;

}
