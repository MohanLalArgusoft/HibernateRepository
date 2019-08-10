/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatedemoonetomany;

import com.argus.hibernatedemoonetomany.entity.Attachment;
import com.argus.hibernatedemoonetomany.entity.Personnel;
import com.argus.hibernatedemoonetomany.entity.Proposal;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mohanlal
 */
enum QualificationLevel {
    Beginner, Intermediate, Pro
}

public class MainClass {

        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
    public static void main(String[] args) {

        MainClass m = new MainClass();
        int i = Integer.parseInt(args[0]);
        switch(i){
            case 1:
                m.insert();
                break;
            case 2:
                m.update();
                break;
            case 3:
                m.delete();
                break;
            
        }
//========Inserting single row along with onetomany mapping
        

//        Proposal pro = new Proposal();
//        pro.setDocId(1001);
//        pro.setTitle("Title of Proposal 1");
//        pro.setComment("Comments for proposal 1");
//
//        Personnel person = new Personnel();
//        person.setName("Monil");
//        person.setQualificationlevel(QualificationLevel.Beginner + "");
//        person.setPhone("8989887676");
//
//        Attachment attach = new Attachment();
//        attach.setFilename("filename_ONE");
//        attach.setFilesize("25Mb");
//        attach.setTs(currentTimestamp);
//        attach.setBlob((byte) 9090);
//
//        pro.getPersonnel().add(person);
//        pro.getAttachment().add(attach);
//        
//        person.setProposal(pro);
//        person.getAttachment().add(attach);
//        
//        attach.setPersonnel(person);
//        attach.setProposal(pro);
//        
//        Configuration con = new Configuration().configure().addAnnotatedClass(Proposal.class).addAnnotatedClass(Personnel.class).addAnnotatedClass(Attachment.class);
//        SessionFactory sf = con.buildSessionFactory();
//        Session session = sf.openSession();
//        Transaction tx = session.beginTransaction();
//        session.save(pro);
//        session.save(person);
//        session.save(attach);
//        tx.commit();
//        sf.close();

    }
    
    public void insert(){
        
//========Inserting many rows along with onetomany mapping

        Proposal pro = new Proposal();
        pro.setDocId(1001);
        pro.setTitle("Title of Proposal 1");
        pro.setComment("Comments for proposal 1");

        Personnel person1 = new Personnel();
        person1.setName("Monil");
        person1.setQualificationlevel(QualificationLevel.Beginner + "");
        person1.setPhone("8989887676");
        
        Personnel person2 = new Personnel();
        person2.setName("Mohan Lal");
        person2.setQualificationlevel(QualificationLevel.Pro + "");
        person2.setPhone("8767689898");

        Attachment attach11 = new Attachment();
        attach11.setFilename("filename_ONE");
        attach11.setFilesize("25Mb");
        attach11.setTs(currentTimestamp);
        attach11.setBlob((byte) 9090);
        
        Attachment attach12 = new Attachment();
        attach12.setFilename("filename_ONE");
        attach12.setFilesize("25Mb");
        attach12.setTs(currentTimestamp);
        attach12.setBlob((byte) 9090);
        
        Attachment attach21 = new Attachment();
        attach21.setFilename("filename_ONE");
        attach21.setFilesize("25Mb");
        attach21.setTs(currentTimestamp);
        attach21.setBlob((byte) 9090);
        
        Attachment attach22 = new Attachment();
        attach22.setFilename("filename_ONE");
        attach22.setFilesize("25Mb");
        attach22.setTs(currentTimestamp);
        attach22.setBlob((byte) 9090);
        
        Attachment attach23 = new Attachment();
        attach23.setFilename("filename_THREE");
        attach23.setFilesize("50Mb");
        attach23.setTs(currentTimestamp);
        attach23.setBlob((byte) 8090);

        pro.getPersonnel().add(person1);
        pro.getPersonnel().add(person2);
        pro.getAttachment().add(attach11);
        pro.getAttachment().add(attach12);
        pro.getAttachment().add(attach21);
        pro.getAttachment().add(attach22);
        pro.getAttachment().add(attach23);
        
        person1.setProposal(pro);
        person1.getAttachment().add(attach11);
        person1.getAttachment().add(attach12);
        
        person2.setProposal(pro);
        person2.getAttachment().add(attach21);
        person2.getAttachment().add(attach22);
        person2.getAttachment().add(attach23);

        
        attach11.setPersonnel(person1);
        attach12.setPersonnel(person1);
        attach21.setPersonnel(person2);
        attach22.setPersonnel(person2);
        attach23.setPersonnel(person2);

        attach11.setProposal(pro);
        attach12.setProposal(pro);
        attach21.setProposal(pro);
        attach22.setProposal(pro);
        attach23.setProposal(pro);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Proposal.class).addAnnotatedClass(Personnel.class).addAnnotatedClass(Attachment.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(pro);
        session.save(person1);
        session.save(person2);
        session.save(attach11);
        session.save(attach12);
        session.save(attach21);
        session.save(attach22);

        session.saveOrUpdate(pro);
//        session.saveOrUpdate(person2);    //This is not required
//        session.saveOrUpdate(attach23);   //this is not required 
        
        tx.commit();
        sf.close();
    }
    
    public void update(){
//========Updating the data from table.       

        
        Configuration con = new Configuration().configure().addAnnotatedClass(Proposal.class).addAnnotatedClass(Personnel.class).addAnnotatedClass(Attachment.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //Updating the Personnel table
        Personnel per = session.get(Personnel.class, new Long(1));
        per.setQualificationlevel(QualificationLevel.Pro+"");
        session.update(per); 
        
        //Updating the mapping between attachment and personnel
        Attachment att1 = session.get(Attachment.class, new Long(4));
        Personnel per1 = session.get(Personnel.class,new Long(1));
        att1.setPersonnel(per1);
        session.update(att1);
        
        tx.commit();
        sf.close();
        
    }
    
    public void delete(){
//========Deleting the data from table.       

     
        Configuration con = new Configuration().configure().addAnnotatedClass(Proposal.class).addAnnotatedClass(Personnel.class).addAnnotatedClass(Attachment.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Attachment v = session.get(Attachment.class, new Long(5));    //To delete single attachment.
        session.delete(v);
        
        Personnel p1 = session.get(Personnel.class, new Long(1));   //To delete singe personnel which deletes related attachments too.
        session.delete(p1);

        Proposal pro1 = session.get(Proposal.class, new Long(1));   //To delete singe proposal which deletes related personnel and attachments too.
        session.delete(pro1);


//        session.saveOrUpdate(pro);
        
        
        tx.commit();
        sf.close();
        
    }
}
