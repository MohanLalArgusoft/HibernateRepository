/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.hibernateauctions;

import com.argus.hibernateauctions.entity.Address;
import com.argus.hibernateauctions.entity.BankAccount;
import com.argus.hibernateauctions.entity.Bid;
import com.argus.hibernateauctions.entity.BillingDetails;
import com.argus.hibernateauctions.entity.Category;
import com.argus.hibernateauctions.entity.Comment;
import com.argus.hibernateauctions.entity.CreditCard;
import com.argus.hibernateauctions.entity.Item;
import com.argus.hibernateauctions.entity.Shipment;
import com.argus.hibernateauctions.entity.Useruser;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.*;
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
        Date d1 = new Date(2019 - 01 - 22);
        Date d2 = new Date(2019 - 03 - 22);
        java.sql.Date d = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Date bidD = new Date(2019 - 03 - 11);

        Category category = new Category();
        category.setName("Electronics");
        Category category1 = new Category();
        category1.setName("Mobile Phones");

        category1.setParent(category);
        category.getChildren().add(category1);

        Item item1 = new Item();
        item1.setName("Oldest Mobile");
        item1.setDescription("The First launched mobile in this world.");
        item1.setInitialPrice(new BigDecimal("10000"));
        item1.setReservePrice(new BigDecimal("120000"));
        item1.setStartDate((java.sql.Date) d1);
        item1.setEndDate((java.sql.Date) d2);
        item1.setState("FORSALE");
        item1.setApprovalDatetime((java.sql.Date) d1);

        Useruser user1 = new Useruser();
        user1.setFirstname("Mohanlal");
        user1.setLastname("PR");
        user1.setUsername("MohanlalPR");
        user1.setPassword("123");
        user1.setEmail("abc@gmail.com");
        user1.setRanking(4);
        user1.setAdmin(true);

        Address add1 = new Address();
        add1.setStreet("Shevapet");
        add1.setZipcode("636002");
        add1.setCity("Salem");

        Comment comment1 = new Comment();
        comment1.setRating(4);
        comment1.setText("GOOD");
        comment1.setCommentcreated((java.sql.Date) d);

        BillingDetails bill1 = new BillingDetails();
        bill1.setOwnername("MohanlalPR");

        CreditCard card1 = new CreditCard();
        card1.setOwnername("MohanlalPR");
        card1.setType("DebitCard");
        card1.setNumber("1234-5678-9123-4567");
        card1.setExpmonth("02");
        card1.setExpyear("25");

        BankAccount acc1 = new BankAccount();
        acc1.setNumber("123456789");
        acc1.setBankname("Canara");
        acc1.setSwift("MorningShift");

//        bill1.setCreditCard(card1);
//        bill1.setBankAccount(acc1);
        Bid bid1 = new Bid();
        bid1.setAmount(new BigDecimal("150000"));
        bid1.setBidcreated((java.sql.Date) bidD);

        Shipment ship1 = new Shipment();
        ship1.setInspectionperioddays(3);
        ship1.setState("On Package");
        ship1.setShipmentcreated((java.sql.Date) d);

        category.getItems().add(item1);

        item1.setCategorys(category);
        item1.setUser(user1);
        item1.getBids().add(bid1);
        item1.setSuccessbid(bid1);
        item1.getComments().add(comment1);
        item1.setShipment(ship1);

        user1.getItems().add(item1);
        user1.getComments().add(comment1);
        user1.getBids().add(bid1);
        user1.getBiilingBillingDetailses().add(bill1);
        user1.setShipment(ship1);
        user1.setAddress(add1);

        comment1.setItem(item1);
        comment1.setUser(user1);

        add1.setUser(user1);
        add1.setShipment(ship1);
        add1.setBillingDetails(bill1);

        bill1.setUser(user1);
        bill1.setAddress(add1);

        bid1.setItem(item1);
        bid1.setSuccessitem(item1);
        bid1.setUser(user1);

        ship1.setItems(item1);
        ship1.setUser(user1);
        ship1.setAddress(add1);

        Configuration con = new Configuration().configure()
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(BankAccount.class)
                .addAnnotatedClass(Bid.class)
                .addAnnotatedClass(BillingDetails.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(CreditCard.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Shipment.class)
                .addAnnotatedClass(Useruser.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            session.save(user1);
            session.save(category);
            session.save(item1);
            session.save(comment1);
            //session.save(bill1);
            session.save(add1);
            session.save(bid1);
            session.save(ship1);
            session.save(card1);

            tx.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
        sf.close();

        
    }
}
