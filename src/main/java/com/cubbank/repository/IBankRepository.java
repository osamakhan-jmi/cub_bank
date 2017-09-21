package com.cubbank.repository;

import com.cubbank.cubentity.Bank;
import org.springframework.data.repository.CrudRepository;

public interface IBankRepository extends CrudRepository<Bank, String> {
}
