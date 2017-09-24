package com.cubbank.cubentity;

import java.util.Date;

import javax.persistence.*;

/**
 * Created by osama on 12-09-2017.
 */

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Customer {

    @Id
    @Column(name="cub_cust_ID")
    private String customerId;
    @Column(name="cub_cust_mobno")
    Long customerMobNo;
    @Column(name="cub_cust_fname")
    private String customerFname;
    @Column(name="cub_cust_mname")
    private String customerMname;
    @Column(name="cub_cust_lname")
    private String customerLname;
    @Column(name="cub_cust_gender")
    private String customerGender;
    @Column(name="cub_cust_email")
    private String customerEmail;
    @Column(name="cub_cust_street")
    private String customerStreet;
    @Column(name="cub_cust_city")
    private String customerCity;
    @Column(name="cub_cust_state")
    private String customerState;
    @Column(name="cub_cust_country")
    private String customerCountry;
    @Column(name="cub_cust_piostal_pin")
    private int customerPostalPin;
    @Column(name="cub_cust_tpassword")
    private String customermpin;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerMobNo() {
        return customerMobNo;
    }

    public void setCustomerMobNo(Long customerMobNo) {
        this.customerMobNo = customerMobNo;
    }

    public String getCustomerFname() {
        return customerFname;
    }

    public void setCustomerFname(String customerFname) {
        this.customerFname = customerFname;
    }

    public String getCustomerMname() {
        return customerMname;
    }

    public void setCustomerMname(String customerMname) {
        this.customerMname = customerMname;
    }

    public String getCustomerLname() {
        return customerLname;
    }

    public void setCustomerLname(String customerLname) {
        this.customerLname = customerLname;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerStreet() {
        return customerStreet;
    }

    public void setCustomerStreet(String customerStreet) {
        this.customerStreet = customerStreet;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public int getCustomerPostalPin() {
        return customerPostalPin;
    }

    public void setCustomerPostalPin(int customerPostalPin) {
        this.customerPostalPin = customerPostalPin;
    }

    public void setCustomermpin(String customermpin){ this.customermpin = customermpin; }

    public String getCustomermpin(){ return this.customermpin; }
}

