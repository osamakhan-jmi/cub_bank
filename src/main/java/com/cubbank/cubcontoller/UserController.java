package com.cubbank.cubcontoller;

import com.sun.deploy.net.HttpRequest;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.cubbank.cubentity.User;
import com.cubbank.service.UserService;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping(path = "/cubbank")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public @ResponseBody User validateUserLogin(@RequestParam("userid") String userid, @RequestParam("password") String pswd){

        User user = null;
        if(userService.getUserById(userid)!=null){

            user = userService.getUserById(userid);
            if(user.getUserPassword().equals(pswd)){

                user = userService.getUserById(userid);
                user.setUserPassword(null);
                return user;
            }else{
                user.incrementLoginAttempts();
            }
        }
        return user;
    }

    @RequestMapping(value = "/user/forgetpassword", method = RequestMethod.POST)
    public @ResponseBody String forgetPassword(@RequestParam("oldPswd") String oldPswd,
                                               @RequestParam("newPswd") String newPswd,
                                               @RequestParam("cnfrmPswd") String cnfrmPswd,
                                               @RequestParam("userid") String userid){
        String msg = null;
        User u = userService.getUserById(userid);
        if(u.getUserPassword().equals(oldPswd)){
            if(newPswd.equals(cnfrmPswd)){
                u.setUserPassword(newPswd);
                userService.forgetPassword(u);
                msg = "Password Chnged";
            }else{
                msg = "Password does not match";
            }
        }else{
            msg = "Enter Correct Old Password";
        }
        return msg;
    }
}
