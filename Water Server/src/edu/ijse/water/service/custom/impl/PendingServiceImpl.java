/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom.impl;

import edu.ijse.water.business.BOFactory;
import edu.ijse.water.business.custom.PendingBO;
import edu.ijse.water.dto.PendingDTO;
import edu.ijse.water.observer.Observer;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.reservation.impl.ReservationImpl;
import edu.ijse.water.service.custom.PendingService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SL_WOLF
 */
public class PendingServiceImpl extends UnicastRemoteObject implements PendingService,Subject{
    
    private PendingBO pendingBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<PendingService> penResBook = new ReservationImpl<>();
    
    public PendingServiceImpl()throws RemoteException{
        pendingBO=(PendingBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PENDING);
    }

    @Override
    public boolean addDetail(PendingDTO pendingDTO) throws Exception {
        boolean result = pendingBO.addDetail(pendingDTO);
        notifyObservers();
        return result;
    }
    
    @Override
    public boolean addAll(ArrayList<PendingDTO> allDTOs) throws Exception {
        boolean result=pendingBO.addAll(allDTOs);
        notifyObservers();
        return result;
    }
    
    @Override
    public List<PendingDTO> getAll(String wbid) throws Exception {
        return pendingBO.getAll(wbid);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return penResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return penResBook.release(id);
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        alObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(() -> {
            for (Observer observer : alObservers) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(PendingServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    

    
    
}
