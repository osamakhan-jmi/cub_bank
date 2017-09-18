package com.cubbank.service;

import com.cubbank.cubentity.Account;

/**
 * Created by osama on 18-09-2017.
 */
public interface IAccountService {

    Iterable<Account> getAllAccount();
    Account getCustomerById(String custID);
}
