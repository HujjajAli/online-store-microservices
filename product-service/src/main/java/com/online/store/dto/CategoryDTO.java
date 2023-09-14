package com.online.store.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
	
	
	private Long categoryId;
	private String categoryName;
	private Boolean active;
	private String activeClass;

}
