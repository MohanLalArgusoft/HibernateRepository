/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatetryqueries.entity;

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
public class Education {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Id
    private long eid;
    private String degreeType;
    private String degreeDescription;
    private int year;
    private String school;
    @OneToOne(mappedBy = "education")
    private Student student;
    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    
    /**
     * @return the eid
     */
    public long getEid() {
        return eid;
    }

    /**
     * @param eid the eid to set
     */
    public void setEid(long eid) {
        this.eid = eid;
    }

    /**
     * @return the degreeType
     */
    public String getDegreeType() {
        return degreeType;
    }

    /**
     * @param degreeType the degreeType to set
     */
    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    /**
     * @return the degreeDescription
     */
    public String getDegreeDescription() {
        return degreeDescription;
    }

    /**
     * @param degreeDescription the degreeDescription to set
     */
    public void setDegreeDescription(String degreeDescription) {
        this.degreeDescription = degreeDescription;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }
}
