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
import com.argus.hibernateauctions.entity.User;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
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
        Date d = new Date();
        Date bidD = new Date(2019-03-11);

        Category category = new Category();

        Item item1 = new Item();
        item1.setName("Colgate");
        item1.setDescription("Best Toothpaste");
        item1.setInitialPrice(new BigDecimal("10000"));
        item1.setReservePrice(new BigDecimal("120000"));
        item1.setStartDate((java.sql.Date) d1);
        item1.setEndDate((java.sql.Date) d2);
        item1.setState("FORSALE");
        item1.setApprovalDatetime((java.sql.Date) d1);

        User user1 = new User();
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

        Comment comment = new Comment();
        comment.setRating(4);
        comment.setText("GOOD");
        comment.setCommentcreated((java.sql.Date) d);

        BillingDetails bill = new BillingDetails();
        bill.setOwnername("MohanlalPR");

        CreditCard card = new CreditCard();
        card.setType("DebitCard");
        card.setNumber("1234-5678-9123-4567");
        card.setExpmonth("02");
        card.setExpyear("25");

        BankAccount acc = new BankAccount();
        acc.setNumber("123456789");
        acc.setBankname("Canara");
        acc.setSwift("MorningShift");

        bill.setCreditCard(card);
        bill.setBankAccount(acc);

        Bid bid = new Bid();
        bid.setAmount(new BigDecimal("1000000"));
        bid.setBidcreated((java.sql.Date) bidD);

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
                .addAnnotatedClass(User.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        tx.commit();
        sf.close();
    }
}
