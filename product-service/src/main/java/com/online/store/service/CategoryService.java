package com.online.store.service;

import org.springframework.http.ResponseEntity;

import com.online.store.dto.CategoryDTO;

public interface CategoryService {
	
	
	ResponseEntity<?> getAllCategories();
	ResponseEntity<?> getAllCategoriesWithIdModification(Long categoryid);
	ResponseEntity<?> saveCategory(CategoryDTO categoryDTO);

}
