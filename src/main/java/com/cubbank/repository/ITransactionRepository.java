package com.cubbank.repository;

import com.cubbank.cubentity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface ITransactionRepository extends CrudRepository<Transaction, String> {
    Iterable<Transaction> getTransactionByCustomerId(String customerId);
    Iterable<Transaction> getTransactionByAccountNo(Long accountNo);
}
