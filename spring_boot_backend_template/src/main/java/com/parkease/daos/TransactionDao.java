package com.parkease.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkease.pojos.Transaction;

public interface TransactionDao extends JpaRepository<Transaction,Long>{

}
