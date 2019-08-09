/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatetrymapping;

import com.argus.hibernatetrymapping.entity.Laptop;
import com.argus.hibernatetrymapping.entity.Employee;
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

        StudentName sn = new StudentName();
        sn.setFname("Arun");
        sn.setLname("Kumar");
        Student student = new Student();
        student.setSid(1006);
        student.setSname(sn);
        student.setSmark(80);
        
        Employee emp = new Employee();
        emp.setEid(1003);
        emp.setEname("Harish");
        emp.setEsalary(14021);
        
        Laptop lp = new Laptop();
        lp.setLid(2);
        lp.setLapname("Dell");
        
        emp.getLaptops().add(lp);
        lp.getEmployees().add(emp);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(emp);
        //session.save(lp);
        //student = session.get(Student.class, 1003);
        tx.commit();
        
        //System.out.println(student);
        
    }
}
