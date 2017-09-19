package com.cubbank.cubentity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by osama on 12-09-2017.
 */
@Entity
public class Account {

    @Id
    @Column(name="cub_account_no")
    private long accountNo;
    @Column(name="cub_account_balance")
    private double accountBalance;
    @Column(name="cub_account_type")
    private String accountType;
    @Column(name="cub_account_open_date")
    private Date accountActivationDate;
    @Column(name="cub_cust_ID")
    private String customerId;

    public String getCustomerId() { return customerId; }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getAccountActivationDate() {
        return accountActivationDate;
    }

    public void setAccountActivationDate(Date accountActivationDate) {
        this.accountActivationDate = accountActivationDate;
    }
}
