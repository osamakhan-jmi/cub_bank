package com.cubbank.cubentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
    @Id
    @Column(name = "cub_bank_ifsc")
    private  String bankIfsc;
    @Column(name = "cub_bank_name")
    private String bankName;

    public String getBankIfsc() {
        return bankIfsc;
    }

    public String getBankName() {
        return bankName;
    }
}
