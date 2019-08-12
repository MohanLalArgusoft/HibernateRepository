/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernateauctions.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author mohanlal
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BillingDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Id
    private long billid;
    private String ownername;
   
    @ManyToOne
    private Useruser user;
    @OneToOne(mappedBy = "billingDetails",orphanRemoval = true, cascade = CascadeType.ALL)
    private Address address;

    public long getBillid() {
        return billid;
    }

    public void setBillid(long billid) {
        this.billid = billid;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

//    public CreditCard getCreditCard() {
//        return creditCard;
//    }
//
//    public void setCreditCard(CreditCard creditCard) {
//        this.creditCard = creditCard;
//    }
//
//    public BankAccount getBankAccount() {
//        return bankAccount;
//    }
//
//    public void setBankAccount(BankAccount bankAccount) {
//        this.bankAccount = bankAccount;
//    }

    public Useruser getUser() {
        return user;
    }

    public void setUser(Useruser user) {
        this.user = user;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    
}
