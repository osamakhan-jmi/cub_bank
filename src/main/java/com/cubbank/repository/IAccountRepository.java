package com.cubbank.repository;

import com.cubbank.cubentity.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by osama on 18-09-2017.
 */

public interface IAccountRepository extends CrudRepository<Account, String> {
}
