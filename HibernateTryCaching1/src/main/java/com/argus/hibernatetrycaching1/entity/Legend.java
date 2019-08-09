/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatetrycaching1.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author mohanlal
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Legend {

    @Override
    public String toString() {
        return "Legend{" + "lid=" + lid + ", lname=" + lname + ", extra=" + extra + '}';
    }

    @Id
    private int lid;
    private String lname;
    private String extra;
    /**
     * @return the lid
     */
    public int getLid() {
        return lid;
    }

    /**
     * @param lid the lid to set
     */
    public void setLid(int lid) {
        this.lid = lid;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the extra
     */
    public String getExtra() {
        return extra;
    }

    /**
     * @param extra the extra to set
     */
    public void setExtra(String extra) {
        this.extra = extra;
    }
}
