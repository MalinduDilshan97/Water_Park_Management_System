/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom;

import edu.ijse.water.entity.OrderDetails;
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public interface OrderDetailsRepository extends Serializable{
    public boolean addOrderDetails(OrderDetails orderDetails,Session session)throws Exception;
    
    
}
