/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom;

import edu.ijse.water.dto.IDDTO;
import edu.ijse.water.service.SuperService;

/**
 *
 * @author SL_WOLF
 */
public interface IDService extends SuperService{
    
    public String getResult(IDDTO idDTO)throws Exception;
    
}
