package com.online.store.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online.store.dto.CategoryDTO;
import com.online.store.model.Category;
import com.online.store.repository.CategoryRepository;
import com.online.store.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ResponseEntity<?> getAllCategories() {
		ResponseEntity response = null;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			
			List<CategoryDTO> data = new ArrayList<CategoryDTO>();
			List<Category> fetchData = categoryRepository.findAll();
			for(Category category:fetchData) {
				CategoryDTO categoryDTO = new CategoryDTO();
				BeanUtils.copyProperties(category,categoryDTO);
				data.add(categoryDTO);
			}
			
			map.put("responcode", 0);
			map.put("message", "Found");
			map.put("data", data);
			response = ResponseEntity.status(HttpStatus.OK).body(map);
		}catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			map.put("responcode", 1);
			map.put("message", e.getMessage());
			map.put("data", null);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		return response;
	}

	@Override
	public ResponseEntity<?> getAllCategoriesWithIdModification(Long categoryid) {
		ResponseEntity response = null;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			
			List<CategoryDTO> data = new ArrayList<CategoryDTO>();
			List<Category> fetchData = categoryRepository.findAll();
			for(Category category:fetchData) {
				CategoryDTO categoryDTO = new CategoryDTO();
				BeanUtils.copyProperties(category,categoryDTO);
				long providedID = categoryid;
				long dynamicID  = category.getCategoryId(); 
				if(providedID == dynamicID) {
					categoryDTO.setActiveClass("active");
				}
				
				data.add(categoryDTO);
			}
			
			map.put("responcode", 0);
			map.put("message", "Found");
			map.put("data", data);
			response = ResponseEntity.status(HttpStatus.OK).body(map);
		}catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			map.put("responcode", 1);
			map.put("message", e.getMessage());
			map.put("data", null);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		return response;
	}

	@Override
	public ResponseEntity<?> saveCategory(CategoryDTO categoryDTO) {
		ResponseEntity response = null;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			
			Category category = new Category();
			BeanUtils.copyProperties(categoryDTO, category);
			
			categoryRepository.save(category);
			
			map.put("responcode", 0);
			map.put("message", "Category Saved Successfully");
			map.put("data", category);
			response = ResponseEntity.ok(map);
		}catch (Exception e) {
			e.printStackTrace();
			map.put("responcode", 1);
			map.put("message", e.getMessage());
			map.put("data", null);
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
		return response;
	}

}
