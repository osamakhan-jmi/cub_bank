package com.cubbank.service;

import com.cubbank.cubentity.User;
import com.cubbank.repository.IUserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by osama on 18-09-2017.
 */
@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;

    @Override
    public User getUserById(String userId) {
        return  userRepository.findOne(userId);
    }
}
