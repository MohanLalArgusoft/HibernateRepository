/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatetry;

import com.argus.hibernatetry.Entity.Student;
import com.argus.hibernatetry.Entity.StudentName;
import org.hibernate.Query;
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

        StudentName sn = new StudentName(); //Embedded Entity
        sn.setFname("Mani");
        sn.setLname("KM");
        Student student = new Student(); //Entity
        student.setSid(1006);
        student.setSname(sn);
        student.setSmark(80);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);    // To Store into the table
//        student = session.get(Student.class, 1003);  // To Retrieve the from entity and embedded entity
        tx.commit();
        
        System.out.println(student);
        
    }
}
