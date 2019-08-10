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
import javax.persistence.OneToMany;

/**
 *
 * @author mohanlal
 */
@Entity
public class Proposal {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Id
    private long pid;
    private long docId;
    private String title;
    private String comment;
    @OneToMany(mappedBy = "proposal",orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Personnel> personnel = new ArrayList<>();
    @OneToMany(mappedBy = "proposal",orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Attachment> attachment = new ArrayList<>();
    
    
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
     * @return the docId
     */
    public long getDocId() {
        return docId;
    }

    /**
     * @param docId the docId to set
     */
    public void setDocId(long docId) {
        this.docId = docId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the personnel
     */
    public List<Personnel> getPersonnel() {
        return personnel;
    }

    /**
     * @param personnel the personnel to set
     */
    public void setPersonnel(List<Personnel> personnel) {
        this.personnel = personnel;
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
