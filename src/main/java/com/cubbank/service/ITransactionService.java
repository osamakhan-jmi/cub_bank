package com.cubbank.service;

import com.cubbank.cubentity.Transaction;

import java.util.List;

public interface ITransactionService {
    Iterable<Transaction> getTransactionByCustomerId(String customerId);
    Iterable<Transaction> getTransactionByAccountNo(Long accountNo);
    boolean doTransaction(Transaction t);
    Iterable<Transaction> getN(Long acno);
}
