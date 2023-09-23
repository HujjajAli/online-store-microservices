package com.online.store.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceDTO {
	
	private Long   provinceId;
	private String provinceName;
    private Long   countryId;
    private String countryName;

}
