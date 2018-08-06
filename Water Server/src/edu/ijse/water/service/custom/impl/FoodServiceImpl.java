/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom.impl;

import edu.ijse.water.business.BOFactory;
import edu.ijse.water.business.custom.FoodBO;
import edu.ijse.water.dto.FoodDTO;
import edu.ijse.water.observer.Observer;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.reservation.impl.ReservationImpl;
import edu.ijse.water.service.custom.FoodService;
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
public class FoodServiceImpl extends UnicastRemoteObject implements FoodService,Subject{
    
    private FoodBO foodBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<FoodService> foodResBook = new ReservationImpl<>();
    
    public FoodServiceImpl()throws RemoteException{
        foodBO=(FoodBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.FOOD);
    }

    @Override
    public boolean addFood(FoodDTO foodDTO) throws Exception {
        boolean result = foodBO.addFood(foodDTO);
        notifyObservers();
        return result;
    }

    @Override
    public FoodDTO searchFood(String fid) throws Exception {
        return foodBO.searchFood(fid);
    }

    @Override
    public boolean deleteFood(String fid) throws Exception {
         boolean result = false;
        if (foodResBook.reserve(fid, this, true)) {
            result = foodBO.deleteFood(fid);
            notifyObservers();
            if (foodResBook.isInternalReservation(fid)){
                release(fid);
            }
        }
        return result;
    }

    @Override
    public boolean updateFood(FoodDTO foodDTO) throws Exception {
        boolean result = false;
        if (foodResBook.reserve(foodDTO.getFid(), this, true)) {
            result = foodBO.updateFood(foodDTO);
            notifyObservers();
            if (foodResBook.isInternalReservation(foodDTO.getFid())){
                release(foodDTO.getFid());
            }            
        }
        return result;
    }

    @Override
    public List<FoodDTO> getAllFoods() throws Exception {
        return foodBO.getAllFoods();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return foodResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return foodResBook.release(id);
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
                    Logger.getLogger(FoodServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
