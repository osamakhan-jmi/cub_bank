package com.cubbank.cubentity;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;


@Entity
@Table(name = "benificiary")
@IdClass(CustBenIdclass.class)
public class CustomerBenificiary{


    @Id
    @Column(name = "cub_bank_ben_acno")
    private Long ben_accno;

    @Column(name = "cub_bank_ben_ifsc")
    private String ben_IFSC;
    @Column(name = "cub_bank_ben_holdername")
    private String ben_holdername;
    @Column(name = "cub_bank_ben_verified")
    private boolean ben_verified;

    @Id
    @Column(name = "cub_cust_ID")
    private String cust_ID;

    public Long getBen_accno() {
        return ben_accno;
    }

    public void setBen_accno(Long ben_accno) {
        this.ben_accno = ben_accno;
    }

    public String getBen_IFSC() {
        return ben_IFSC;
    }

    public void setBen_IFSC(String ben_IFSC) {
        this.ben_IFSC = ben_IFSC;
    }

    public String getBen_holdername() {
        return ben_holdername;
    }

    public void setBen_holdername(String ben_holdername) {
        this.ben_holdername = ben_holdername;
    }

    public boolean isBen_verified() {
        return ben_verified;
    }

    public void setBen_verified(boolean ben_verified) {
        this.ben_verified = ben_verified;
    }

    public String getCust_ID() {
        return cust_ID;
    }

    public void setCust_ID(String cust_ID) {
        this.cust_ID = cust_ID;
    }
}






