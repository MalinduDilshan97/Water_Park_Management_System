/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom.impl;

import edu.ijse.water.entity.OrderDetails;
import edu.ijse.water.repository.custom.OrderDetailsRepository;
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository{
    

    public OrderDetailsRepositoryImpl() {
        
    }
    

    @Override
    public boolean addOrderDetails(OrderDetails orderDetails,Session session) throws Exception {
        return (session.merge(orderDetails) !=null);
//        Serializable save=session.save(orderDetails);
//        if(save != null){
//            return true;
//        }else{
//            return false;
//        }
    }

   
}
