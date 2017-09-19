package com.cubbank.cubcontoller;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.cubbank.cubentity.User;
import com.cubbank.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public @ResponseBody void validateUserLogin(@RequestParam("userId") String userId, @RequestParam("password") String pswd){
        User user = userService.getUserById(userId);
        if ( user.getUserId().equals(userId)) {

            if(user.getUserPassword().equals(pswd)){

            } else{

                if(user.incrementLoginAttempts()<3){
                    
                }
            }
        }
    }

}
