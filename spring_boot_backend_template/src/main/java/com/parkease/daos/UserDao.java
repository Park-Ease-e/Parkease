package com.parkease.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkease.pojos.User;

public interface UserDao extends JpaRepository<User,Long>{

}
