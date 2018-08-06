/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom;

import edu.ijse.water.business.SuperBO;
import edu.ijse.water.dto.PaymentDTO;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public interface PaymentBO extends SuperBO{
    
    public List<PaymentDTO> getPayment(String date)throws Exception;
    
}
