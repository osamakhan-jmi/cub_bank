package com.cubbank.service;

import com.cubbank.cubentity.Account;
import com.cubbank.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountService implements IAccountService {

    private IAccountRepository accountRepository;

    @Autowired
    public AccountService(IAccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Iterable<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Iterable<Account> getAllCustomerAccount(String cstID) {
        return accountRepository.getAccountsByCustomerId(cstID);
    }
}
