package com.online.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.store.model.LkpCountry;

public interface LkpCountryRepositiry extends JpaRepository<LkpCountry, Long> {

}
