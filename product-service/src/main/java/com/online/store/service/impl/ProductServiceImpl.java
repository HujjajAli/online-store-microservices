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
import com.online.store.dto.ProductDTO;
import com.online.store.model.Category;
import com.online.store.model.Product;
import com.online.store.repository.ProductRepository;
import com.online.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

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
				data.add(productDTO);
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
	public ResponseEntity<?> saveProducts(ProductDTO productDTO) {
		ResponseEntity response = null;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			
			Product product = new Product();
			BeanUtils.copyProperties(productDTO, product);
			
			productRepository.save(product);
			
			map.put("responcode", 0);
			map.put("message", "Category Saved Successfully");
			map.put("data", product);
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
