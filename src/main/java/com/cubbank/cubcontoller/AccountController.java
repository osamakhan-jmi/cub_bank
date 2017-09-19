package com.cubbank.cubcontoller;

import com.cubbank.cubentity.Account;
import com.cubbank.cubentity.User;
import com.cubbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping(path = "/cubbank")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @RequestMapping(path = "/customer/accounts", method = RequestMethod.POST)
    public @ResponseBody Iterable<Account> getCustomerAccount(@RequestParam("customerID") String cstid){
        return accountService.getAllCustomerAccount(cstid);
    }
}
