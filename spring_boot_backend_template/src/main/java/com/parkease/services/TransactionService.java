package com.parkease.services;

import java.math.BigDecimal;
import java.util.List;

import com.parkease.dto.ApiResponse;
import com.parkease.dto.TransactionDto;

public interface TransactionService{
	List<TransactionDto> getTransactions();

	TransactionDto getTransaction(long id);

	List<TransactionDto> getTransactionsUserId(long id);

	ApiResponse updateTransactionAmount(long id, BigDecimal amount);
}
