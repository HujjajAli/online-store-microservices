package com.online.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LkpProvince {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="province_id")
	private Long provinceId;
	private String provinceName;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private LkpCountry country;

}
