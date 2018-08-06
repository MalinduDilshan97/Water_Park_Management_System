/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom.impl;

import edu.ijse.water.business.BOFactory;
import edu.ijse.water.business.custom.GiftBO;
import edu.ijse.water.dto.GiftDTO;
import edu.ijse.water.observer.Observer;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.reservation.impl.ReservationImpl;
import edu.ijse.water.service.custom.GiftService;
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
public class GiftServiceImpl extends UnicastRemoteObject implements GiftService,Subject{
    
    private GiftBO giftBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<GiftService> giftResBook = new ReservationImpl<>();
    
    public GiftServiceImpl()throws RemoteException{
        giftBO=(GiftBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.GIFT);
    }

    @Override
    public boolean addGift(GiftDTO giftDTO) throws Exception {
        boolean result = giftBO.addGift(giftDTO);
        notifyObservers();
        return result;
    }

    @Override
    public GiftDTO searchGift(String gid) throws Exception {
        return giftBO.searchGift(gid);
    }

    @Override
    public boolean deleteGift(String gid) throws Exception {
         boolean result = false;
        if (giftResBook.reserve(gid, this, true)) {
            result = giftBO.deleteGift(gid);
            notifyObservers();
            if (giftResBook.isInternalReservation(gid)){
                release(gid);
            }
        }
        return result;
    }

    @Override
    public boolean updateGift(GiftDTO giftDTO) throws Exception {
         boolean result = false;
        if (giftResBook.reserve(giftDTO.getGid(), this, true)) {
            result = giftBO.updateGift(giftDTO);
            notifyObservers();
            if (giftResBook.isInternalReservation(giftDTO.getGid())){
                release(giftDTO.getGid());
            }            
        }
        return result;
    }

    @Override
    public List<GiftDTO> getAllGifts() throws Exception {
        return giftBO.getAllGifts();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return giftResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
       return giftResBook.release(id);
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
                    Logger.getLogger(GiftServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
