/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernateuserprofile;

import com.argus.hibernateuserprofile.entity.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mohanlal
 */
public class MainClass {

    public static void main(String[] args) {
        
        UserProfile up = new UserProfile();
        up.setID(1003);
        up.setName("Harish");
        up.setEmail("harish@gmail.com");
        up.setPhone("6789085134");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(UserProfile.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(up);  // To Insert into table 
        up = session.get(UserProfile.class, 1002);  // To Retrieve from table which id = 1002
        tx.commit();
        System.out.println(up);
    }
}
