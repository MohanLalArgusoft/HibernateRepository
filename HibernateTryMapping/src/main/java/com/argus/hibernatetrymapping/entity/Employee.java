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
public class Employee {

    @Override
    public String toString() {
        return "Employee{" + "Eid=" + Eid + ", Ename=" + Ename + ", Esalary=" + Esalary + '}';
    }

    @Id
    private int Eid;
    private String Ename;
    private int Esalary;
    @ManyToMany(mappedBy = "employees")
    private List<Laptop> laptops = new ArrayList<Laptop>();
    /**
     * @return the Eid
     */
    public int getEid() {
        return Eid;
    }

    /**
     * @param Eid the Eid to set
     */
    public void setEid(int Eid) {
        this.Eid = Eid;
    }

    /**
     * @return the Ename
     */
    public String getEname() {
        return Ename;
    }

    /**
     * @param Ename the Ename to set
     */
    public void setEname(String Ename) {
        this.Ename = Ename;
    }

    /**
     * @return the Esalary
     */
    public int getEsalary() {
        return Esalary;
    }

    /**
     * @param Esalary the Esalary to set
     */
    public void setEsalary(int Esalary) {
        this.Esalary = Esalary;
    }

    /**
     * @return the laptops
     */
    public List<Laptop> getLaptops() {
        return laptops;
    }

    /**
     * @param laptops the laptops to set
     */
    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
}
