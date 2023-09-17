package com.online.store.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.online.store.dto.ProductDTO;
import com.online.store.model.Category;
import com.online.store.model.Product;
import com.online.store.repository.CategoryRepository;
import com.online.store.repository.ProductRepository;
import com.online.store.service.ProductService;

import static com.online.store.util.Util.getResponseFormat;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public ResponseEntity<?> getAllProducts() {
		ResponseEntity response = null;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			
			List<ProductDTO> data = new ArrayList<ProductDTO>();
			List<Product> fetchData = productRepository.findAll();
			for(Product product:fetchData) {
				ProductDTO productDTO = new ProductDTO();
				BeanUtils.copyProperties(product,productDTO);
				String fileData = new String(product.getProductImage());
				productDTO.setProductImage(fileData);
				data.add(productDTO);
			}
			response = getResponseFormat(HttpStatus.OK, "Record Found", data);
			
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		return response;
	}
	
	@Override
	public ResponseEntity<?> getAllProductsByCategoryId(Long categoryId) {
		ResponseEntity response = null;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			
			List<ProductDTO> data = new ArrayList<ProductDTO>();
			
			Optional<Category> category = categoryRepository.findById(categoryId);
			
			List<Product> fetchData = productRepository.findByCategory(category.get());
			for(Product product:fetchData) {
				ProductDTO productDTO = new ProductDTO();
				BeanUtils.copyProperties(product,productDTO);
				String fileData = new String(product.getProductImage());
				productDTO.setProductImage(fileData);
				data.add(productDTO);
			}
			response = getResponseFormat(HttpStatus.OK, "Record Found", data);
			
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		return response;
	}

	@Override
	public ResponseEntity<?> saveProducts(ProductDTO productDTO) {
		ResponseEntity response = null;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			
			Map<String,Object> errors = new HashMap<String,Object>();
			if(productDTO.getQuantity() == null || productDTO.getQuantity() < 1) {
				errors.put("Quanity", "Product Quanity Cannot be null or 0!");
			}
			
			if(productDTO.getUnitPrice() == null || productDTO.getUnitPrice() < 1) {
				errors.put("Unit Price", "Product Price Cannot be null or 0!");
			}
			
			if(productDTO.getCategoryId() == null || productDTO.getCategoryId() < 1){
				errors.put("Category", "Please Select a valid Product Category");
			}
			
			if(errors != null && errors.size() > 0) {
				return getResponseFormat(HttpStatus.METHOD_NOT_ALLOWED, "Validation Error", errors);
			}
			
			Product product = new Product();
			BeanUtils.copyProperties(productDTO, product);
			byte[] imageBytes = productDTO.getProductImage().getBytes();
			product.setProductImage(imageBytes);
			product.setIsActive(true);
			
			Optional<Category> category = categoryRepository.findById(productDTO.getCategoryId());
			if(category.isPresent()){
				product.setCategory(category.get());
			}
			
			productRepository.save(product);
			productDTO.setProductId(product.getProductId());
			
			response = getResponseFormat(HttpStatus.OK, "Product Saved Successfully", productDTO);
			
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		return response;
	}



}
