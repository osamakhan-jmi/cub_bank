package com.cubbank.cubentity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by osama on 12-09-2017.
 */
@Entity
public class Transaction {

    @Id
    @Column(name = "cub_trans_ID")
    private String tansactionId;
    @Column(name = "cub_trans_amount")
    private double transactionAmount;
    @Column(name = "cub_trans_detail")
    private String transactionDetail;
    @Column(name = "cub_trans_type")
    private String transactionType;
    @Column(name = "cub_trans_time")
    private String transactionTime;
    @Column(name="cub_account_no")
    private long accountNo;
    @Column(name="cub_cust_ID")
    private String customerId;

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() { return customerId; }

    public long getAccountNo() {
        return accountNo;
    }

    public String getTansactionId() {
        return tansactionId;
    }

    public void setTansactionId(String tansactionId) {
        this.tansactionId = tansactionId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionDetail() {
        return transactionDetail;
    }

    public void setTransactionDetail(String transactionDetail) {
        this.transactionDetail = transactionDetail;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }
}
