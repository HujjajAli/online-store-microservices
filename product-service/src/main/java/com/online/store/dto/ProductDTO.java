package com.online.store.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
	private Long    productId;
	private String  productName;
	private String  productDescription;
	private Double  unitPrice;
	private Long    quantity;
	private Boolean isActive;
	private Long    purchases;

}
