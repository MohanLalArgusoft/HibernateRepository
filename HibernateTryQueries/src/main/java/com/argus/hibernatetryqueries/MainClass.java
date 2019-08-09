/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatetryqueries;

import com.argus.hibernatetryqueries.entity.Address;
import com.argus.hibernatetryqueries.entity.Education;
import com.argus.hibernatetryqueries.entity.Student;
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

        Address address = new Address();
        address.setStreet1("Vengatesh Street");
        address.setStreet2("Fort");
        address.setCity("Salem");
        address.setState("Tamil Nadu");
        address.setCountry("India");
        
        Student student = new Student();
        student.setFirstName("Arun");
        student.setMiddleName("Kumar");
        student.setLastName("K M");
        student.setPrefix("MR.");
        student.setSuffix("M.E");
        student.setEmail("arunkumar@argusoft.in");
        student.setPhone("9898887088");
        student.setAddress(address);
        
        Education education = new Education();
        education.setDegreeType("Engineering");
        education.setDegreeDescription("Computer Science and Engineering");
        education.setSchool("VVMHSS");
        education.setYear(2018);
        
        student.setEducation(education);
        education.setStudent(student);
        
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Education.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        session.save(education);
        tx.commit();
        sf.close();
        
    }
}
