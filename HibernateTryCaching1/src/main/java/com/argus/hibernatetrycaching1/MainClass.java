/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernatetrycaching1;

import com.argus.hibernatetrycaching1.entity.Legend;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author mohanlal
 */
public class MainClass {
    public static void main(String[] args) {

        Legend l = new Legend();
        l.setLid(3);
        l.setLname("Harish");
        l.setExtra("Oooooo");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Legend.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        Query q1 = session.createQuery("from Legend where lid=1");
        q1.setCacheable(true);
        l=(Legend) q1.uniqueResult();
//        l = session.get(Legend.class, 1);  
        System.out.println(l);
        session.getTransaction().commit();
        
        Session session2 = sf.openSession();
        session2.beginTransaction();
        Query q2 = session2.createQuery("from Legend where lid=1");
        q2.setCacheable(true);
        l=(Legend) q2.uniqueResult();
//        l = session2.get(Legend.class, 1); 
        System.out.println(l);
        session2.getTransaction().commit();
        
        Session session3 = sf.openSession();
        session3.beginTransaction();
        Query q3 = session3.createQuery("from Legend");
        q3.setCacheable(true);
        
        List legends = q3.list();
        Iterator i = legends.listIterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        
        List<Legend> list = q3.list();
        for(Legend li : list){
            System.out.println(li);
        }
        session3.getTransaction().commit();
        
        sf.close();
    }
}
