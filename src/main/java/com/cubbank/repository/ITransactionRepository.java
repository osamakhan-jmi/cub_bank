package com.cubbank.repository;

import com.cubbank.cubentity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ITransactionRepository extends CrudRepository<Transaction, String> {
    Iterable<Transaction> getTransactionByCustomerId(String customerId);
    Iterable<Transaction> getTransactionByAccountNo(Long accountNo);
    //List<Transaction> getTransactionByAccountNo(Long acno,Pageable pageable);
    Iterable<Transaction> findFirst10ByAccountNo(Long acno);
}
