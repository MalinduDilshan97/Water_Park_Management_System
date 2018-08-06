/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom.impl;

import edu.ijse.water.business.BOFactory;
import edu.ijse.water.business.custom.ServiceBO;
import edu.ijse.water.dto.ServiceDTO;
import edu.ijse.water.observer.Observer;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.reservation.impl.ReservationImpl;
import edu.ijse.water.service.custom.ServiceService;
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
public class ServiceServiceImpl extends UnicastRemoteObject implements ServiceService,Subject{
    
    private ServiceBO serviceBO;
     private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<ServiceService> serResBook = new ReservationImpl<>();
    
    public ServiceServiceImpl()throws RemoteException{
        serviceBO=(ServiceBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SERVICE);
    }

    @Override
    public boolean addService(ServiceDTO serviceDTO) throws Exception {
         boolean result = serviceBO.addService(serviceDTO);
        notifyObservers();
        return result;
    }

    @Override
    public ServiceDTO searchService(String serviceId) throws Exception {
        return  serviceBO.searchService(serviceId);
    }

    @Override
    public boolean deleteService(String serviceId) throws Exception {
        boolean result = false;
        if (serResBook.reserve(serviceId, this, true)) {
            result = serviceBO.deleteService(serviceId);
            notifyObservers();
            if (serResBook.isInternalReservation(serviceId)){
                release(serviceId);
            }
        }
        return result;
    }

    @Override
    public boolean updateService(ServiceDTO serviceDTO) throws Exception {
        boolean result = false;
        if (serResBook.reserve(serviceDTO.getServiceId(), this, true)) {
            result = serviceBO.updateService(serviceDTO);
            notifyObservers();
            if (serResBook.isInternalReservation(serviceDTO.getServiceId())){
                release(serviceDTO.getServiceId());
            }            
        }
        return result;
    }

    @Override
    public List<ServiceDTO> getAllServices() throws Exception {
        return serviceBO.getAllServices();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return serResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return serResBook.release(id);
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
                    Logger.getLogger(ServiceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
