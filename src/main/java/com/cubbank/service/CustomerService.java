package com.cubbank.service;

import com.cubbank.cubentity.Customer;

import com.cubbank.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by osama on 18-09-2017.
 */

@Service("customerService")
public class CustomerService implements ICustomerService {


    private ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(String custID) {
        return customerRepository.findOne(custID);
    }
}
