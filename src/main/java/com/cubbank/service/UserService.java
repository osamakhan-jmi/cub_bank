package com.cubbank.service;

import com.cubbank.cubentity.User;
import com.cubbank.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findOne(userId);
    }
}
