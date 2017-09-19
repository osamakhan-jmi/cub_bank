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
                return userService.getUserById(userid);
            }else{
                user.incrementLoginAttempts();
            }
        }
        return user;
    }
}
