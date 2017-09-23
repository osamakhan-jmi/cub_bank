package com.cubbank.cubentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by osama on 12-09-2017.
 */
@Entity
@Table(name = "cubuser")
public class CubUser {
    @Id
    @Column(name="cub_user_ID")
    private String userId;
    @Column(name="cub_user_pswd")
    private String userPassword;
    @Column(name="cub_user_loginAttempts")
    private Integer loginAttempts;
    @Column(name="cub_user_last_login")
    private String lastLogin;
    @Column(name="cub_user_block_time")
    private String blockTime;

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

    public Integer getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(Integer loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(String blockTime) {
        this.blockTime = blockTime;
    }

    public Integer incrementLoginAttempts(){
        if(loginAttempts<3)
            loginAttempts +=1;
        return loginAttempts;
    }
}
