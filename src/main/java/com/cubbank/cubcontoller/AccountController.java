package com.cubbank.cubcontoller;

import com.cubbank.cubentity.Account;
import com.cubbank.cubentity.Transaction;
import com.cubbank.service.AccountService;
import com.cubbank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping(path = "/cubbank")
public class AccountController {

    private AccountService accountService;
    private TransactionService transactionService;

    @Autowired
    public AccountController(AccountService accountService, TransactionService transactionService){
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    // fetch all account by customer ID
    @RequestMapping(path = "/customer/accounts", method = RequestMethod.POST)
    public @ResponseBody Iterable<Account> getCustomerAccount(@RequestParam("customerID") String cstid){
        return accountService.getAllCustomerAccount(cstid);
    }

    // customer debit ammount
    // takes parameter as account number, amount
    @RequestMapping(path = "/customer/account/debit", method = RequestMethod.POST)
    public @ResponseBody String debit(@RequestParam("accountNo") Long acno, @RequestParam("amount") double amount){
        String msg = null;
        Account a = accountService.getAccount(acno);
        if(amount>0){
            if((a.getAccountBalance() - amount)>0){
                a.setAccountBalance(a.getAccountBalance() - amount);
                accountService.updateAccount(a);

                Transaction t = new Transaction();
                t.setTansactionId("RMZ/COMCUB/OK/"+UUID.randomUUID().toString());
                t.setAccountNo(a.getAccountNo());
                t.setTransactionAmount(amount);
                t.setTransactionType("Debited");
                t.setCustomerId(a.getCustomerId());
                t.setTransactionDetail("Amount Debited From COMVIVA ATM RMZ GALLIERIA");
                t.setTransactionTime(new Date(System.currentTimeMillis()));

                transactionService.doTransaction(t);

                msg = "Amount Debited: " + amount + " Current Balance: " + a.getAccountBalance();
            }else{
                msg = "Insufficient Balance";
            }
        }else{
            msg = "Enter Correct Amount";
        }
        return msg;
    }

    // customer credit ammount
    // takes parameter as account number, amount
    @RequestMapping(path = "/customer/account/credit", method = RequestMethod.POST)
    public @ResponseBody String credit(@RequestParam("accountNo") Long acno, @RequestParam("amount") double amount){
        String msg = null;
        Account a = accountService.getAccount(acno);
        if(amount>0){
                a.setAccountBalance(a.getAccountBalance() + amount);
                accountService.updateAccount(a);

                Transaction t = new Transaction();
                t.setTansactionId("RMZ/COMCUB/OK/"+UUID.randomUUID().toString());
                t.setAccountNo(a.getAccountNo());
                t.setTransactionAmount(amount);
                t.setTransactionType("Credited");
                t.setCustomerId(a.getCustomerId());
                t.setTransactionDetail("Amount Credited From COMVIVA ATM RMZ GALLIERIA");
                t.setTransactionTime(new Date(System.currentTimeMillis()));

                transactionService.doTransaction(t);

                msg = "Amount Credited: " + amount + " Current Balance: " + a.getAccountBalance();
            }else{
                msg = "Enter Correct Amount";
            }
        return msg;
    }

    //fund transfer by customer
    //takes parameter as fromaccount number, amount, toaccount
    @RequestMapping(path = "/customer/account/fundtransfer", method = RequestMethod.POST)
    public @ResponseBody String fundTransfer(@RequestParam("fromaccount") Long fromAccount,
                                             @RequestParam("amount") double amount,
                                             @RequestParam("toaccount") Long toAccount){
        Account from = accountService.getAccount(fromAccount);
        Account to = accountService.getAccount(toAccount);
        String msg = null;
        if(to!=null){
            if(from.getAccountBalance()-amount >0){

                Transaction t = new Transaction();
                t.setTansactionId("RMZ/COMCUB/OK/"+UUID.randomUUID().toString());
                t.setAccountNo(from.getAccountNo());
                t.setTransactionAmount(amount);
                t.setTransactionType("Fund Transfer");
                t.setCustomerId(from.getCustomerId());
                t.setTransactionDetail("Fund Transfer" + to.getAccountNo());
                t.setTransactionTime(new Date(System.currentTimeMillis()));
                from.setAccountBalance(from.getAccountBalance()-amount);
                to.setAccountBalance(to.getAccountBalance()+amount);
                accountService.updateAccount(from);
                accountService.updateAccount(to);

                transactionService.doTransaction(t);

                msg = "Successfull Transaction";
            }else{
                msg = "Insufficient Balance";
            }
        }else{
            msg = "Enter Correct Account Number";
        }
        return  msg;
    }
}
