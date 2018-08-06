/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom;

import edu.ijse.water.dto.PlaceOrderDTO;
import edu.ijse.water.service.SuperService;

/**
 *
 * @author SL_WOLF
 */
public interface PlaceOrderService extends SuperService{
    
    public boolean placeOrder(PlaceOrderDTO placeOrderDTO)throws Exception;
    
}
