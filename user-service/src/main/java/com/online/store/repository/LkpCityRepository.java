package com.online.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.store.model.LkpCity;
import com.online.store.model.LkpProvince;

public interface LkpCityRepository extends JpaRepository<LkpCity, Long>{
	
	List<LkpCity> findByProvince(LkpProvince province);
}
