/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.impl;

import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.SuperService;
import edu.ijse.water.service.custom.impl.CategoryServiceImpl;
import edu.ijse.water.service.custom.impl.CustomerServiceImpl;
import edu.ijse.water.service.custom.impl.FoodServiceImpl;
import edu.ijse.water.service.custom.impl.GiftServiceImpl;
import edu.ijse.water.service.custom.impl.IDServiceImpl;
import edu.ijse.water.service.custom.impl.MessageServiceImpl;
import edu.ijse.water.service.custom.impl.PaymentServiceImpl;
import edu.ijse.water.service.custom.impl.PendingServiceImpl;
import edu.ijse.water.service.custom.impl.PlaceOrderServiceImpl;
import edu.ijse.water.service.custom.impl.ServiceServiceImpl;
import edu.ijse.water.service.custom.impl.UserServiceImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author SL_WOLF
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory{
    
    public static ServiceFactory serviceFactory;
    
    private ServiceFactoryImpl() throws RemoteException{
        
    }
    
    public static ServiceFactory getInstance() throws RemoteException{
        if (serviceFactory == null){
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch(type){
            case CATEGORY:
                return new CategoryServiceImpl();
            case SERVICE:
                return new ServiceServiceImpl();
            case FOOD:
                return new FoodServiceImpl();
            case GIFT:
                return new GiftServiceImpl();
            case USER:
                return new UserServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
            case PENDING:
                return new PendingServiceImpl();
            case PLACE_ORDER:
                return new PlaceOrderServiceImpl();
            case PAYMENT:
                return new PaymentServiceImpl();
            case MESSAGE:
                return new MessageServiceImpl();
            case ID:
                return new IDServiceImpl();
            default:
                return null;
        }
    }
    
}
