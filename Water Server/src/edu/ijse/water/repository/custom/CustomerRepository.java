/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom;

import edu.ijse.water.entity.Customer;
import edu.ijse.water.repository.SuperRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author SL_WOLF
 */
public interface CustomerRepository extends SuperRepository<Customer, Integer>{
    
    public Customer getCustomerBy(String wbid,String date,Session session)throws Exception;
     
     public List<Customer> getCustomer(String wbid,String date,Session session)throws Exception;
     
     public List<Customer> getCustomerByDate(String date,Session session)throws Exception;
     
}
