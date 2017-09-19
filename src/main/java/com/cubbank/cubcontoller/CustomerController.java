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

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(path="/customer/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<Customer> Contoller_getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @RequestMapping(path="/customer/{id}", method = RequestMethod.GET)
    public @ResponseBody Customer Contoller_getCustomerById(@PathVariable("id") String cstID){
        return  customerService.getCustomerById(cstID);
    }
}
