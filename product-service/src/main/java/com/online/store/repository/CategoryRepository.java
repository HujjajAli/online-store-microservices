package com.online.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.store.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
