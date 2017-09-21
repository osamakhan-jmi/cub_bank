package com.cubbank.service;

import com.cubbank.cubentity.CubUser;

public interface IUserService {
    CubUser getUserById(String userId);
    boolean forgetPassword(CubUser u);
}
