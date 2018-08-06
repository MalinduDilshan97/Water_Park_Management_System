/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom.impl;

import edu.ijse.water.business.BOFactory;
import edu.ijse.water.business.custom.MessageBO;
import edu.ijse.water.dto.MessagesDTO;
import edu.ijse.water.observer.Observer;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.reservation.impl.ReservationImpl;
import edu.ijse.water.service.custom.MessageService;
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
public class MessageServiceImpl extends UnicastRemoteObject implements MessageService,Subject{
    
    private MessageBO messageBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<MessageService> messResBook = new ReservationImpl<>();
    
    public MessageServiceImpl()throws RemoteException{
        messageBO=(MessageBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.MESSAGE);
    }

    @Override
    public boolean addMessage(MessagesDTO messagesDTO) throws Exception {
        boolean result = messageBO.addMessage(messagesDTO);
        notifyObservers();
        return result;
    }

    @Override
    public List<MessagesDTO> getMessages(String date) throws Exception {
        return messageBO.getMessages(date);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return messResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return messResBook.release(id);
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
                    Logger.getLogger(MessageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
}
