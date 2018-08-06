/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom.impl;

import edu.ijse.water.business.BOFactory;
import edu.ijse.water.business.custom.IDBO;
import edu.ijse.water.dto.IDDTO;
import edu.ijse.water.service.custom.IDService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author SL_WOLF
 */
public class IDServiceImpl extends UnicastRemoteObject implements IDService{
    
    private IDBO idbo;
    
    public IDServiceImpl()throws RemoteException{
        idbo=(IDBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ID);
    }

    @Override
    public String getResult(IDDTO idDTO) throws Exception {
        return idbo.getResult(idDTO);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
