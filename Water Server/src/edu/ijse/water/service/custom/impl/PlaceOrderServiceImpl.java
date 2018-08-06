/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom.impl;

import edu.ijse.water.business.BOFactory;
import edu.ijse.water.business.custom.PlaceOrderBO;
import edu.ijse.water.dto.PlaceOrderDTO;
import edu.ijse.water.observer.Observer;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.reservation.impl.ReservationImpl;
import edu.ijse.water.service.custom.PlaceOrderService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SL_WOLF
 */
public class PlaceOrderServiceImpl extends UnicastRemoteObject implements PlaceOrderService,Subject{
    
    PlaceOrderBO placeOrderBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<PlaceOrderService> orResBook = new ReservationImpl<>();
    
    public PlaceOrderServiceImpl()throws RemoteException{
        placeOrderBO=(PlaceOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PLACE_ORDER);
    }
    

    @Override
    public boolean placeOrder(PlaceOrderDTO placeOrderDTO) throws Exception {
        boolean result = placeOrderBO.placeOrder(placeOrderDTO);
        notifyObservers();
        return result;
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return orResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return orResBook.release(id);
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
                    Logger.getLogger(PlaceOrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
