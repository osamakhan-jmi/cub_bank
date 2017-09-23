package com.cubbank.service;

import com.cubbank.cubentity.Transaction;
import com.cubbank.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public boolean doTransaction(Transaction t) {
        transactionRepository.save(t);
        return true;
    }

//    @Override
//    public List<Transaction> getN(int n,Long acno) {
//        Pageable topN = new PageRequest(0,n, Sort.Direction.DESC,"cub_account_no");
//        List<Transaction> result = transactionRepository.getTransactionByAccountNo(acno,topN);
//        return result;
//    }

    @Override
    public Iterable<Transaction> getN(Long acno) {
        return transactionRepository.findFirst10ByAccountNo(acno);
    }
}
