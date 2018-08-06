/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.controller;

import edu.ijse.water.dto.IDDTO;
import edu.ijse.water.proxy.ProxyHandler;
import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.custom.IDService;
import java.text.NumberFormat;

/**
 *
 * @author SL_WOLF
 */
public class ManageIDController {
    
    public static String getNewID(IDDTO idDTO, String prifix) throws Exception {
        IDService iDService = (IDService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ID);
        String lastId = iDService.getResult(idDTO);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prifix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newID = numberFormat.format(id);
            return prifix + newID;
        } else {
            return prifix + "001";
        }
        
    }
    
}
