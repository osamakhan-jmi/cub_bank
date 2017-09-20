package com.cubbank.service;

import com.cubbank.cubentity.Transaction;

public interface ITransactionService {
    Iterable<Transaction> getTransactionByCustomerId(String customerId);
    Iterable<Transaction> getTransactionByAccountNo(Long accountNo);
    boolean doTransaction(Transaction t);
}
