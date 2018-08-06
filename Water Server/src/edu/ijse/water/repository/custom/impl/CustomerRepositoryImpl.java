/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom.impl;

import edu.ijse.water.entity.Customer;
import edu.ijse.water.repository.SuperRepositoryImpl;
import edu.ijse.water.repository.custom.CustomerRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class CustomerRepositoryImpl extends SuperRepositoryImpl<Customer, Integer> implements CustomerRepository{
    
    
    
    public CustomerRepositoryImpl() {
    }
    
   

    @Override
    public List<Customer> getCustomer(String wbid, String date,Session session) throws Exception {
          return session.createQuery("FROM Customer WHERE wbid='"+wbid+"' AND date='"+date+"' ORDER BY cid desc").list();
    }

    @Override
    public List<Customer> getCustomerByDate(String date, Session session) throws Exception {
        return session.createQuery("FROM Customer WHERE date='"+date+"'").list();
    }

    @Override
    public Customer getCustomerBy(String wbid, String date, Session session) throws Exception {
        return (Customer) session.createSQLQuery("SELECT cid,date,time,wbid FROM Customer WHERE wbid='"+wbid+"' AND date='"+date+"' ORDER BY cid desc");
    }
    
    
    
    
}
