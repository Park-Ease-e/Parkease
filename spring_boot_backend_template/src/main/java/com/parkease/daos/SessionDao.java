package com.parkease.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkease.pojos.Session;

public interface SessionDao extends JpaRepository<Session,Long> {

}
