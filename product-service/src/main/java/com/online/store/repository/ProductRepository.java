package com.online.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.store.model.Category;
import com.online.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByCategory(Category category);
}
