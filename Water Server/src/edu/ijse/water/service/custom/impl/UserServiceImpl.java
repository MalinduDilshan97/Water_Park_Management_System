/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom.impl;

import edu.ijse.water.business.BOFactory;
import edu.ijse.water.business.custom.UserBO;
import edu.ijse.water.dto.UserDTO;
import edu.ijse.water.observer.Observer;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.reservation.impl.ReservationImpl;
import edu.ijse.water.service.custom.UserService;
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
public class UserServiceImpl extends UnicastRemoteObject implements UserService,Subject{
    
    private UserBO userBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<UserService> userResBook = new ReservationImpl<>();
    
    public UserServiceImpl()throws RemoteException{
        userBO=(UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER);
    }

    @Override
    public boolean addUser(UserDTO userDTO) throws Exception {
        boolean result = userBO.addUser(userDTO);
        notifyObservers();
        return result;
    }

    @Override
    public UserDTO searchUser(String uid) throws Exception {
        return userBO.searchUser(uid);
    }

    @Override
    public boolean deleteUser(String uid) throws Exception {
         boolean result = false;
        if (userResBook.reserve(uid, this, true)) {
            result = userBO.deleteUser(uid);
            notifyObservers();
            if (userResBook.isInternalReservation(uid)){
                release(uid);
            }
        }
        return result;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) throws Exception {
        boolean result = false;
        if (userResBook.reserve(userDTO.getUid(), this, true)) {
            result = userBO.updateUser(userDTO);
            notifyObservers();
            if (userResBook.isInternalReservation(userDTO.getUid())){
                release(userDTO.getUid());
            }            
        }
        return result;
    }

    @Override
    public List<UserDTO> getAllUsers() throws Exception {
        return userBO.getAllUsers();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return userResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return userResBook.release(id);
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
                    Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
