package com.cubbank.cubentity;

/**
 * Created by osama on 12-09-2017.
 */
public class CustomerBenificiary extends Customer{
    private int benificiaryAccountNo;
    private String benificiaryAccountName;
    private String benificiaryBankIFSC;
    private String benificiaryAccountStatus;

    public int getBenificiaryAccountNo() {
        return benificiaryAccountNo;
    }

    public void setBenificiaryAccountNo(int benificiaryAccountNo) {
        this.benificiaryAccountNo = benificiaryAccountNo;
    }

    public String getBenificiaryAccountName() {
        return benificiaryAccountName;
    }

    public void setBenificiaryAccountName(String benificiaryAccountName) {
        this.benificiaryAccountName = benificiaryAccountName;
    }

    public String getBenificiaryBankIFSC() {
        return benificiaryBankIFSC;
    }

    public void setBenificiaryBankIFSC(String benificiaryBankIFSC) {
        this.benificiaryBankIFSC = benificiaryBankIFSC;
    }

    public String getBenificiaryAccountStatus() {
        return benificiaryAccountStatus;
    }

    public void setBenificiaryAccountStatus(String benificiaryAccountStatus) {
        this.benificiaryAccountStatus = benificiaryAccountStatus;
    }
}
