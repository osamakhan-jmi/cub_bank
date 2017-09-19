package com.cubbank.service;

import com.cubbank.cubentity.Transaction;
import com.cubbank.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transactionService")
public class TransactionService implements ITransactionService {

    private ITransactionRepository transactionRepository;

    @Autowired
    public TransactionService(ITransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Iterable<Transaction> getTransactionByCustomerId(String customerId) {
        return transactionRepository.getTransactionByCustomerId(customerId);
    }

    @Override
    public Iterable<Transaction> getTransactionByAccountNo(Long accountNo) {
        return transactionRepository.getTransactionByAccountNo(accountNo);
    }
}
