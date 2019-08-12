/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernateauctions.entity;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author mohanlal
 */
@Entity
public class Shipment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Id
    private long shipmentid;
    private int inspectionperioddays;
    private String state;
    private Date shipmentcreated;
    @OneToOne
    private Item item;
    @OneToOne   //
    private Useruser user;
    @OneToOne(mappedBy = "shipment",orphanRemoval = true, cascade = CascadeType.ALL)   
    private Address address;

    public long getShipmentid() {
        return shipmentid;
    }

    public void setShipmentid(long shipmentid) {
        this.shipmentid = shipmentid;
    }

    public int getInspectionperioddays() {
        return inspectionperioddays;
    }

    public void setInspectionperioddays(int inspectionperioddays) {
        this.inspectionperioddays = inspectionperioddays;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getShipmentcreated() {
        return shipmentcreated;
    }

    public void setShipmentcreated(Date shipmentcreated) {
        this.shipmentcreated = shipmentcreated;
    }

    public Item getItems() {
        return item;
    }

    public void setItems(Item items) {
        this.item = items;
    }

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
