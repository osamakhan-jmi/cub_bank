package com.cubbank.repository;

import com.cubbank.cubentity.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepository extends CrudRepository<Account, Long> {
}
