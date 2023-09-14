package com.online.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
