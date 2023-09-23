package com.online.store.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.online.store.dto.CityDTO;
import com.online.store.dto.ProvinceDTO;
import com.online.store.model.LkpCity;
import com.online.store.model.LkpCountry;
import com.online.store.model.LkpProvince;
import com.online.store.repository.UtilRepository;
import com.online.store.service.UtilService;

import static com.online.store.util.Util.getResponseFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtilServiceImpl implements UtilService {
	
	@Autowired
	private UtilRepository utilRepository;

	@Override
	public ResponseEntity<?> saveCountry(LkpCountry country) {
		ResponseEntity response = null;
		try {	
			utilRepository.getLkpCountryRepositiry().save(country);
			response = getResponseFormat(HttpStatus.OK, "New Country Saved Succesfully! ", country);
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		return response;
	}

	@Override
	public ResponseEntity<?> getAllCountries() {
		ResponseEntity response = null;
		try {
			List<LkpCountry> allCountries = utilRepository.getLkpCountryRepositiry().findAll();
			response = getResponseFormat(HttpStatus.OK, "Record Found", allCountries);
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		return response;
	}

	@Override
	public ResponseEntity<?> saveProvince(ProvinceDTO provinceDTO) {
		ResponseEntity response = null;
		try {
			LkpProvince province = new LkpProvince();
			BeanUtils.copyProperties(provinceDTO, province);
			Optional<LkpCountry> country = utilRepository.getLkpCountryRepositiry().findById(provinceDTO.getCountryId());
			province.setCountry(country.get());
			utilRepository.getLkpProvinceRepository().save(province);
			provinceDTO.setProvinceId(province.getProvinceId());
			response = getResponseFormat(HttpStatus.OK, "New Province Saved Succesfully! ", provinceDTO);
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		return response;
	}

	@Override
	public ResponseEntity<?> getAllProvinces() {
		ResponseEntity response = null;
		try {
			List<ProvinceDTO> provincesData = new ArrayList<ProvinceDTO>(); 
			List<LkpProvince> allProvinces = utilRepository.getLkpProvinceRepository().findAll();
			for(LkpProvince province:allProvinces) {
				ProvinceDTO provinceDTO = new ProvinceDTO();
				BeanUtils.copyProperties(province, provinceDTO);
				provincesData.add(provinceDTO);
			}
			response = getResponseFormat(HttpStatus.OK, "Record Found", provincesData);
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		return response;
	}

	@Override
	public ResponseEntity<?> saveCity(CityDTO cityDTO) {
		ResponseEntity response = null;
		try {
			LkpCity city = new LkpCity();
			BeanUtils.copyProperties(cityDTO, city);
			Optional<LkpProvince> province = utilRepository.getLkpProvinceRepository().findById(cityDTO.getProvinceId());
			city.setProvince(province.get());
			utilRepository.getLkpCityRepository().save(city);
			cityDTO.setCityId(city.getCityId());
			response = getResponseFormat(HttpStatus.OK, "New City Saved Succesfully! ", cityDTO);
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		return response;
	}

	@Override
	public ResponseEntity<?> getAllCities() {
		ResponseEntity response = null;
		try {
			List<CityDTO> citiesData = new ArrayList<CityDTO>();
			List<LkpCity> allCities = utilRepository.getLkpCityRepository().findAll();
			for(LkpCity city:allCities) {
				CityDTO cityDTO = new CityDTO();
				BeanUtils.copyProperties(city, cityDTO);
				cityDTO.setProvinceId(city.getProvince().getProvinceId());
				cityDTO.setProvinceName(city.getProvince().getProvinceName());
				citiesData.add(cityDTO);
			}
			response = getResponseFormat(HttpStatus.OK, "Record Found", citiesData);
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		return response;
	}

	@Override
	public ResponseEntity<?> getAllCitiesByProvinceId(Long provinceId) {
		ResponseEntity response = null;
		try {
			List<CityDTO> citiesData = new ArrayList<CityDTO>();
			Optional<LkpProvince> province = utilRepository.getLkpProvinceRepository().findById(provinceId);
			List<LkpCity> allCities = utilRepository.getLkpCityRepository().findByProvince(province.get());
			for(LkpCity city:allCities) {
				CityDTO cityDTO = new CityDTO();
				BeanUtils.copyProperties(city, cityDTO);
				cityDTO.setProvinceId(city.getProvince().getProvinceId());
				cityDTO.setProvinceName(city.getProvince().getProvinceName());
				citiesData.add(cityDTO);
			}
			response = getResponseFormat(HttpStatus.OK, "Record Found", citiesData);
		}catch (Exception e) {
			e.printStackTrace();
			response = getResponseFormat(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
		}
		return response;
	}

	

}
