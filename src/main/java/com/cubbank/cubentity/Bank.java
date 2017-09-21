package com.cubbank.cubentity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by osama on 12-09-2017.
 */
@Entity
public class Bank {
    @Column(name = "cub_bank_ifcs")
    private String bankIFSC;
    @Column(name = "cub_bank_bank_name")
    private String bankName;
    @Column(name = "cub_bank_asset")
    private double bankAsset;

    public String getBankIFSC() {
        return bankIFSC;
    }

    public String getBankName() {
        return bankName;
    }

    public double getBankAsset() {
        return bankAsset;
    }
}
