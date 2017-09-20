package com.cubbank.service;

import com.cubbank.cubentity.Account;

public interface IAccountService {
    Iterable<Account> getAllAccount();
    Iterable<Account> getAllCustomerAccount(String cstID);
    Account getAccount(Long acno);
    boolean updateAccount(Account a);
}
