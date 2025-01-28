package com.parkease.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkease.pojos.Faq;

public interface FaqDao extends JpaRepository<Faq,Long>{

}
