package com.online.store.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.model.Category;
import com.online.store.repository.CategoryRepository;

@RequestMapping("/category")
@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody Category category){
		ResponseEntity response = null;
		try {
			
			categoryRepository.save(category);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("responcode", 0);
			map.put("message", "Category Saved Successfully");
			map.put("data", null);
			response = ResponseEntity.ok(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCategories(){
		ResponseEntity response = null;
		try {
			
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("responcode", 0);
			map.put("message", "Found");
			map.put("data", categoryRepository.findAll());
			response = ResponseEntity.status(HttpStatus.OK).body(map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
