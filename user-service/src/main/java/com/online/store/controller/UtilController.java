package com.online.store.controller;

import static com.online.store.util.Util.getResponseFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.dto.CityDTO;
import com.online.store.dto.ProvinceDTO;
import com.online.store.model.LkpCountry;
import com.online.store.service.UtilService;

@RequestMapping("/util/lov")
@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class UtilController {
	
	@Autowired
	private UtilService utilService;
	
	@PostMapping("/country")
	public ResponseEntity<?> saveCountry(@RequestBody LkpCountry country){
		try {
			return utilService.saveCountry(country);
		}catch (Exception e) {
			e.printStackTrace();
			return getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
	}
	
	@GetMapping("/country")
	public ResponseEntity<?> getAllCountries(){
		try {
			return utilService.getAllCountries();
		}catch (Exception e) {
			e.printStackTrace();
			return getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
	}
	
	@PostMapping("/province")
	public ResponseEntity<?> saveProvince(@RequestBody ProvinceDTO province){
		try {
			return utilService.saveProvince(province);
		}catch (Exception e) {
			e.printStackTrace();
			return getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
	}
	
	@GetMapping("/province")
	public ResponseEntity<?> getAllProvinces(){
		try {
			return utilService.getAllProvinces();
		}catch (Exception e) {
			e.printStackTrace();
			return getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
	}
	
	@PostMapping("/city")
	public ResponseEntity<?> saveCity(@RequestBody CityDTO city){
		try {
			return utilService.saveCity(city);
		}catch (Exception e) {
			e.printStackTrace();
			return getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
	}
	
	@GetMapping("/city")
	public ResponseEntity<?> getAllCities(){
		try {
			return utilService.getAllCities();
		}catch (Exception e) {
			e.printStackTrace();
			return getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
	}
	
	@GetMapping("/city/provinceid/{provincId}")
	public ResponseEntity<?> getAllCities(@PathVariable("provincId") Long provincId){
		try {
			return utilService.getAllCitiesByProvinceId(provincId);
		}catch (Exception e) {
			e.printStackTrace();
			return getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
	}

}
