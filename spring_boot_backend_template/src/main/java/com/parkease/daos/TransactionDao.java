package com.parkease.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkease.dto.TransactionDto;
import com.parkease.pojos.Transaction;

public interface TransactionDao extends JpaRepository<Transaction,Long>{

	List<Transaction> findByUserUserId(long id);

}
