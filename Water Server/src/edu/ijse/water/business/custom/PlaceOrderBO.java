/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom;

import edu.ijse.water.business.SuperBO;
import edu.ijse.water.dto.PlaceOrderDTO;

/**
 *
 * @author SL_WOLF
 */
public interface PlaceOrderBO extends SuperBO{
    
    public boolean placeOrder(PlaceOrderDTO placeOrderDTO)throws Exception;
    
}
