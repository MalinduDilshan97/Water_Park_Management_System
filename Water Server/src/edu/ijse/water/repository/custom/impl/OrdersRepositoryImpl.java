/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom.impl;

import edu.ijse.water.entity.Orders;
import edu.ijse.water.repository.SuperRepositoryImpl;
import edu.ijse.water.repository.custom.OrdersRepository;
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class OrdersRepositoryImpl implements OrdersRepository{
    
    private Session session;

    public OrdersRepositoryImpl() {
    }

    @Override
    public void setSession(Session session) {
       this.session=session; 
    }

    @Override
    public boolean addOrders(Orders orders) throws Exception {
         Serializable save=session.save(orders);
        if(save != null){
            return true;
        }else{
            return false;
        }
    }
    
    
    
}
