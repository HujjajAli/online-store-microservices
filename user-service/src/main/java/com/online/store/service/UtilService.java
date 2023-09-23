package com.online.store.service;

import org.springframework.http.ResponseEntity;

import com.online.store.dto.CityDTO;
import com.online.store.dto.ProvinceDTO;
import com.online.store.model.LkpCountry;

public interface UtilService {
	
	
	ResponseEntity<?> saveCountry(LkpCountry country);
	ResponseEntity<?> getAllCountries();
	ResponseEntity<?> saveProvince(ProvinceDTO provinceDTO);
	ResponseEntity<?> getAllProvinces();
	ResponseEntity<?> saveCity(CityDTO cityDTO);
	ResponseEntity<?> getAllCities();
	ResponseEntity<?> getAllCitiesByProvinceId(Long provinceId);
	
	

}
