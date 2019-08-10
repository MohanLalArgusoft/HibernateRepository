/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatedemoonetomany.entity;


import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author mohanlal
 */
@Entity
public class Attachment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Id
    private long aid;
    private String filename;
    private String filesize;
    private Timestamp ts;
    private byte blob;
    @ManyToOne
    private Personnel personnel;
    @ManyToOne
    private Proposal proposal;
    /**
     * @return the aid
     */
    public long getAid() {
        return aid;
    }

    /**
     * @param aid the aid to set
     */
    public void setAid(long aid) {
        this.aid = aid;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the filesize
     */
    public String getFilesize() {
        return filesize;
    }

    /**
     * @param filesize the filesize to set
     */
    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    /**
     * @return the ts
     */
    public Timestamp getTs() {
        return ts;
    }

    /**
     * @param ts the ts to set
     */
    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    /**
     * @return the blob
     */
    public byte getBlob() {
        return blob;
    }

    /**
     * @param blob the blob to set
     */
    public void setBlob(byte blob) {
        this.blob = blob;
    }

    /**
     * @return the personnel
     */
    public Personnel getPersonnel() {
        return personnel;
    }

    /**
     * @param personnel the personnel to set
     */
    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
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

    
}
