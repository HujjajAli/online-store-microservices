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

import static com.online.store.util.Util.getResponseFormat;

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
			
			response = getResponseFormat(HttpStatus.OK, "Record Found", data);
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
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
			response = getResponseFormat(HttpStatus.OK, "Record Found", data);
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
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
			categoryDTO.setCategoryId(category.getCategoryId());
			response = getResponseFormat(HttpStatus.OK, "Record Found", categoryDTO);
			
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		return response;
	}

}
