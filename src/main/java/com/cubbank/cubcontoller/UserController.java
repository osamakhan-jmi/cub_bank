package com.cubbank.cubcontoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.cubbank.cubentity.CubUser;
import com.cubbank.service.UserService;

@Controller
@RequestMapping(path = "/cubbank")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){

        this.userService = userService;
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public @ResponseBody
    CubUser validateUserLogin(@RequestParam("userid") String userid, @RequestParam("password") String pswd){

        CubUser cubUser = null;
        if(userService.getUserById(userid)!=null){

            cubUser = userService.getUserById(userid);
            if(cubUser.getUserPassword().equals(pswd)){

                cubUser = userService.getUserById(userid);
                cubUser.setUserPassword(null);
                return cubUser;
            }else{
                cubUser.incrementLoginAttempts();
            }
        }
        return cubUser;
    }

    @RequestMapping(path = "/user/forgetpassword", method = RequestMethod.POST)
    public @ResponseBody String forgetPassword(@RequestParam("oldPswd") String oldPswd,
                                               @RequestParam("newPswd") String newPswd,
                                               @RequestParam("cnfrmPswd") String cnfrmPswd,
                                               @RequestParam("userid") String userid){
        String msg = null;
        CubUser u = userService.getUserById(userid);
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
