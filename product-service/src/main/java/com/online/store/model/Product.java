package com.online.store.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long    productId;
	private String  productName;
	@Column(length = 1000)
	private String  productDescription;
	private Double  unitPrice;
	private Long    quantity;
	private Boolean isActive;
	private Long    purchases;
	@Lob
	@Basic
	@Type(type="org.hibernate.type.BinaryType")
	private byte[]  productImage;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
