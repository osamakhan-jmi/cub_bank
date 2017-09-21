package com.cubbank.service;

import com.cubbank.cubentity.CubUser;
import com.cubbank.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userLoginService")
public class UserService implements IUserService{

    private IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public CubUser getUserById(String userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public boolean forgetPassword(CubUser u) {
        userRepository.save(u);
        return true;
    }

}
