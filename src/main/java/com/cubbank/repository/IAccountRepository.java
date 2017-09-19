package com.cubbank.repository;

import com.cubbank.cubentity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

public interface IAccountRepository extends CrudRepository<Account, Long> {

    @Query("select  from account where account.cub_cust_ID = ?1")
    Iterable<Account> findCustomerAccounts(String cstID);
}
