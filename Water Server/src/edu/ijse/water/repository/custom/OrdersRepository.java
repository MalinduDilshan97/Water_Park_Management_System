/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom;

import edu.ijse.water.entity.Orders;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public interface OrdersRepository {
    public void setSession(Session session);
    public boolean addOrders(Orders orders)throws Exception;
    
}
