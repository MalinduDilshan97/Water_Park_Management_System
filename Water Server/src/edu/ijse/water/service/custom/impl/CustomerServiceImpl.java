/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom.impl;

import edu.ijse.water.business.BOFactory;
import edu.ijse.water.business.custom.CustomerBO;
import edu.ijse.water.dto.CustomerDTO;
import edu.ijse.water.observer.Observer;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.reservation.impl.ReservationImpl;
import edu.ijse.water.service.custom.CustomerService;
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
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService,Subject{
    
    private CustomerBO customerBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<CustomerService> cusResBook = new ReservationImpl<>();
    
   public CustomerServiceImpl()throws RemoteException{
       customerBO=(CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
   }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        boolean result = customerBO.addCustomer(customerDTO);
        notifyObservers();
        return result;
    }
    
     @Override
    public List<CustomerDTO> getCustomer(String wbid, String date) throws Exception {
        return customerBO.getCustomer(wbid, date);
    }
    
    @Override
    public List<CustomerDTO> getCustomerByDate(String date) throws Exception {
        return customerBO.getCustomerByDate(date);
    }
    
    @Override
    public CustomerDTO getCustomerBy(String wbid, String date) throws Exception {
        return customerBO.getCustomerBy(wbid, date);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return cusResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return cusResBook.release(id);
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
                    Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    

    

   
    
}
