package com.cubbank.cubcontoller;

/**
 * Created by osama on 13-09-2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cubbank.cubentity.Customer;
import com.cubbank.service.CustomerService;

@Controller
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path="/customer/all")
    public @ResponseBody Iterable<Customer> Contoller_getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping(path="/customer/{id}")
    public @ResponseBody Customer Contoller_getCustomerById(@PathVariable("id") String cstID){
        return  customerService.getCustomerById(cstID);
    }
}
