/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatetrymapping.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



/**
 *
 * @author mohanlal
 */

@Entity
public class Laptop {

    @Id
    private int lid;
    private String lapname;
    @ManyToMany
    private List<Employee> employees = new ArrayList<Employee>();
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
     * @return the lapname
     */
    public String getLapname() {
        return lapname;
    }

    /**
     * @param lapname the lapname to set
     */
    public void setLapname(String lapname) {
        this.lapname = lapname;
    }

    /**
     * @return the employees
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * @param employees the employees to set
     */
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
