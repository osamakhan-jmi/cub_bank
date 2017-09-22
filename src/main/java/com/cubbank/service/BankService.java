package com.cubbank.service;

import com.cubbank.cubentity.Bank;
import com.cubbank.repository.IBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bankService")
public class BankService implements IBankService{

    private IBankRepository bankRepository;

    @Autowired
    public BankService(IBankRepository bankRepository){
        this.bankRepository = bankRepository;
    }

    @Override
    public Iterable<Bank> getBank() {
        return bankRepository.findAll();
    }
}
