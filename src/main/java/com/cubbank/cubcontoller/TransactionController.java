package com.cubbank.cubcontoller;

import com.cubbank.cubentity.Transaction;
import com.cubbank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/cubbank")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @RequestMapping(path = "/transaction/customerId", method = RequestMethod.GET)
    public @ResponseBody Iterable<Transaction> getTransactionByCustomerId(@RequestParam("customerId") String cstId){
        return transactionService.getTransactionByCustomerId(cstId);
    }

    @RequestMapping(path = "/transaction/accountNo", method = RequestMethod.GET)
    public @ResponseBody Iterable<Transaction> getTransactionByAccountNo(@RequestParam("customerAccountNo") Long acno){
        return transactionService.getTransactionByAccountNo(acno);
    }
}
