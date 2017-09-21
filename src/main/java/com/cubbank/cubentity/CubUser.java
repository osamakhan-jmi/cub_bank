package com.cubbank.cubentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by osama on 12-09-2017.
 */
@Entity
public class CubUser {
    @Id
    @Column(name="cub_user_ID")
    private String userId;
    @Column(name="cub_user_pswd")
    private String userPassword;
    @Column(name="cub_user_loginAttempts")
    private int loginAttempts;
    @Column(name="cub_user_last_login")
    private Date lastLogin;
    @Column(name="cub_user_block_time")
    private Date blockTime;
    @Column(name="cub_user_auth_status")
    private String authStatus;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(Date blockTime) {
        this.blockTime = blockTime;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public int incrementLoginAttempts(){
        if(loginAttempts<3)
            loginAttempts +=1;
        return loginAttempts;
    }
}
