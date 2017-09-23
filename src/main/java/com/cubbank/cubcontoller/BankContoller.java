package com.cubbank.cubcontoller;

import com.cubbank.cubentity.Bank;
import com.cubbank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/cubbank")
public class BankContoller {

    private BankService bankService;

    @Autowired
    public BankContoller(BankService bankService){
        this.bankService = bankService;
    }

    @RequestMapping(path = "/bank/asset", method = RequestMethod.POST)
    public @ResponseBody Iterable<Bank> getBank(){
        return bankService.getBank();
    }

}
