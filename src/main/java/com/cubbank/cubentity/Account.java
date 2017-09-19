package com.cubbank.cubentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by osama on 12-09-2017.
 */
@Entity
public class Account extends Customer {

    private long accountNo;
    private double accountBalance;
    private String accountType;
    private Date accountActivationDate;

}
