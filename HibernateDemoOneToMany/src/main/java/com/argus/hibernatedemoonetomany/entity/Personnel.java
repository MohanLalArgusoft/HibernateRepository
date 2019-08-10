/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatedemoonetomany.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author mohanlal
 */
@Entity
public class Personnel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Id
    private long pid;
    private String name;
    private String qualificationlevel;
    private String phone;
    @ManyToOne
    private Proposal proposal;
    @OneToMany(mappedBy = "personnel",orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Attachment> attachment = new ArrayList<>();

    /**
     * @return the qualificationlevel
     */
    public String getQualificationlevel() {
        return qualificationlevel;
    }

    /**
     * @param qualificationlevel the qualificationlevel to set
     */
    public void setQualificationlevel(String qualificationlevel) {
        this.qualificationlevel = qualificationlevel;
    }
    /**
     * @return the pid
     */
    public long getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(long pid) {
        this.pid = pid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the proposal
     */
    public Proposal getProposal() {
        return proposal;
    }

    /**
     * @param proposal the proposal to set
     */
    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    /**
     * @return the attachment
     */
    public List<Attachment> getAttachment() {
        return attachment;
    }

    /**
     * @param attachment the attachment to set
     */
    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }
    
}
