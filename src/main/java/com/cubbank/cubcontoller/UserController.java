package com.cubbank.cubcontoller;

import com.sun.deploy.net.HttpRequest;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import com.cubbank.cubentity.User;
import com.cubbank.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public ModelAndView validateUserLogin(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult,
                                          @RequestParam Map requestParams, RedirectAttributes rdrAttr){

        modelAndView.setViewName("");
        if(userService.getUserById(user.getUserId())!=null) {
            User usr = userService.getUserById(user.getUserId());
            if(user.getUserPassword().equals(usr.getUserPassword())){
                if(user.getLoginAttempts()<3){
                    modelAndView.setViewName("");
                }else{
                        rdrAttr.addFlashAttribute("errorMessage","You are blocked");
                }
            }else{
                rdrAttr.addFlashAttribute("errorMessage","Password is wrong");
            }
        }else{
            rdrAttr.addFlashAttribute("errorMessage","Wrong User Id");
        }
        return modelAndView;
    }
}
