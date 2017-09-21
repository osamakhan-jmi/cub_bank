package com.cubbank.cubcontoller;

import com.cubbank.cubentity.Bank;
import com.cubbank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Entity;

@Entity
@RequestMapping("/cubbank")
public class BankContoller {

    private BankService bankService;

    @Autowired
    public BankContoller(BankService bankService){
        this.bankService = bankService;
    }

    @RequestMapping(path = "/bank", method = RequestMethod.GET)
    public @ResponseBody Iterable<Bank> getBankDetail(){
        return bankService.getBank();
    }

}
