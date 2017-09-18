package com.cubbank.service;

import com.cubbank.cubentity.Customer;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by osama on 18-09-2017.
 */
public interface ICustomerService {

    Iterable<Customer> getAllCustomer();
    Customer getCustomerById(String custID);
}
