/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom.impl;

import edu.ijse.water.business.BOFactory;
import edu.ijse.water.business.custom.PaymentBO;
import edu.ijse.water.dto.PaymentDTO;
import edu.ijse.water.observer.Observer;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.reservation.impl.ReservationImpl;
import edu.ijse.water.service.custom.PaymentService;
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
public class PaymentServiceImpl extends UnicastRemoteObject implements PaymentService,Subject{
    
    private PaymentBO paymentBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<PaymentService> payResBook = new ReservationImpl<>();
    
    public PaymentServiceImpl()throws RemoteException{
        paymentBO=(PaymentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);
    }

    @Override
    public List<PaymentDTO> getPayment(String date) throws Exception {
        return paymentBO.getPayment(date);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return payResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return payResBook.release(id);
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
                    Logger.getLogger(PaymentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
