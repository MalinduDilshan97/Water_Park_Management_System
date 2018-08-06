/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom.impl;

import edu.ijse.water.business.BOFactory;
import edu.ijse.water.business.custom.CategoryBO;
import edu.ijse.water.dto.CategoryDTO;
import edu.ijse.water.observer.Observer;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.reservation.impl.ReservationImpl;
import edu.ijse.water.service.custom.CategoryService;
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
public class CategoryServiceImpl extends UnicastRemoteObject implements CategoryService,Subject{
    
    private CategoryBO categoryBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<CategoryService> catResBook = new ReservationImpl<>();
    
    public CategoryServiceImpl()throws RemoteException{
        categoryBO=(CategoryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CATEGORY);
    }

    @Override
    public boolean addCategory(CategoryDTO categoryDTO) throws Exception {
        boolean result = categoryBO.addCategory(categoryDTO);
        notifyObservers();
        return result;
    }
    
    @Override
    public CategoryDTO searchCategory(String catId) throws Exception {
        return categoryBO.searchCategory(catId);
    }
    
    @Override
    public boolean deleteCategory(String catId) throws Exception {
        boolean result = false;
        if (catResBook.reserve(catId, this, true)) {
            result = categoryBO.deleteCategory(catId);
            notifyObservers();
            if (catResBook.isInternalReservation(catId)){
                release(catId);
            }
        }
        return result;
    }
    
    @Override
    public boolean updateCategory(CategoryDTO categoryDTO) throws Exception {
         boolean result = false;
        if (catResBook.reserve(categoryDTO.getCatId(), this, true)) {
            result = categoryBO.updateCategory(categoryDTO);
            notifyObservers();
            if (catResBook.isInternalReservation(categoryDTO.getCatId())){
                release(categoryDTO.getCatId());
            }            
        }
        return result;
    }
    
    @Override
    public List<CategoryDTO> getAllCategories() throws Exception {
        return categoryBO.getAllCategories();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return catResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return catResBook.release(id);
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
                    Logger.getLogger(CategoryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    

    

    

    

    
}
