/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernateauctions.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author mohanlal
 */
@Entity
public class Bid {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Id
    private long bidid;
    private BigDecimal amount;
    private Date bidcreated;
    @ManyToOne
    private Item item;
    @OneToOne  //
    private Item successitem;
    @ManyToOne
    private Useruser user;

    public long getBidid() {
        return bidid;
    }

    public void setBidid(long bidid) {
        this.bidid = bidid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getBidcreated() {
        return bidcreated;
    }

    public void setBidcreated(Date bidcreated) {
        this.bidcreated = bidcreated;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getSuccessitem() {
        return successitem;
    }

    public void setSuccessitem(Item successitem) {
        this.successitem = successitem;
    }

    public Useruser getUser() {
        return user;
    }

    public void setUser(Useruser user) {
        this.user = user;
    }
    
}
