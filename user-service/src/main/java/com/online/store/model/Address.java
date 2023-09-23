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
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "street")
    private String street;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "province_id")
	private LkpProvince province;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
	private LkpCity city;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private LkpCountry country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
    
    @Column(name = "address_type", length = 2)
    private String type;

}
