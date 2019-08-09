/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatetry.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author mohanlal
 *
 * @Entity(name="")
 * @Table(name="")
 * @Id
 * @Column(name="")
 * @Transient
 *
 */
@Entity
public class Student {

    @Id
    private int sid;
    private StudentName sname;
    private int smark;

    /**
     * @return the sname
     */
    public StudentName getSname() {
        return sname;
    }

    /**
     * @param sname the sname to set
     */
    public void setSname(StudentName sname) {
        this.sname = sname;
    }

    /*
    * @
    return the sid

    */
    public int getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    /**
     * @return the smark
     */
    public int getSmark() {
        return smark;
    }

    /**
     * @param smark the smark to set
     */
    public void setSmark(int smark) {
        this.smark = smark;
    }

    @Override
    public String toString() {
        return "Student{" + "sid=" + sid + ", sname=" + getSname() + ", smark=" + smark + '}';
    }

}
