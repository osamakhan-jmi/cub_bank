package com.cubbank.cubcontoller;

import com.cubbank.cubentity.LoginResponse;
import com.cubbank.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.cubbank.cubentity.CubUser;
import com.cubbank.service.UserService;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping(path = "/cubbank")
public class UserController {

    private UserService userService;
    private EmailService emailService;

    @Autowired
    public UserController(UserService userService, EmailService emailService){

        this.userService = userService;
        this.emailService = emailService;
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public @ResponseBody LoginResponse validateUserLogin(@RequestParam("userid") String userid,
                                                         @RequestParam("password") String pswd){

        CubUser cubUser = null;
        LoginResponse user = new LoginResponse();
        if(userService.getUserById(userid)!=null){

            cubUser = userService.getUserById(userid);
            if(cubUser.getUserPassword().equals(pswd)){

                if(cubUser.getLoginAttempts()<3){
                    cubUser = userService.getUserById(userid);
                    cubUser.setLastLogin(new Date(System.currentTimeMillis()).toString());
                    userService.save(cubUser);

                    cubUser.setUserPassword(null);
                    user.setMsg("Login Successful");
                    user.setUser(cubUser);
                    return user;
                }else{
                    user.setMsg("You are Blocked");
                    user.setUser(null);
                }
            }else{
                cubUser.incrementLoginAttempts();
                if(cubUser.getLoginAttempts()>2) {
                    cubUser.setBlockTime(new Date(System.currentTimeMillis()).toString());
                    user.setMsg("You are Blocked");
                    user.setUser(null);
                    userService.save(cubUser);
                }else{

                    userService.save(cubUser);
                    user.setMsg("No of attempts: " + cubUser.getLoginAttempts());
                    user.setUser(null);
                }
            }
        }
        else{
            user.setMsg("You are unauthenticated!");
            return user;
        }
        return user;
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
