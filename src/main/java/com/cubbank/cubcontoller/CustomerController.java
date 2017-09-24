package com.cubbank.cubcontoller;

/**
 * Created by osama on 13-09-2017.
 */

import com.cubbank.cubentity.CubUser;
import com.cubbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cubbank.cubentity.Customer;
import com.cubbank.service.CustomerService;

@Controller
@RequestMapping(path = "/cubbank")
public class CustomerController {

    private CustomerService customerService;
    private UserService userService;

    @Autowired
    public CustomerController(CustomerService customerService, UserService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @RequestMapping(path = "/customer/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Customer getCustomerById(@PathVariable("id") String cstID) {
        return customerService.getCustomerById(cstID);
    }

    @RequestMapping(path = "/customer/mpin", method = RequestMethod.POST)
    public @ResponseBody
    String getMpin(@RequestParam("customerid") String cstid, @RequestParam("tpassword") String pin) {
        Customer cst = customerService.getCustomerById(cstid);
        String msg = null;
        if (cst.getCustomermpin().equals(pin)) {
            msg = "Coorect";
        } else {
            msg = "Incorrect";
        }
        return msg;
    }

    @RequestMapping(path = "/customer/changeaddress", method = RequestMethod.POST)
    public @ResponseBody
    String updateCustomerAddress(@RequestParam("cstid") String cstid,
                                 @RequestParam("street") String street,
                                 @RequestParam("city") String city,
                                 @RequestParam("street") String state,
                                 @RequestParam("coutnry") String country,
                                 @RequestParam("pin") int pin) {
        Customer cst = customerService.getCustomerById(cstid);
        if (street != null) {
            cst.setCustomerStreet(street);
        }
        if (city != null) {
            cst.setCustomerCity(city);
        }
        if (state != null) {
            cst.setCustomerStreet(state);
        }
        if (country != null) {
            cst.setCustomerCountry(country);
        }
        if (pin != 0) {
            cst.setCustomerPostalPin(pin);
        }
        customerService.registerCustomer(cst);
        return "Address Updated";
    }

    @RequestMapping(path = "/customer/register", method = RequestMethod.POST)
    public @ResponseBody String registerCustomer(@RequestParam("id") String cstId,
                                                 @RequestParam("mobno") Long cstMobNo,
                                                 @RequestParam("cstFname") String cstFname,
                                                 @RequestParam("cstMname") String cstMname,
                                                 @RequestParam("cstLname") String cstLname,
                                                 @RequestParam("gender") String cstgndr,
                                                 @RequestParam("email") String cstEmail,
                                                 @RequestParam("street") String cstStreet,
                                                 @RequestParam("city") String cstCity,
                                                 @RequestParam("state") String cstState,
                                                 @RequestParam("country") String cstCountry,
                                                 @RequestParam("pin") int cstpin,
                                                 @RequestParam("mpin") String cstMpin,
                                                 @RequestParam("pswd") String pswd,
                                                 @RequestParam("cpswd") String cpswd) {

        String msg = null;

        if (!cstId.equals(customerService.getCustomerById(cstId))) {

            if (pswd.equals(cpswd)) {

                //customer addition
                Customer cst = new Customer();
                cst.setCustomerId(cstId);
                cst.setCustomerMobNo(cstMobNo);
                cst.setCustomerFname(cstFname);
                cst.setCustomerMname(cstMname);
                cst.setCustomerLname(cstLname);
                cst.setCustomerGender(cstgndr);
                cst.setCustomerEmail(cstEmail);
                cst.setCustomerStreet(cstStreet);
                cst.setCustomerCity(cstCity);
                cst.setCustomerState(cstState);
                cst.setCustomerCountry(cstCountry);
                cst.setCustomerPostalPin(cstpin);
                cst.setCustomermpin(cstMpin);
                customerService.registerCustomer(cst);

                //user addition
                CubUser usr = new CubUser();
                usr.setUserId(cstId);
                usr.setUserPassword(pswd);
                usr.setLoginAttempts(0);
                userService.save(usr);
                msg = "Customer Registered";

            }else{
                msg = "Password is incorrect!!";
            }
        }else{
            msg = "Customer Id already exists";
        }
        return msg;
    }
}