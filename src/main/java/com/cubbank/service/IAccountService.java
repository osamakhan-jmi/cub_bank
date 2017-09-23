package com.cubbank.service;

import com.cubbank.cubentity.Account;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

public interface IAccountService {
    Iterable<Account> getAllAccount();
    Iterable<Account> getAllCustomerAccount(String cstID);
    Account getAccount(Long acno);
    boolean updateAccount(Account a);
    Account getAcountByAcountNo(Long acno);
}
