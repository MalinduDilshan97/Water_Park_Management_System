/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom;

import edu.ijse.water.dto.IDDTO;
import edu.ijse.water.repository.SuperRepository;

/**
 *
 * @author SL_WOLF
 */
public interface IDRepository extends SuperRepository<Object, String>{
    
    public Object getResult(IDDTO idDTO) throws Exception;
    
}
