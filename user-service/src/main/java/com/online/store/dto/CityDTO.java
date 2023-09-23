package com.online.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
	
	
	private Long   cityId;
	private String cityName;
	private Long   provinceId;
	private String provinceName;

}
