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
import com.online.store.dto.CategoryDTO;
import com.online.store.service.CategoryService;

@RequestMapping("/category")
@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody CategoryDTO category){
		ResponseEntity response = null;
		try {
			response = categoryService.saveCategory(category);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCategories(){
		ResponseEntity response = null;
		try {
			response = categoryService.getAllCategories();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping("activeClass/{categoryId}")
	public ResponseEntity<?> getAllCategoriesWithActiveClass(@PathVariable("categoryId")Long categoryId){
		ResponseEntity response = null;
		try {
			response = categoryService.getAllCategoriesWithIdModification(categoryId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
