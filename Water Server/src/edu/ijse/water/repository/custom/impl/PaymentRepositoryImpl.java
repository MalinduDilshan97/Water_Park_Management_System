/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom.impl;

import edu.ijse.water.entity.Payment;
import edu.ijse.water.repository.SuperRepositoryImpl;
import edu.ijse.water.repository.custom.PaymentRepository;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class PaymentRepositoryImpl extends SuperRepositoryImpl<Payment, Integer> implements PaymentRepository{

    public PaymentRepositoryImpl() {
    }

    @Override
    public List<Payment> getPayment(String date, Session session) throws Exception {
        return session.createQuery("FROM Payment WHERE date='"+date+"'").list();
    }
    
    
    
}
