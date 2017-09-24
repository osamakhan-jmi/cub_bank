package com.cubbank.cubentity;

/**
 * Created by osama on 24-09-2017.
 */
public class LoginResponse {

    private String msg;
    private CubUser user;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CubUser getUser() {
        return user;
    }

    public void setUser(CubUser user) {
        this.user = user;
    }
}
