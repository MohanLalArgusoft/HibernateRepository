/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatetrymapping;

import javax.persistence.Embeddable;

/**
 *
 * @author mohanlal
 */

@Embeddable
public class StudentName {

    private String fname;
    private String lname;
    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
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

    @Override
    public String toString() {
        return "StudentName{" + "fname=" + fname + ", lname=" + lname + '}';
    }
            
}
