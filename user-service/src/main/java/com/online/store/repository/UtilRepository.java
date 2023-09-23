package com.online.store.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UtilRepository {
	
	@Autowired
	private LkpCountryRepositiry lkpCountryRepositiry; 
	@Autowired
	private LkpProvinceRepository lkpProvinceRepository;
	@Autowired
	private LkpCityRepository lkpCityRepository;

}
