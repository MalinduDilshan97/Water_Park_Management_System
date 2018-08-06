/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom;

import edu.ijse.water.business.SuperBO;
import edu.ijse.water.dto.IDDTO;

/**
 *
 * @author SL_WOLF
 */
public interface IDBO extends SuperBO{
    public String getResult(IDDTO idDTO) throws Exception;
}
