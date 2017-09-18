package com.cubbank.repository;

/**
 * Created by osama on 18-09-2017.
 */

import org.springframework.data.repository.CrudRepository;
import com.cubbank.cubentity.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, String> {
}
